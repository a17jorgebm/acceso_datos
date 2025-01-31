package org.example.ejerBasicoUsuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestUsuario {
     private static EntityManagerFactory entityManagerFactory;
     private static EntityManager entityManager;

    @BeforeAll
    static void setUp(){
        entityManagerFactory=EntityManagerUtil.getInstance().getEntityManagerFactory("ejer-usuario-h2");
        entityManager=entityManagerFactory.createEntityManager();
    }

    @AfterAll
    static void tearDown(){
        entityManagerFactory.close();
        entityManager.close();
    }

    @Test
    void insertUser(){
        entityManager.getTransaction().begin();
        Usuario usuario=new Usuario("Usuario","Proba","proba@gmail.com");
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        assertNotNull(usuario.getId());
    }


}
