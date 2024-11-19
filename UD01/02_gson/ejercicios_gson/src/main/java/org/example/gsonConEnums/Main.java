package org.example.gsonConEnums;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) {
        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Plataforma.class,new TypeAdapter<Plataforma>() {
                    @Override
                    public void write(JsonWriter jsonWriter, Plataforma plataforma) throws IOException {

                    }

                    @Override
                    public Plataforma read(JsonReader jsonReader) throws IOException {
                        return null;
                    }
                }).create();
    }
}
