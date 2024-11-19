package org.example.serializacion_objetos_ficheiros;

import java.io.*;

public class SerializacionMultiple {
    public static void main(String[] args) {
        try(
                FileOutputStream fo=new FileOutputStream("coleccionEstudiantes.dat");
                ObjectOutputStream stream=new ObjectOutputStream(fo);
                FileInputStream fi=new FileInputStream("coleccionEstudiantes.dat");
                ObjectInputStream streamLer=new ObjectInputStream(fi);
        ){
            String[] nombres={"Pepe","Juan","Jorge","Eva","Paco","Alberto","Luis"};
            ColeccionPersonas personas=new ColeccionPersonas();
            for (String nombre:nombres) {
                personas.engadirPersona(new Persona(nombre,(int)(Math.random()*100)));
            }
            stream.writeObject(personas);

            StringBuilder texto=new StringBuilder();
            texto.append("Personas no arquivo-----------------\n");
            //ler e imprimilo
            while(true){
                try{
                   ColeccionPersonas personasArchivo=(ColeccionPersonas) streamLer.readObject();
                    texto.append("COLECCION----------------------\n");
                    for (Persona persona:personasArchivo.getPersonas()) {
                       texto.append("PERSONA------\n");
                       texto.append(persona);
                       texto.append("\n-------------\n");
                   }
                   texto.append("--------------------------------\n");

                }catch(EOFException e){
                    break;
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
            System.out.println(texto.toString());

        }catch (IOException e){
            System.out.println("Ocorreu un erro: "+e);
        }
    }
}
