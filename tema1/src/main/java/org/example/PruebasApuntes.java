package org.example;

import java.io.*;
import java.net.*;
import java.util.Date;

public class PruebasApuntes {
    public static void main(String[] args) throws Exception {
        File ficheiroPagina=new File("web.html");
        URL url=(new URI("https://google.es")).toURL();
        URLConnection conexion=url.openConnection(); //de onde sacamos o flujo
        HttpURLConnection con=(HttpURLConnection) conexion;
        try(
                InputStream in=conexion.getInputStream();
                FileOutputStream fos=new FileOutputStream(ficheiroPagina);
        ){
            byte[] buffer=new byte[1024];
            int numLeido;
            while((numLeido=in.read(buffer))!=-1){
                fos.write(buffer,0,numLeido);
            }
            System.out.println(con.getContentType());
        }
    }
}
