package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.example.ejerMeteoGalicia.Concello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConcellosAdapter extends TypeAdapter<List<Concello>> {
    @Override
    public void write(JsonWriter jsonWriter, List<Concello> concellos) throws IOException {

    }

    @Override
    public List<Concello> read(JsonReader jsonReader) throws IOException {
        ArrayList<Concello> concellos=new ArrayList<>();
        if (jsonReader.peek()== JsonToken.BEGIN_ARRAY){
            jsonReader.beginArray();
            while (jsonReader.hasNext()){
                concellos.add(getConcello(jsonReader));
            }
            jsonReader.endArray();
        }
        return concellos;
    }

    public Concello getConcello(JsonReader jsonReader) throws IOException{
        jsonReader.beginObject();
        Integer idConcello=null;
        String nomeConcello=null;
        while (jsonReader.hasNext()){
            if (jsonReader.peek() == JsonToken.NAME){
                switch (jsonReader.nextName()){
                    case "id" -> idConcello=jsonReader.nextInt();
                    case "nombre" -> nomeConcello=jsonReader.nextString();
                    default -> jsonReader.skipValue();
                }
            }
        }
        jsonReader.endObject();
        return new Concello(nomeConcello,idConcello);
    }

    public static void main(String[] args) {
        Type tipo=new TypeToken<List<Concello>>(){}.getType();
        Gson g = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(tipo,new ConcellosAdapter())
                .create();
        Path ficheiroJson=Path.of("src/main/java/org/example/ejerMeteoGalicia/concellos.json");
        try(BufferedReader br=new BufferedReader(new FileReader(ficheiroJson.toFile()))){
            ArrayList<Concello> concellos=g.fromJson(br,tipo);
            System.out.println(concellos.toString());
        }catch (IOException e){

        }
    }
}
