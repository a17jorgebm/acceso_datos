package org.example.ExamenConTypeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExamenAdapter extends TypeAdapter<Examen> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Override
    public void write(JsonWriter jsonWriter, Examen examen) throws IOException {
        jsonWriter.beginObject();

        jsonWriter.name("materia").value(examen.getMateria());
        writeLocalDateTime(jsonWriter, examen.getDataExame());
        writeAlumnos(jsonWriter, examen.getAlumnosApuntados());

        jsonWriter.endObject();
    }

    @Override
    public Examen read(JsonReader jsonReader) throws IOException {
        String nombre=null;
        LocalDateTime date=null;
        List<String> alumnos=null;

        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String name = jsonReader.nextName();
            switch (name){
                case "materia" -> nombre=jsonReader.nextString();
                case "date" -> date = readLocalDateTime(jsonReader);
                case "alumnos" -> alumnos = readAlumnos(jsonReader);
                default -> jsonReader.skipValue(); //lo consumimos
            }
        }
        jsonReader.endObject();
        return new Examen(nombre,date,alumnos);
    }


    private void writeLocalDateTime(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException{
        jsonWriter.name("date").value(formatter.format(localDateTime));
    }

    private LocalDateTime readLocalDateTime(JsonReader jsonReader) throws IOException{
        return LocalDateTime.parse(jsonReader.nextString(),formatter);
    }

    private void writeAlumnos(JsonWriter jsonWriter, List<String> alumnos) throws IOException{
        jsonWriter.name("alumnos");
        jsonWriter.beginArray();
        for (String alumno: alumnos){
            jsonWriter.value(alumno);
        }
        jsonWriter.endArray();
    }

    private List<String> readAlumnos(JsonReader jsonReader) throws IOException{
        ArrayList<String> alumnos = new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()){
            alumnos.add(jsonReader.nextString());
        }
        jsonReader.endArray();
        return alumnos;
    }
}
