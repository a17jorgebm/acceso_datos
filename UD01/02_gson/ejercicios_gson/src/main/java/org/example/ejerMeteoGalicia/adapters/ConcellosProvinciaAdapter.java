package org.example.ejerMeteoGalicia.adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.example.ejerMeteoGalicia.Concello;
import org.example.ejerMeteoGalicia.Provincia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConcellosProvinciaAdapter extends TypeAdapter<List<Provincia>> {
    @Override
    public void write(JsonWriter jsonWriter, List<Provincia> provincias) throws IOException {

    }

    @Override
    public List<Provincia> read(JsonReader jsonReader) throws IOException {
        ArrayList<Provincia> provincias=new ArrayList<>();
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            if (jsonReader.peek()== JsonToken.NAME){
                provincias.add(getProvincia(jsonReader));
            }
        }
        jsonReader.endObject();
        return provincias;
    }

    private Provincia getProvincia(JsonReader jsonReader) throws IOException{
        String nomeProvincia=jsonReader.nextName();
        ArrayList<Concello> concellos = new ArrayList<>();
        if (jsonReader.peek()==JsonToken.BEGIN_ARRAY){
            ConcellosAdapter concellosAdapter=new ConcellosAdapter();
            jsonReader.beginArray();
            while (jsonReader.hasNext()){
                concellos.add(concellosAdapter.getConcello(jsonReader));
            }
            jsonReader.endArray();
        }
        return new Provincia(concellos,nomeProvincia);
    }

    public static void main(String[] args) {
        Type tipo=new TypeToken<List<Provincia>>(){}.getType();
        Gson g = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(tipo,new ConcellosProvinciaAdapter())
                .create();
        Path ficheiroJson=Path.of("src/main/java/org/example/ejerMeteoGalicia/provincias_concello.json");
        try(BufferedReader br=new BufferedReader(new FileReader(ficheiroJson.toFile()))){
            ArrayList<Provincia> provincias=g.fromJson(br,tipo);
            System.out.println(provincias.toString());
        }catch (IOException e){
            System.out.println("Error de lectura de datos: "+e.getMessage());
        }
    }
}
