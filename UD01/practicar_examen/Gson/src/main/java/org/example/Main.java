package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.ejer1Examen.Examen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Date date= Date.from(
                LocalDateTime.of(2024,11,12,9,45,34)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        ArrayList<Examen> examenes = new ArrayList<>();
        for (int i=0;i<1000;i++){
            Examen examen=new Examen(
                    "Acceso a datos",
                    null,
                    List.of("Pepe","Juan")
            );
            examenes.add(examen);
        }


        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yy/MM/dd HH:mm")
                .excludeFieldsWithoutExposeAnnotation()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setVersion(2.0)
                .serializeNulls()
                .create();

        Path file= Path.of("src/main/java/org/example/ejer1Examen/accesoADatos.json");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(file)){
            gson.toJson(examenes, bufferedWriter);
        }catch(IOException e){
            out.println(e.getMessage());
        }
    }
}