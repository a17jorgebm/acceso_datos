package org.example.trivialJson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pregunta pregunta=new Pregunta()
                .setPregunta("De que color es el blanco")
                .setTipoPregunta(TipoPregunta.BOOLEAN)
                .setCategoria(new Categoria("Arte"))
                .setDificultad(Dificultad.EASY)
                .setOpcions(List.of(
                        new Opcion("Caballo",true),
                        new Opcion("Yegua",false),
                        new Opcion("Camaleon",false),
                        new Opcion("Negro",false)
                ));

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

    public void main2(){
        Gson gson=new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                    @Override
                    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
                        return new JsonPrimitive(localDate.toString());
                    }
                })
                .create();
    }
}
