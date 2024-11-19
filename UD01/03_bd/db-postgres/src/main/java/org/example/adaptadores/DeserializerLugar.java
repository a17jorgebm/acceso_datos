package org.example.adaptadores;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.example.CodigoPostal;
import org.example.Lugar;

import java.io.IOException;

public class DeserializerLugar extends TypeAdapter<Lugar> {
    @Override
    public void write(JsonWriter jsonWriter, Lugar lugar) throws IOException {

    }

    @Override
    public Lugar read(JsonReader jsonReader) throws IOException,NumberFormatException {
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

        double longitudeD=Double.parseDouble(longitude);
        double latitudeD=Double.parseDouble(latitude);

        return new Lugar(name,stateAbrev,state,latitudeD,longitudeD);
    }
}
