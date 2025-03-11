package com.pepinho.ad.gson.meteogalicia.model.adapters.docencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.pepinho.ad.gson.meteogalicia.model.Concello;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConcellosAdapter extends TypeAdapter<List<Concello>> {
    @Override
    public void write(JsonWriter w, List<Concello> concelloList) throws IOException {
        w.beginObject().name("concellos").beginArray();
        for(Concello c: concelloList){
            w.beginObject()
                    .name("nome").value(c.getNome())
                    .name("idConcello").value(c.getIdConcello())
                    .endObject();
        }

        w.endArray().endObject();
    }

    @Override
    public List<Concello> read(JsonReader r) throws IOException {
        List<Concello> concellos = new ArrayList<>();
        if(r.peek()== JsonToken.BEGIN_ARRAY){
            r.beginArray();
            while(r.hasNext()){
                concellos.add(getConcello(r));
            }
            r.endArray();
        }
        return concellos;
    }

    private Concello getConcello(JsonReader r) throws IOException {
        r.beginObject();
        String nomeConcello = null;
        int idConcello = -1;
        while(r.hasNext()){
            switch (r.nextName()) {
                case "nombre" -> nomeConcello = r.nextString();
                case "id" -> idConcello = r.nextInt();
                default -> r.skipValue();
            }
        }
        r.endObject();
        return (nomeConcello!=null) ? new Concello(nomeConcello, idConcello) : null;
    }

    public static void main(String[] args) throws IOException {
        Type tipo = new TypeToken<List<Concello>>(){}.getType();
        Gson g = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(tipo, new ConcellosAdapter())
                .create();

        List<Concello> concellos = g.fromJson(Files.newBufferedReader(Paths.get("concellos.json")), tipo);
        concellos.forEach(System.out::println);

        String json = g.toJson(concellos);
        System.out.println(json);

    }
}
