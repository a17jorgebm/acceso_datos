package com.pepinho.ad.jpa.model.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.pepinho.ad.jpa.model.Conferencia;
import com.pepinho.ad.jpa.model.Division;
import com.pepinho.ad.jpa.model.Equipo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EquiposAdapter extends TypeAdapter<List<Equipo>> {
    @Override
    public void write(JsonWriter jsonWriter, List<Equipo> equipos) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("Equipo");
        jsonWriter.beginArray();
        for (Equipo equipo : equipos) {
            writeEquipo(jsonWriter, equipo);
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
    }

    private void writeEquipo(JsonWriter jsonWriter, Equipo equipo) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("idEquipo").value(equipo.getIdEquipo());
        jsonWriter.name("abreviatura").value(equipo.getAbreviatura());
        jsonWriter.name("ciudad").value(equipo.getCiudad());
        jsonWriter.name("conferencia").value(equipo.getConferencia().name());
        jsonWriter.name("division").value(equipo.getDivision().name());
        jsonWriter.name("nombre").value(equipo.getNombre());
        jsonWriter.name("nombreCompleto").value(equipo.getNombreCompleto());
        jsonWriter.endObject();
    }

    @Override
    public List<Equipo> read(JsonReader r) {

        List<Equipo> equipos = null;

        try {
            if (r.peek() != JsonToken.BEGIN_OBJECT) {
                return null;
            }
            r.beginObject();
            if (r.nextName().equals("Equipo")) {
                equipos = readEquipos(r);
            }
            r.endObject();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

        return equipos;
    }

    private Equipo readEquipo(JsonReader r) throws IOException {

        if (r.peek() != JsonToken.BEGIN_OBJECT) {
            return null;
        }
        r.beginObject();
        Equipo equipo = new Equipo();
        while (r.hasNext()) {
            switch (r.nextName()) {
                case "idEquipo" -> equipo.setIdEquipo(r.nextLong());
                case "abreviatura" -> equipo.setAbreviatura(r.nextString());
                case "ciudad" -> equipo.setCiudad(r.nextString());
                case "conferencia" -> equipo.setConferencia(Conferencia.of(r.nextString()));
                case "division" -> equipo.setDivision(Division.of(r.nextString()));
                case "nombre" -> equipo.setNombre(r.nextString());
                case "nombreCompleto" -> equipo.setNombreCompleto(r.nextString());
                default -> r.skipValue();
            }
        }
        r.endObject();
        return equipo;
    }


    private List<Equipo> readEquipos(JsonReader r) throws IOException {
        List<Equipo> equipos = new ArrayList<>();
        r.beginArray();
        while (r.hasNext()) {
            equipos.add(readEquipo(r));
        }
        r.endArray();
        return equipos;
    }
}
