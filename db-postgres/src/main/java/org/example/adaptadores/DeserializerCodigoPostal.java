package org.example.adaptadores;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.example.CodigoPostal;

import java.io.IOException;

public class DeserializerCodigoPostal extends TypeAdapter<CodigoPostal>{
    @Override
    public void write(JsonWriter jsonWriter, CodigoPostal codigoPostal) throws IOException {

    }

    @Override
    public CodigoPostal read(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String name=null, longitude=null, state=null, stateAbrev=null, latitude=null;
        while (jsonReader.hasNext()){
            switch (jsonReader.nextName()){
                case "place name" -> name=jsonReader.nextString();
                case "longitude" -> longitude=jsonReader.nextString();
                case "state" -> state=jsonReader.nextString();
                case "state abbreviation" -> stateAbrev=jsonReader.nextString();
                case "latitude" -> latitude=jsonReader.nextString();
                default -> jsonReader.skipValue();
            }
        }
        return null;
    }
}
