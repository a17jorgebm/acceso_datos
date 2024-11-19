package org.example.ejersTypeAdapter.examen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeTypeAdapter())
                .create();

        Examen e=new Examen(
                "Mates",
                LocalDateTime.of(
                    LocalDate.of(2023,11,12),
                    LocalTime.of(9,45,00)),
                List.of("Juan","Pepe","Herminio","Laura","Florinda")
                );

        //guardado de json
        Path ficheiro= Paths.get("src/main/java/org/example/ejersTypeAdapter/examen/accesoADatos.json");

        try(BufferedWriter outputStream=new BufferedWriter(new FileWriter(ficheiro.toFile()))){
            gson.toJson(e,Examen.class,outputStream);
        }catch (IOException exception){
            System.out.println("Errorcito escrindo ficheiro: " + exception.getMessage());
        }

        Examen e2=null;
        try(BufferedReader inputStream=new BufferedReader(new FileReader(ficheiro.toFile()))){
            e2=gson.fromJson(inputStream,Examen.class);
        }catch (IOException exception){
            System.out.println("Errorcito escrindo ficheiro: " + exception.getMessage());
        }
        System.out.println(e2);
    }
}
