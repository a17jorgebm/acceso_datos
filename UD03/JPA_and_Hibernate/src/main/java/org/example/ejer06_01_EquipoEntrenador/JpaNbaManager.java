package org.example.ejer06_01_EquipoEntrenador;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class JpaNbaManager {
    private static final String DB_ENTITY = "dbEjer06_01_equipo_entrenador";

    private static JpaNbaManager instance;
    private EntityManagerFactory entityManagerFactory;

    private JpaNbaManager(){}

    public static JpaNbaManager getInstance(){
        if (instance == null)
            synchronized (JpaNbaManager.class){
                if (instance==null){
                    instance=new JpaNbaManager();
                }
            }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() throws IllegalArgumentException, PersistenceException {
        if (entityManagerFactory==null || !entityManagerFactory.isOpen()){
            synchronized (JpaNbaManager.class){
                if (entityManagerFactory==null || !entityManagerFactory.isOpen()){
                    entityManagerFactory= Persistence.createEntityManagerFactory(DB_ENTITY);
                }
            }
        }
        return entityManagerFactory;
    }
}
