package org.example.boletin03.ejer3;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ejer3 {
    public static void main(String[] args) {
        LocalDateTime fecha=LocalDateTime.of(2024,11,11,9,45);
        ArrayList<String> estudiantes= new ArrayList<>(
                Arrays.asList("Sylvia Plath"
                        ,"Gabriela Mistral"
                        ,"Anne Sexton"
                        ,"Wisława Szymborska"
                        ,"Alejandra Pizarnik")
        );
        Examen examen=new Examen("Acceso a Datos",fecha,estudiantes);

        Path ficheiro= Paths.get("accesoADatos.json");
        if (!Files.exists(ficheiro)){
            try{
                Files.createFile(ficheiro);
            }catch (IOException e){
                System.out.println("Erro ao crear o arquivo: "+e.getMessage());
            }
        }

        JsonbConfig config=new JsonbConfig();
        config.withFormatting(true); //pa que apareza bonito
        Jsonb jsonb=JsonbBuilder.create(config);

        try(BufferedWriter output=new BufferedWriter(new FileWriter(ficheiro.toFile()))){
            jsonb.toJson(examen,output);
        }catch (IOException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
}
