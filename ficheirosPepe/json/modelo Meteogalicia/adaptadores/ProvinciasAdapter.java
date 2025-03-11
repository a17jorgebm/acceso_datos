package com.pepinho.ad.gson.meteogalicia.model.adapters.docencia;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pepinho.ad.gson.meteogalicia.model.Provincia;

import java.io.IOException;

public class ProvinciasAdapter extends TypeAdapter<Provincia> {
    @Override
    public void write(JsonWriter jsonWriter, Provincia provincia) throws IOException {

    }

    @Override
    public Provincia read(JsonReader jr) throws IOException {

        jr.beginObject();



        jr.endObject();

        return null;
    }
}
