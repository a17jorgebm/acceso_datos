package com.pepinho.ad.biblioteca.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static com.pepinho.ad.biblioteca.model.BibliotecaLogger.LOG;

public class BibliotecaJpaSimpleManager {

    public static final String UNIDAD_PERSISTENCIA = "bibliotecaH2";

    private static BibliotecaJpaSimpleManager instance;

    /**
     * Cada entidad de persistencia tiene su propio EntityManagerFactory, por ello es necesario
     * tener un EntityManagerFactory por cada entidad de persistencia.
     * Sin embargo, es interesante tener varios EntityManager para una misma entidad de persistencia, para evitar
     * problemas de concurrencia.
     */
    private EntityManagerFactory emFactory;

    private BibliotecaJpaSimpleManager(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }


    public static BibliotecaJpaSimpleManager getInstance(String unidadPersistencia) {
        if (instance == null || !instance.emFactory.isOpen()) {
            synchronized (BibliotecaJpaSimpleManager.class) {
                if (instance == null || !instance.emFactory.isOpen()) {
                    try {
                        instance = new BibliotecaJpaSimpleManager(Persistence.createEntityManagerFactory(unidadPersistencia));
                    } catch (Exception e) {
                        LOG.error("Error crear el gestor de Factory de la biblioteca: " + e.getMessage());
                    }

                }
            }
        }
        return instance;
    }

    public EntityManagerFactory getEmFactory() {
        return (instance != null || getInstance(UNIDAD_PERSISTENCIA)!=null) ? instance.emFactory : null;
    }


    public EntityManager getEntityManager() {
        return getEmFactory().createEntityManager();
    }

    public EntityManager getEntityManager(String unidadPersistencia) {
        return getInstance(unidadPersistencia).emFactory.createEntityManager();
    }

    public static void close() {
        if (instance != null) {
            instance.emFactory.close();
            instance = null;
        }
    }
}
