package org.example;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //JOptionPane.showMessageDialog();
        ejer1();
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
        JFileChooser fc=new JFileChooser();
        if((fc.showOpenDialog(null))==JFileChooser.APPROVE_OPTION){

        }
    }
}