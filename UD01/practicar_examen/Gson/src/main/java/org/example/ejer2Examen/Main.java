package org.example.ejer2Examen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Examen examen=new Examen(
                "naturales",
                LocalDateTime.of(2024,9,15,9,45),
                List.of("Paco","Pepe")
        );

        System.out.println(examen);

        Gson gson=new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeSerializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .registerTypeAdapter(Examen.class, new ExamenSerializer())
                .registerTypeAdapter(Examen.class, new ExamenDeserializer())
                .setPrettyPrinting()
                .create();


        String a=gson.toJson(examen);
        System.out.println(a);

        Examen examen1= gson.fromJson(a,Examen.class);
        System.out.println(examen1);

    }
}
