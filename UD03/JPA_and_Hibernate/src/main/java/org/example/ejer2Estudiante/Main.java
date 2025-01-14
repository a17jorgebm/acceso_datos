package org.example.ejer2Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /*
               var emf = Persistence.createEntityManagerFactory("jpa-hibernate-h2-estudiantes");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        var e1=new Estudiante("paco","garcia", LocalDate.of(2024,12,13));
        entityManager.persist(e1);

        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
         */
        EntityManagerFactory factory = EntityManagerUtil.getInstance().getEntityManager("jpa-hibernate-h2-estudiantes");
        EntityManagerFactory factory2 = EntityManagerUtil.getInstance().getEntityManager("jpa-hibernate-h2-estudiantes");

        if (factory==factory2){
            System.out.println("son iguales");
        }else {
            System.out.println("nope");
        }

    }
}
