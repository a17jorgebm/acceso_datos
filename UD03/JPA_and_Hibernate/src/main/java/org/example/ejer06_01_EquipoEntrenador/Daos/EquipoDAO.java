package org.example.ejer06_01_EquipoEntrenador.Daos;

import jakarta.persistence.EntityManagerFactory;
import org.example.ejer06_01_EquipoEntrenador.JpaNbaManager;

public class EquipoDAO {
    EntityManagerFactory entityManagerFactory;

    EquipoDAO(){
        entityManagerFactory = JpaNbaManager.getInstance().getEntityManagerFactory();
    }


}
