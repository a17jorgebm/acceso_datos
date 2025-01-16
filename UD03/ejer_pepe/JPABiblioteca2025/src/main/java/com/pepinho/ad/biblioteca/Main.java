package com.pepinho.ad.biblioteca;

import com.pepinho.ad.biblioteca.model.BibliotecaJpaManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {


    public static void main(String[] args) {
        EntityManagerFactory emf = BibliotecaJpaManager.getEntityManagerFactory(BibliotecaJpaManager.BIBLIOTECA_H2);
        EntityManagerFactory emf2 = BibliotecaJpaManager.getEntityManagerFactory(BibliotecaJpaManager.BIBLIOTECA_H2);
        EntityManagerFactory emfp = BibliotecaJpaManager.getEntityManagerFactory(BibliotecaJpaManager.BIBLIOTECA_POSTGRES);


        if(emf!=emf2){
            System.out.println("Son diferentes");
        } else {
            System.out.println("Son iguais");
        }

        EntityManager em = emf.createEntityManager();

        System.out.println("Funciona");
    }


}
