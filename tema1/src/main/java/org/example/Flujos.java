package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Flujos{
    public static void main(String[] args) throws IOException {

        try (
                FileInputStream in = new FileInputStream("otto.txt");
                FileOutputStream out = new FileOutputStream("src/main/resources/nohaycole.txt");
                ){
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }catch (FileNotFoundException nf){
            System.out.println("Non se encontrou o ficheiro");
        }
    }
}
