package org.example.ejerBasicoUsuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory=EntityManagerUtil.getInstance().getEntityManagerFactory("ejer-usuario-h2");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Usuario usuario=new Usuario("Pepe","Villuela","pepe@gmail.com");
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
