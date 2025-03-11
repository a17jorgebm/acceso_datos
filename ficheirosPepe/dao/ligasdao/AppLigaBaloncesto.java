/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.ad.e05baloncesto.basketdao;

import java.nio.file.Paths;
import java.util.*;

//import org.apache.pdfbox.pdmodel.PDDocument;

//import java.util.HashSet;
//import java.util.TreeSet;

/**
 * @author pepecalo
 */
public class AppLigaBaloncesto {

    public AppLigaBaloncesto() {
    }

    /**
     * @param args argumentos desde la línea de órdenes
     */
    public static void main(String[] args) {

//        EquipoFileDAO dao = EquipoFileDAO.getInstance("e:\\equipos.dat");

        Equipo e1 = new Equipo("Real Madrid", 18, 5, 1920, 1695);
        Equipo e2 = new Equipo("FC Barcelona", 22, 2, 1785, 1585);
        Equipo e3 = new Equipo("Manresa", 15, 7, 1903, 1808);
        Equipo e4 = new Equipo("Valencia", 14, 8, 1834, 1760);
        Equipo e5 = new Equipo("Obradoiro", 23, 1, 2834, 1560);
        Equipo e6 = new Equipo("Obradoiro", 26, 1, 2834, 1560);


//        // Creo clasificación:
        Clasificacion clasificacion = new Clasificacion();
        clasificacion.addEquipos(new TreeSet<>(List.of(e1, e2, e3, e4, e5, e6)));

        Clasificacion clasificacionfutbol = new Clasificacion("Liga futbol");
        clasificacionfutbol.addEquipos(new TreeSet<>(List.of(e1, e2, e3, e4, e5, e6)));


        EquipoFileDAO equipoFileDAO = EquipoFileDAO.getInstance("equipos.dat");


        // Creo DAO de clasificación:
        Dao<Clasificacion, String> daoClasificacion = ClasificacionDAOFactoy.getClasificacionDAO("json");

        daoClasificacion.save(clasificacionfutbol);

        // Guarda la clasificación en un fichero:
        daoClasificacion.save(clasificacion);

        // Leer la clasificación de un fichero:
        Clasificacion clasificacion2 = daoClasificacion.get("Liga ACB"); // Liga ACB.json

        System.out.println(clasificacion2);

        Clasificacion clasificacionf = daoClasificacion.get("Liga futbol"); // Liga futbol.json
        System.out.println(clasificacionf);


    }


}
