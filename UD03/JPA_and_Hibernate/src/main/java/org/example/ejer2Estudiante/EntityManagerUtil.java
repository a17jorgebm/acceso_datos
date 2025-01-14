package org.example.ejer2Estudiante;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;

public class EntityManagerUtil {

    private static volatile EntityManagerUtil instance;
    private final HashMap<String, EntityManagerFactory> entityManagerFactories;

    private EntityManagerUtil() {
        this.entityManagerFactories=new HashMap<>();
    }

    public static EntityManagerUtil getInstance(){
        if (instance==null){
            synchronized (EntityManagerUtil.class){
                if (instance==null){
                    instance=new EntityManagerUtil();
                }
            }
        }
        return instance;
    }

    public EntityManagerFactory getEntityManager(String entityName){
        if (
                !this.entityManagerFactories.containsKey(entityName) ||
                this.entityManagerFactories.get(entityName)==null ||
                !this.entityManagerFactories.get(entityName).isOpen()
        ){
            synchronized (EntityManagerUtil.class){
                if (
                        !this.entityManagerFactories.containsKey(entityName) ||
                                this.entityManagerFactories.get(entityName)==null ||
                                !this.entityManagerFactories.get(entityName).isOpen()
                ) {
                    System.out.println("creo outra");
                    try{
                        var factory = Persistence.createEntityManagerFactory(entityName);
                        this.entityManagerFactories.put(entityName, factory);
                    }catch (Exception e){
                        throw e;
                    }
                }
            }
        }
        return this.entityManagerFactories.get(entityName);
    }
}
