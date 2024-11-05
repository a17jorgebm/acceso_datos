package org.example.ejerMeteoGalicia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.ejerMeteoGalicia.adapters.PrediccionDeserializer;
import org.example.ejersTypeAdapter.JsonDeserializerAndSerializer.ejer2.Persona;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

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

        try(BufferedReader r=new BufferedReader(new InputStreamReader(conexionApi.getInputStream()))){
            Gson gson=new GsonBuilder()
                    .registerTypeAdapter(Prediccion.class,new PrediccionDeserializer())
                    .setPrettyPrinting()
                    .create();
            Prediccion p=gson.fromJson(r,Prediccion.class);
            System.out.println(p.getConcello());
        }catch (IOException e){

        }
    }
}
