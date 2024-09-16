package org.example;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //JOptionPane.showMessageDialog();
        ejer3();
    }

    public static void ejer1(){
        File fichero=new File("prueba.txt");
        if (fichero.exists()){
            System.out.println(fichero.getAbsolutePath());
            System.out.println(fichero.getName());
            System.out.println(fichero.getTotalSpace());
            System.out.println(fichero.lastModified());
            System.out.println(fichero.isDirectory());
        }else{
            System.out.println("El archivo no existe, creando uno temporal...");
            try{
                File.createTempFile(fichero.getName(),null,(new File("./"))).deleteOnExit();
            }catch (Exception e){
                System.out.println("Error al crear el archivo. "+e.getMessage());
            }
        }
    }

    public static void ejer2(){
        StringBuilder sb= new StringBuilder();
        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File directorio=null;
        if((fc.showOpenDialog(null))==JFileChooser.APPROVE_OPTION){
            directorio=fc.getSelectedFile();
            for (File elemento:directorio.listFiles()){
                sb.append(elemento.getName()).append(" - ")
                        .append(elemento.isFile() ? "Es archivo" : "Es directorio")
                        .append(" - ")
                        .append(elemento.getTotalSpace() + " bytes")
                        .append(System.lineSeparator());
            }
            System.out.print(sb.toString());
        }
    }

    public static void ejer3(){
        while(true){
            int optionEscollida=lerNumero(getMenu());


            switch (optionEscollida){
                case 1:
                    JFileChooser fc=new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    if (!(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)){
                        limparConsola(false);
                        continue;
                    }
                    File directorioGardado=fc.getSelectedFile();

                    String nomeDirectorio=lerTexto("Introduce o nome do directorio: ");
                    File novoDirectorio=new File(directorioGardado.getAbsolutePath()+"/"+nomeDirectorio);
                    if (novoDirectorio.exists()){ //xa comproba que existe tamen
                        System.out.println("El directorio ya existe!");
                        limparConsola(true);
                        continue;
                    }

                    System.out.println(novoDirectorio.mkdir() ? "Directorio creado!" : "Error al crear el directorio");
                    limparConsola(true);
                    continue;
                case 2:
                    JFileChooser fc2=new JFileChooser();

                    fc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    if (!(fc2.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)){
                        limparConsola(false);
                        continue;
                    }
                    File directorioGardado2=fc2.getSelectedFile();
                    System.out.println(fc2.getName());
                    listarDirectorioRecursivo(fc2.getSelectedFiles(),0);
                    continue;
                case 3:

                    continue;
                case 4:

                    continue;
            }
            System.out.println("Saliendo del programa...");
            break;
        }
    }

    private static String getMenu(){
        StringBuilder sb=new StringBuilder();

        sb.append("#######Gestor de archivos y directorios#######\n")
                .append("1.Creación de directorio\n")
                .append("2.Listar archivos y directorios\n")
                .append("3.Eliminar archivos o directorios\n")
                .append("4.Mover o renombrar directorios\n")
                .append("Selecciona una de las opciones: ");

        return sb.toString();
    }

    private static void limparConsola(boolean esperar){
        if (esperar){
            Scanner sc=new Scanner(System.in);
            System.out.print("Pulse cualquer tecla para continuar...");
            sc.nextLine();
        }

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<50;i++){
            sb.append("\r\n");
        }
        System.out.print(sb.toString());
    }

    private static int lerNumero(String texto){
        System.out.print(texto);
        Scanner ler = new Scanner(System.in);

        if (ler.hasNextInt()){
            return ler.nextInt();
        }else{
            return lerNumero("Error, debe introducir un número: ");
        }
    }

    private static String lerTexto(String texto){
        System.out.print(texto);
        Scanner ler = new Scanner(System.in);
        return ler.nextLine();
    }

    private static void listarDirectorioRecursivo(File[] elementos,int nivelArbol){
        for (File elemento:elementos){
            System.out.println(elemento.getAbsolutePath());
            if (elemento.isFile()){
                System.out.println(elemento.getName());
                continue;
            }
            System.out.println(elemento.getName());
            for (File directorio:elemento.listFiles()){
                for (int i=0;i<nivelArbol;i++){ System.out.print("\t"); }
                System.out.println(directorio.getName());
                if (elemento.isDirectory()){
                    listarDirectorioRecursivo(elemento.listFiles(),++nivelArbol);
                }
                else{
                    System.out.println(elemento.getName());
                }
            }
        }
    }
}