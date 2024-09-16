package org.example;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //JOptionPane.showMessageDialog();
        ejer2();
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:


            }
        }
    }

    private static String getMenu(){
        StringBuilder sb=new StringBuilder();

        sb.append("Gestor de archivos y directorios\n\n")
                .append("1.Creación de directorio\n")
                .append("2.Listar archivos y directorios\n")
                .append("3.Eliminar archivos o directorios\n")
                .append("4.Mover o renombrar directorios\n")
                .append("Selecciona una de las opciones: ");

        return sb.toString();
    }

    private static int lerNumero(String texto){
        Scanner ler = new Scanner(texto);

        if (ler.hasNextInt()){
            return ler.nextInt();
        }else{
            return lerNumero("Debe ser un número entero!\n"+texto);
        }
    }
}