package org.example.trivialJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class AppTrivial {
    public static void main(String[] args) {
        URL url=null;
        URLConnection conexion=null;
        try{
            url= URI.create("https://opentdb.com/api.php?amount=10").toURL();
            conexion= url.openConnection();
        }catch (Exception e){
            System.err.println("Error de conexion coa url: "+e.getMessage());
            System.exit(1);
        }


        try(
                BufferedInputStream inputStream=new BufferedInputStream(conexion.getInputStream());
                BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream("jsonApi.json"))
                ){
            int i;
            while ((i=inputStream.read())!=-1){
                outputStream.write(i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
