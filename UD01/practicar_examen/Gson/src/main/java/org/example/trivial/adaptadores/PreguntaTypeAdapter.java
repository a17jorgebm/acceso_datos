package org.example.trivial.adaptadores;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.example.trivial.Pregunta;

import java.io.IOException;
import java.util.Objects;

public class PreguntaTypeAdapter extends TypeAdapter<Pregunta> {
    @Override
    public void write(JsonWriter jsonWriter, Pregunta pregunta) throws IOException {

    }

    @Override
    public Pregunta read(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String name = jsonReader.nextName();
            if (!Objects.equals(name, "results")) jsonReader.skipValue();

            jsonReader.beginArray();
            while (jsonReader.hasNext()){
                String questionAtribute = jsonReader.nextName();


            }
            jsonReader.endArray();

        }
        return null;
    }
}
