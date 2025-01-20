package org.example.ejer2Examen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ejer2ExamenConArray {
    public static void main(String[] args) {
        ArrayList<Examen> examenes = new ArrayList<>();
        for (int i=0;i<1000;i++){
            examenes.add(new Examen(
                    "naturales"+i,
                    LocalDateTime.of(2024,12,5,21,23,54),
                    List.of("Pepe","Juan","Paco")
            ));
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .registerTypeAdapter(Examen.class, new ExamenDeserializer())
                .registerTypeAdapter(Examen.class, new ExamenSerializer())
                .registerTypeAdapter(new TypeToken<List<Examen>>(){}.getType(),new ListaExamenDeserializer())
                .registerTypeAdapter(new TypeToken<List<Examen>>(){}.getType(), new ListaExamenSerializer())
                .create();

        Path file= Paths.get("src/main/java/org/example/ejer2Examen/examenes.json");
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.toFile()));
                ){
            gson.toJson(examenes, new TypeToken<List<Examen>>(){}.getType(), bufferedWriter);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        // Then read from the file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toFile()))) {
            List<Examen> examenesDoArquivo = gson.fromJson(bufferedReader, new TypeToken<List<Examen>>() {}.getType());
            examenesDoArquivo.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
