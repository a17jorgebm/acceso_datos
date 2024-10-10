package org.example.boletin.gestionBaloncesto;

import org.example.serializacion.AppendObjectOutputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class Funcions {
    public static final String DIRECTORIO_ARQUIVOS="database";

    public static void crearDirectorioArquivos() throws IOException {
            Path directorio= Paths.get(DIRECTORIO_ARQUIVOS);
            Files.createDirectories(directorio);
    }

    public static <T> Set<T> lerFicheiroObxetos(String nomeFicheiro, Class<T> claseObjetos) throws IOException,ClassNotFoundException, ClassCastException{
        crearDirectorioArquivos();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        Set<T> obxetos=new TreeSet<>();

        if (!Files.exists(ficheiro)){
            return obxetos;
        }

        try(
                ObjectInputStream input=new ObjectInputStream(new BufferedInputStream(new FileInputStream(ficheiro.toFile())));
                ){
            while(true){
                try{
                    Object objeto=input.readObject();
                    if (!claseObjetos.isInstance(objeto)){
                        throw new ClassCastException("Error na lectura de datos. Os obxetos do arquivo non son do tipo desexado.");
                    }
                    obxetos.add((T)objeto);
                }catch (EOFException e){ break; }
            }
        }catch (IOException e){
            throw e; //simplemente para poder cerrar recursos con try with resources
        }
        return obxetos;
    }

    public static <T> boolean engadirObxetoFicheiro(String nomeFicheiro, T objeto) throws IOException{
        crearDirectorioArquivos();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        boolean append=Files.exists(ficheiro);
        if (!append){
            Files.createFile(ficheiro);
        }

        try(
                ObjectOutputStream output=append
                    ? new AppendObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ficheiro.toFile(),append)))
                    : new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ficheiro.toFile())));
        ){
            output.writeObject(objeto);
        }catch (IOException e){
            throw e; //simplemente para poder cerrar recursos con try with resources
        }
        return true;
    }



}
