package org.example.trivialJson.typeAdapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.example.trivialJson.Dificultad;

import java.io.IOException;

public class DificultadTypeAdapter extends TypeAdapter<Dificultad> {
    @Override
    public void write(JsonWriter jsonWriter, Dificultad dificultad) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("dificultad").value(dificultad.getDificultad());
        jsonWriter.endObject();
    }

    @Override
    public Dificultad read(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String dificultad = null;
        while (jsonReader.hasNext()){
            switch (jsonReader.nextName()) {
                case "difficulty":
                    dificultad = jsonReader.nextString();
                    break;
            }
        }
        jsonReader.endObject();
        return Dificultad.getDificultad(dificultad);
    }
}
