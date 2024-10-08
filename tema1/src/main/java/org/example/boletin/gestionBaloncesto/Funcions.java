package org.example.boletin.gestionBaloncesto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Funcions {
    public static final String DIRECTORIO_ARQUIVOS="database";

    public static void crearDirectorioArquivos() throws IOException {
            Path directorio= Paths.get(DIRECTORIO_ARQUIVOS);
            Files.createDirectories(directorio);
    }

    public static <T> Set<T> lerFicheiroObxetos(String nomeFicheiro){
        File ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro).toFile();
        boolean append=ficheiro.exists();
        Set<T> obxetos=new TreeSet<>();

        try(
                ObjectInputStream input=new ObjectInputStream(new BufferedInputStream(new FileInputStream(ficheiro)));
                ){
            while(true){
                try{
                    obxetos.add((T)input.readObject());
                }catch (EOFException e){

                }
            }
        }catch (Exception e){

        }
        return obxetos;
    }
}
