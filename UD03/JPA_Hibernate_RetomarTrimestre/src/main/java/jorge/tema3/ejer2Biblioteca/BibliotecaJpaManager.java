package jorge.tema3.ejer2Biblioteca;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;

public class BibliotecaJpaManager {
    public static final String BIBLIOTECA_PERSISTENCE_UNITY_NAME = "jorge.tema3.ejer2Biblioteca";

    private static volatile BibliotecaJpaManager instance;
    private HashMap<String, EntityManagerFactory> entityManagerFactoryHashMap;

    private BibliotecaJpaManager(){
        entityManagerFactoryHashMap = new HashMap<>();
    }

    public BibliotecaJpaManager getInstance(){
        if (instance==null){
            synchronized (BibliotecaJpaManager.class){
                if (instance==null){
                    instance = new BibliotecaJpaManager();
                }
            }
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory(String persistenceUnitName){
        if (
                !entityManagerFactoryHashMap.containsKey(persistenceUnitName) ||
                        entityManagerFactoryHashMap.get(persistenceUnitName) == null ||
                        !entityManagerFactoryHashMap.get(persistenceUnitName).isOpen()
        ){
            synchronized(BibliotecaJpaManager.class){
                if (
                        !entityManagerFactoryHashMap.containsKey(persistenceUnitName) ||
                                entityManagerFactoryHashMap.get(persistenceUnitName) == null ||
                                !entityManagerFactoryHashMap.get(persistenceUnitName).isOpen()
                ){
                    try {
                        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
                        entityManagerFactoryHashMap.put(persistenceUnitName,entityManagerFactory);
                    }catch (Exception e){
                        System.out.println("Fallo ao intentar facer o entityManagerFactory: "+e.getMessage());
                    }
                }
            }
        }
        return entityManagerFactoryHashMap.get(persistenceUnitName);
    }
}
