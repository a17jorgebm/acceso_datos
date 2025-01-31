package org.example.ejerBasicoUsuario;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;

public class EntityManagerUtil {
    private static EntityManagerUtil instance;

    private HashMap<String, EntityManagerFactory> factories;

    private EntityManagerUtil(){
        this.factories=new HashMap<>();
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

    public EntityManagerFactory getEntityManagerFactory(String persistenceUnitName){
        if (
                !factories.containsKey(persistenceUnitName) ||
                        factories.get(persistenceUnitName)==null ||
                        factories.get(persistenceUnitName).isOpen()
        ){
            synchronized (EntityManagerUtil.class){
                if (
                        !factories.containsKey(persistenceUnitName) ||
                                factories.get(persistenceUnitName)==null ||
                                factories.get(persistenceUnitName).isOpen()
                ){
                    try{
                        EntityManagerFactory factory= Persistence.createEntityManagerFactory(persistenceUnitName);
                        factories.put(persistenceUnitName,factory);
                    }catch (Exception e){
                        System.out.println("Erro no Util: "+e.getMessage());
                    }
                }
            }
        }
        return factories.get(persistenceUnitName);
    }
}
