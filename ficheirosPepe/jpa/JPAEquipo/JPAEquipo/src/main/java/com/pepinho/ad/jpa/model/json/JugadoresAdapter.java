package com.pepinho.ad.jpa.model.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.pepinho.ad.jpa.model.Jugador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JugadoresAdapter extends TypeAdapter<List<Jugador>> {
    @Override
    public void write(JsonWriter jsonWriter, List<Jugador> jugadorList) throws IOException {

    }

    @Override
    public List<Jugador> read(JsonReader r) {

        List<Jugador> jugadores = null;

        try {
            if (r.peek() != JsonToken.BEGIN_OBJECT) {
                return null;
            }
            r.beginObject();
            if (r.nextName().equals("jugadores")) {
                jugadores = readJugadores(r);
            }
            r.endObject();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

        return jugadores;
    }

    private Jugador readJugador(JsonReader r) throws IOException {

        if (r.peek() != JsonToken.BEGIN_OBJECT) {
            return null;
        }
        r.beginObject();
        Jugador jugador = new Jugador();
        while (r.hasNext()) {
            switch (r.nextName()) {
                case "altura" -> jugador.setAltura(r.nextDouble());
                case "anoDraft" -> jugador.setAnoDraft(r.nextInt());
                case "idJugador" -> jugador.setIdJugador(r.nextLong());
                case "numero" -> jugador.setNumero((short)r.nextInt());
                case "numeroDraft" -> jugador.setNumeroDraft((short)r.nextInt());
                case "peso" -> jugador.setPeso(r.nextDouble());
                case "pais" -> jugador.setPais(r.nextString());
                case "colegio" -> jugador.setColegio(r.nextString());
                case "nombre" -> jugador.setNombre(r.nextString());
                case "apellido" -> jugador.setApellidos(r.nextString());
                default -> r.skipValue();
            }
        }
        r.endObject();
        return jugador;
    }


    private List<Jugador> readJugadores(JsonReader r) throws IOException {
        List<Jugador> jugadores = new ArrayList<>();
        r.beginArray();
        while (r.hasNext()) {
            jugadores.add(readJugador(r));
        }
        r.endArray();
        return jugadores;
    }

}
