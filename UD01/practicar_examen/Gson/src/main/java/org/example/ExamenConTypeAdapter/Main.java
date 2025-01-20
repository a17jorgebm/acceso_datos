package org.example.ExamenConTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Examen examen=new Examen(
                "pe",
                LocalDateTime.of(2024,12,13,12,45,34),
                List.of("Pepe","Juan")
        );


        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Examen.class, new ExamenAdapter())
                .create();

        String txtJson=gson.toJson(examen, Examen.class);
        System.out.println(txtJson);

        Examen examen2 = gson.fromJson(new StringReader(txtJson),Examen.class);
        System.out.println(examen2);
    }
}
