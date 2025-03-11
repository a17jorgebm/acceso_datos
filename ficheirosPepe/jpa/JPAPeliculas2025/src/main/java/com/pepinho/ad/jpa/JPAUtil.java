package com.pepinho.ad.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*
 * Por medio de esta clase se crea el EntityManagerFactory y el EntityManager.
 * De tipo Singleton con Thread Safe y Lazy Initialization.
 */
public class JPAUtil {
    public static final String UNIDAD_PERSISTENCIA = "peliculas";

    private static volatile EntityManagerFactory emFactory;

    private JPAUtil() {
    }


    public static EntityManagerFactory getEmFactory(String unidadPersistencia) {
        if (emFactory == null) {
            synchronized (JPAUtil.class) {
                if (emFactory == null) {
                    try {
                        return Persistence.createEntityManagerFactory(unidadPersistencia);
                    } catch (Exception e) {
                        System.out.println("e.getMessage() = " + e.getMessage());
                    }

                }
            }
        }
        return emFactory;
    }

    public static EntityManagerFactory getEmFactory() {
        return getEmFactory(UNIDAD_PERSISTENCIA);
    }


    public static EntityManager getEntityManager() {
        return getEmFactory().createEntityManager();
    }

    public static EntityManager getEntityManager(String unidadPersistencia) {
        return getEmFactory(unidadPersistencia).createEntityManager();
    }

    public static void close() {
        if (emFactory != null) {
            emFactory.close();
        }
    }
}

