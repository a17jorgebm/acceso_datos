package org.example.ejerMeteoGalicia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.example.ejerMeteoGalicia.adapters.ConcelloDeserializer;
import org.example.ejerMeteoGalicia.adapters.PrediccionDeserializer;
import org.example.ejerMeteoGalicia.adapters.PrediccionDiaDeserializer;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Persona;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class AppPeticion {
    public static final String url = "https://servizos.meteogalicia.gal/mgrss/predicion/" +
            "jsonPredConcellos.action?idConc=15078&request_locale=gl";
    public static void main(String[] args) {
        URL urlConexion=null;
        URLConnection conexionApi=null;
        try{
            urlConexion=new URI(url).toURL();
            conexionApi=urlConexion.openConnection();
        }catch (Exception e){

        }

        Prediccion p=null;
        try(BufferedReader r=new BufferedReader(new InputStreamReader(conexionApi.getInputStream()))){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Prediccion.class,new PrediccionDeserializer())
                    .registerTypeAdapter(PrediccionDia.class, new PrediccionDiaDeserializer())
                    .registerTypeAdapter(Concello.class, new ConcelloDeserializer())
                    .registerTypeAdapter(LocalDate.class,(JsonDeserializer<LocalDate>) (jsonElement, type, context)->{
                        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                        return LocalDate.parse(jsonElement.getAsString(),dateTimeFormatter);
                    })
                    .setPrettyPrinting()
                    .create();
            p=gson.fromJson(r,Prediccion.class);
            System.out.println(p);
        }catch (IOException e){

        }

    }
}
