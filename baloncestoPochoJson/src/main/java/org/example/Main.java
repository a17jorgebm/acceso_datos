package org.example;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Equipo equipo1 = new Equipo(10, "Tigres", 5, 800, 600);
        Equipo equipo2 = new Equipo(8, "Leones", 7, 750, 650);
        Equipo equipo3 = new Equipo(12, "Águilas", 3, 900, 550);
        Equipo equipo4 = new Equipo(7, "Panteras", 8, 700, 700);
        Equipo equipo5 = new Equipo(9, "Cóndores", 6, 780, 670);
        Equipo equipo6 = new Equipo(11, "Tiburones", 4, 820, 590);
        Equipo equipo7 = new Equipo(6, "Halcones", 9, 710, 730);

        Clasificacion clasificacion=new Clasificacion("ACB", Set.of(equipo1,equipo2,equipo3,equipo4,equipo5,equipo6,equipo7));

        System.out.println(clasificacion);
    }
}