package com.pepinho.ad.e05baloncesto.dao;

import java.util.List;

public class AppXestionAlumnos {

    public static void main(String[] args) {

        Dao<Alumno, String> dao = AlumnoDaoFactory.getAlumnoDao("memory");
        
        Alumno alumno = dao.get("Albert Camus");

        System.out.println("alumno = " + alumno);

//        dao.save(new Alumno("Lugwig Wittgenstein", "finlandia@gmail.com", 50));
//
        List<Alumno> alumnos = dao.getAll();
        for (Alumno a : alumnos){
            System.out.println("a = " + a);
        }


    }
}
