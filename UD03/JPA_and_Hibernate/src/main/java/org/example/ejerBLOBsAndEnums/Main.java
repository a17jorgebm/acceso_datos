package org.example.ejerBLOBsAndEnums;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.EntityManagerUtil;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = EntityManagerUtil.getInstance().getEntityManager("jpa-hibernate-sqlite-blobs");
        EntityManagerFactory entityManagerFactoryH2 = EntityManagerUtil.getInstance().getEntityManager("jpa-hibernate-h2-blobs");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityManager entityManagerH2 = entityManagerFactoryH2.createEntityManager();

        entityManager.getTransaction().begin();

        Document document = new Document("Ola que tal", null);
        entityManager.persist(document);

        entityManager.getTransaction().commit();


        //h2
        entityManagerH2.getTransaction().begin();

        Document document2 = new Document("Ola que tal", null);
        document2.setDia(Dia.MARTES);
        entityManagerH2.persist(document2);

        entityManagerH2.getTransaction().commit();
    }
}
