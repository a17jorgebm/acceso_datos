package org.example.ejer05_3_Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.EntityManagerUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory= EntityManagerUtil.getInstance().getEntityManager("ejer05_03_persona");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellidos("Villuela Alverte");
        persona.setFechaNacimiento(LocalDate.of(2021,05,23));
        persona.setSexo(Sexo.HOMBRE);
        persona.setEstadoCivil(EstadoCivil.DIVORCIADO);

        entityManager.persist(persona);
        entityManager.getTransaction().commit();

        //faltame recuperar a persona
        //Persona persona1 = entityManager.find(Persona.class, )

        entityManager.close();
    }
}
