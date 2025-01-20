package org.example.boletin.gestionBaloncesto;

import org.example.boletin.gestionBaloncesto.AppendObjectOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
        Set<T> obxetos=new HashSet<>();

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
        return (Set<T>) obxetos;
    }

    public static <T> T getObxetoFicheiroById(String nomeFicheiro, T objeto) throws IOException, ClassNotFoundException, ClassCastException{
        if (objeto==null) return null;

        crearDirectorioArquivos();
        Class<?> claseObjeto=objeto.getClass();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        if (!Files.exists(ficheiro)) return null;
        try(
                ObjectInputStream input=new ObjectInputStream(new BufferedInputStream(new FileInputStream(ficheiro.toFile())));
        ){
            while(true){
                try{
                    Object objetoArquivo=input.readObject();
                    if (!claseObjeto.isInstance(objetoArquivo)){
                        throw new ClassCastException("Error na lectura de datos. Os obxetos do arquivo non son do tipo desexado.");
                    }
                    if (((T)objetoArquivo).equals(objeto)) return (T)objetoArquivo;
                }catch (EOFException e){ break; }
            }
        }catch (IOException e){
            throw e; //simplemente para poder cerrar recursos con try with resources
        }
        return null;
    }


    public static <T> boolean checkIfObjectExists(String nomeFicheiro, T objeto) throws IOException,ClassNotFoundException, ClassCastException{
        crearDirectorioArquivos();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        Class<?> claseObjeto= objeto.getClass();

        if (!Files.exists(ficheiro)) return false;

        try(
                ObjectInputStream input=new ObjectInputStream(new BufferedInputStream(new FileInputStream(ficheiro.toFile())));
        ){
            while(true){
                try{
                    Object objetoArquivo=input.readObject();
                    if (!claseObjeto.isInstance(objetoArquivo)){
                        throw new ClassCastException("Error na lectura de datos. Os obxetos do arquivo non son do tipo desexado.");
                    }
                    if (objetoArquivo.equals(objeto)) return true;
                }catch (EOFException e){ break; }
            }
        }catch (IOException e){
            throw e; //simplemente para poder cerrar recursos con try with resources
        }
        return false;
    }

    public static <T> boolean engadirObxetoFicheiro(String nomeFicheiro, T objeto) throws IOException, ClassNotFoundException{
        if (objeto==null) return false;

        crearDirectorioArquivos();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        boolean append=Files.exists(ficheiro);
        if (!append){
            Files.createFile(ficheiro);
        }else{
            if (checkIfObjectExists(nomeFicheiro,objeto)) return false;
        }

        try(
                ObjectOutputStream output=append
                    ? new AppendObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ficheiro.toFile(),append)))
                    : new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ficheiro.toFile())));
        ){
            output.writeObject(objeto);
        }catch (IOException e){
            throw e;
        }
        return true;
    }

    public static <T> boolean borrarObxetoArquivo(String nomeFicheiro,T objeto) throws IOException,ClassNotFoundException{
        if (objeto==null) return false;

        crearDirectorioArquivos();
        Class<T> claseObjeto=(Class<T>)objeto.getClass();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        if (!Files.exists(ficheiro)) return false;

        try(
                ObjectInputStream input=new ObjectInputStream(new BufferedInputStream(new FileInputStream(ficheiro.toFile())));
                ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ficheiro.toFile())))
        ){
            while(true){
                try{
                    Object objetoArquivo=input.readObject();
                    if (!claseObjeto.isInstance(objetoArquivo)){
                        throw new ClassCastException("Error na lectura de datos. Os obxetos do arquivo non son do tipo desexado.");
                    }
                    if (objetoArquivo.equals(objeto)) continue;
                    output.writeObject(objetoArquivo);
                }catch (EOFException e){break;}
            }
        }catch (IOException e){
            throw e;
        }

        return true;
    }

    public static boolean borrarTodosObxetosArquivo(String nomeFicheiro) throws IOException{
        crearDirectorioArquivos();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        return Files.deleteIfExists(ficheiro);
    }

    public static <T> boolean actualizarObxetoArquivo(String nomeFicheiro,T objeto,T objetoActualizado) throws IOException,ClassNotFoundException{
        if (objeto==null || objetoActualizado==null) return false;

        crearDirectorioArquivos();
        Class<T> claseObjeto=(Class<T>)objeto.getClass();
        Path ficheiro=Paths.get(DIRECTORIO_ARQUIVOS,nomeFicheiro);
        if (!Files.exists(ficheiro)) return false;

        try(
                ObjectInputStream input=new ObjectInputStream(new BufferedInputStream(new FileInputStream(ficheiro.toFile())));
                ObjectOutputStream output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ficheiro.toFile())))
        ){
            while(true){
                try{
                    Object objetoArquivo=input.readObject();
                    if (!claseObjeto.isInstance(objetoArquivo)){
                        throw new ClassCastException("Error na lectura de datos. Os obxetos do arquivo non son do tipo desexado.");
                    }
                    if (objetoArquivo.equals(objeto)){
                        output.writeObject(objetoActualizado);
                        continue;
                    }
                    output.writeObject(objetoArquivo);
                }catch (EOFException e){break;}
            }
        }catch (IOException e){
            throw e;
        }

        return true;
    }



    //funcions de interfaz
    public static void cambiarValoresGBC(
            GridBagConstraints objetoConstraints,
            int gridx,
            int gridy,
            double weightx,
            double weighty
    ){
        objetoConstraints.gridx=gridx;
        objetoConstraints.gridy=gridy;
        objetoConstraints.weightx=weightx;
        objetoConstraints.weighty=weighty;
        //reseteanse os insets
        objetoConstraints.insets=new Insets(0,0,0,0);
    }
    public static void cambiarValoresGBC(
            GridBagConstraints objetoConstraints,
            int gridx,
            int gridy,
            double weightx,
            double weighty,
            Insets insets
    ){
        objetoConstraints.gridx=gridx;
        objetoConstraints.gridy=gridy;
        objetoConstraints.weightx=weightx;
        objetoConstraints.weighty=weighty;
        objetoConstraints.insets=insets;
    }
    public static void cambiarValoresGBC(GridBagConstraints objetoConstraints,int gridx,int gridy,double weightx,double weighty,int gridwidth,int gridheight,int fill){
        objetoConstraints.gridx=gridx;
        objetoConstraints.gridy=gridy;
        objetoConstraints.weightx=weightx;
        objetoConstraints.weighty=weighty;
        objetoConstraints.gridwidth=gridwidth;
        objetoConstraints.gridheight=gridheight;
        objetoConstraints.fill=fill;
        //reseteanse os insets
        objetoConstraints.insets=new Insets(0,0,0,0);
    }
    public static void cambiarValoresGBC(GridBagConstraints objetoConstraints,int gridx,int gridy,double weightx,double weighty,int gridwidth,int gridheight,int fill, Insets insets){
        objetoConstraints.gridx=gridx;
        objetoConstraints.gridy=gridy;
        objetoConstraints.weightx=weightx;
        objetoConstraints.weighty=weighty;
        objetoConstraints.gridwidth=gridwidth;
        objetoConstraints.gridheight=gridheight;
        objetoConstraints.fill=fill;
        objetoConstraints.insets=insets;
    }

    public static JLabel crearTexto(String texto){
        JLabel label=new JLabel(texto);
        label.setForeground(Color.decode("#FFFFFF"));
        label.setFont(new Font("Times New Roman",Font.BOLD,15));
        return label;
    }

    public static JLabel crearTexto(String texto,int tamano){
        JLabel label=new JLabel(texto);
        label.setForeground(Color.decode("#FFFFFF"));
        label.setFont(new Font("Times New Roman",Font.BOLD,tamano));
        return label;
    }

    public static JLabel crearTexto(String texto,int tamano, Color colorLetra){
        JLabel label=new JLabel(texto);
        label.setForeground(colorLetra);
        label.setFont(new Font("Times New Roman",Font.BOLD,tamano));
        return label;
    }

}
