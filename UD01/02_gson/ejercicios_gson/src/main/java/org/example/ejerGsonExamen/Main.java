package org.example.ejerGsonExamen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GregorianCalendar gCalendar=new GregorianCalendar(2023,GregorianCalendar.NOVEMBER,12,9,45);
        Examen examen=new Examen("Acceso a datos",
                gCalendar.getTime(),
                List.of("Gabriela Mistral", "Sylvia Plath", "Alejandra Pizarnik", "Rosario Castellanos", "Anne Sexton"));

        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yy-MM-dd HH:mm").
                create();

        Path file=Paths.get("accesoADatos.json");
        if (!Files.exists(file)){
            try{
                Files.createFile(file);
            }catch (IOException e){

            }
        }

        try(BufferedWriter output=new BufferedWriter(new FileWriter(file.toFile()))){
            gson.toJson(examen,output);
            System.out.println("Examen gardado");
        }catch (IOException e){
            System.out.println("Erro ao gardar o examen");
        }

        try(BufferedReader input=new BufferedReader(new FileReader(file.toFile()))){
            Examen examenLeido=gson.fromJson(input, Examen.class);
            System.out.println(examenLeido);
        }catch (IOException e){
            System.out.println("Erro ao ler o arquivo");
        }
    }
}
