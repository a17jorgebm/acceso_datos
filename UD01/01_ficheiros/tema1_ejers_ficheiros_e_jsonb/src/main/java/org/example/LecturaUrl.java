package org.example;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LecturaUrl {
    public static void main(String[] args) {
        URL url=null;
        HttpURLConnection conexion=null;

        //pidese o nome do arquivo
        String urlString=JOptionPane.showInputDialog("Introduce a url");
        if (urlString.equals("") || urlString==null){
            System.out.println("Non se introduciu unha url, saíndo do programa...");
            return;
        }

        try{
            url=(new URI(urlString)).toURL();
            conexion=(HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("HEAD");
        }catch (Exception e){
            System.out.println("Error en el enlace.");
            return;
        }
        String extensionArquivo=getExtensionFromMimeType(conexion.getContentType().split(";")[0]);

        //pidese o directorio onde gardar o arquivo
        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File directorioOndeGardar;
        if(!(fc.showSaveDialog(null)== JFileChooser.APPROVE_OPTION)){
            System.out.println("Salindo do programa...");
            return;
        }
        directorioOndeGardar=fc.getSelectedFile();

        //pidese o nome do arquivo
        String nomeArchivo=JOptionPane.showInputDialog("Introduce el nombre del archivo");
        if (nomeArchivo.equals("") || nomeArchivo==null){
            System.out.println("Non se introduciu nome do arquivo, saíndo do programa...");
            return;
        }

        try(
                InputStream is=url.openStream();
                FileOutputStream arquivo=new FileOutputStream(directorioOndeGardar+"/"+ nomeArchivo + (extensionArquivo!=null ? "."+extensionArquivo : ""));
        ){
            int valor;
            while((valor=is.read())!=-1){
                arquivo.write(valor);
            }
        }catch (Exception e){
            System.out.println("Error ao gardar o arquivo...");
        }
    }
    public static String getExtensionFromMimeType(String mimeType){
        HashMap<String, String> extensions=new HashMap<>(Map.ofEntries(
                Map.entry("application/json","json"),
                Map.entry("application/octet-stream","zip"),
                Map.entry("application/pdf","pdf"),
                Map.entry("application/vnd.ms-excel","xls"),
                Map.entry("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet","xlsx"),
                Map.entry("text/html","html"),
                Map.entry("text/xml","xml"),
                Map.entry("text/plain","txt"),
                Map.entry("application/javascript","js"),
                Map.entry("image/jpeg","jpeg"),
                Map.entry("image/png","png"),
                Map.entry("image/gif","gif"),
                Map.entry("image/tiff","tiff"),
                Map.entry("application/msword","doc")
        ));
        return extensions.get(mimeType);
    }
}
