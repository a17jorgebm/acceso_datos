package org.example.trivialJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pregunta pregunta=new Pregunta()
                .setPregunta("De que color es el blanco")
                .setTipoPregunta(Tipo.BOOLEAN)
                .setCategoria(new Categoria("Arte"))
                .setDificultad(Dificultad.EASY)
                .setCorrecta("Blanco")
                .setIncorrectas(List.of("Azul","Marron","Verde"));

        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .create();


        Path arquivo= Paths.get("preguntas.json");
        List<Pregunta> preguntas=new ArrayList<>();
        preguntas.add(pregunta);


        try(BufferedWriter output=new BufferedWriter(new FileWriter(arquivo.toFile()))){
            gson.toJson(preguntas,output);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(BufferedReader input=new BufferedReader(new FileReader(arquivo.toFile()))){
            ArrayList<Pregunta> jsonPreguntas=gson.fromJson(input,new TypeToken<List<Pregunta>>(){}.getType());
            jsonPreguntas.forEach(System.out::println);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
