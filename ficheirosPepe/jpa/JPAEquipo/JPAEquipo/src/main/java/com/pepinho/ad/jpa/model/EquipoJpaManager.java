package com.pepinho.ad.jpa.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;
import static com.pepinho.ad.jpa.model.PepinhoLogger.LOG;


public class EquipoJpaManager {

    public static final String BIBLIOTECA_H2 = "equiposH2";
    public static final String BIBLIOTECA_POSTGRES = "equiposPostgres";


    private static final Map<String, EntityManagerFactory> instancies = new HashMap<>();

    private EquipoJpaManager() {
    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia) {
        return !instancies.containsKey(unidadPersistencia) || instancies.get(unidadPersistencia)== null ||
                !instancies.get(unidadPersistencia).isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia) {
        if (isEntityManagerFactoryClosed(unidadPersistencia)) {
            synchronized (EquipoJpaManager.class) {
                if (isEntityManagerFactoryClosed(unidadPersistencia)) {
                    try {
                        instancies.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));
                    } catch (Exception e) {
                        LOG.error("Erro ó crear a unidade de persistencia " + unidadPersistencia +
                                ": " + e.getMessage());
                    }
                }
            }
        }
        return instancies.get(unidadPersistencia);
    }


    public static EntityManager getEntityManager(String persistenceUnitName) {
        return getEntityManagerFactory(persistenceUnitName).createEntityManager();
    }


    public static void close(String persistenceUnitName) {
        if (instancies.containsKey(persistenceUnitName)) {
            instancies.get(persistenceUnitName).close();
            instancies.remove(persistenceUnitName);
        }
    }


}
