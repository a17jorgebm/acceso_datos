package com.pepinho.ad.jpa;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.pepinho.ad.jpa.model.Entrenador;
import com.pepinho.ad.jpa.model.Equipo;
import com.pepinho.ad.jpa.model.EquipoJpaManager;
import com.pepinho.ad.jpa.model.json.GsonManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        HashSet<Equipo> equipos = new HashSet<>();

        var em  = EquipoJpaManager.getEntityManagerFactory("equiposDB")
                .createEntityManager();



//        Equipo oKc = em.find(Equipo.class, 21L);
//        Entrenador entrenador = new Entrenador("Mark Daigneault", 1000000, oKc,
//                LocalDate.of(1985, 8, 12));
//        entrenador.setIdEntrenador(null);
//
//        var txt = em.getTransaction();
//
//        txt.begin();
//        em.persist(entrenador);
//        txt.commit();



    // 12 de agosto de 1985


//        var gson = GsonManager.getInstance().getGson();

////        Equipo equipo = em.find(Equipo.class, 21L);
////        System.out.println(equipo);
////
////        // Mark Daigneault
////        Entrenador entrenador = new Entrenador("Mark Daigneault", 1000000, equipo,
////                LocalDate.of(1985, 8, 12)); // 12 de agosto de 1985
////
////        em.getTransaction().begin();
////        em.persist(entrenador);
////        em.getTransaction().commit();
//
//        List<Equipo> equipos = gson.fromJson(Files.newBufferedReader(Path.of("equipos.json")), new TypeToken<List<Equipo>>(){}.getType());
//        System.out.println(equipos);
//
//        for (Equipo p: equipos){
//            p.setIdEquipo(null);
//            em.getTransaction().begin();
//            em.persist(p);
//            em.getTransaction().commit();
//        }

    }
}