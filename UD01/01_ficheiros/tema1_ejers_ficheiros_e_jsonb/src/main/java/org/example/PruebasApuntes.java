package org.example;

import java.io.*;
import java.net.*;
import java.util.Date;

public class PruebasApuntes {
    public static void main(String[] args) {
        File ficheroEntrada=new File("pom.xml");
        File ficheroSalida=new File("copia.xml");
        try(
                BufferedReader input=new BufferedReader(new FileReader(ficheroEntrada));
                BufferedWriter output=new BufferedWriter(new FileWriter(ficheroSalida));
        ){
            char[] buffer=new char[1024];
            int byteLeido;
            while((byteLeido=input.read(buffer))!=-1){
                output.write(buffer,0,byteLeido);
            }
        }catch (Exception e){}
    }
}
