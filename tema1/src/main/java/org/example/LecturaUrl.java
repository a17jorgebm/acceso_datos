package org.example;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class LecturaUrl {
    public static void main(String[] args) {
        URI uri=null;
        URL url=null;
        //HttpURLConnection conexion=(HttpURLConnection) url.openConnection();
        try{
            uri=new URI("https://www.google.com");
            url=uri.toURL();
        }catch (Exception e){
            System.out.println("Error en el enlace.");
        }

        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File arquivoOndeGardar;

        if(!(fc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)){
            System.out.println("Salindo do programa");
            return;
        }

        arquivoOndeGardar=fc.getSelectedFile();

        try(
                InputStream is=url.openStream();
                FileOutputStream arquivo=new FileOutputStream(arquivoOndeGardar.getAbsolutePath()+"/pagina.html");
        ){
            int valor;
            while((valor=is.read())!=-1){
                arquivo.write(valor);
            }
        }catch (Exception e){

        }


    }
}
