package org.example.serializacion;

/* 1.PARTE
Crea una clase Persona con los atributos nombre y edad.
Implementa la interface Serializable y crea un programa que serialice y deserialice un objeto de tipo Persona.
 */

/* 2.PARTE

 */

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        while(true) {
            int optionEscollida = lerNumero(getMenu());
            JFileChooser fc = new JFileChooser();

            switch (optionEscollida) {
                case 1:
                    try (
                            FileOutputStream ficheiro = new FileOutputStream("ejer1.dat",true);
                            ObjectOutputStream fo = new ObjectOutputStream(ficheiro);
                    ) {
                        //recollida de datos
                        String novoNome = JOptionPane.showInputDialog("Introduce el nombre: ");
                        if (novoNome == null || novoNome.equals("")) { throw new Exception("Non se pode ter un nome vacío!"); }
                        String idadeString = JOptionPane.showInputDialog("Introduce a idade: ");
                        int idade = Integer.parseInt(idadeString);

                        //crease o obxeto e gardase
                        Persona p=new Persona(novoNome,idade);
                        fo.writeObject(p);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error, fichero no encontrado");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }catch (NumberFormatException e){
                        System.out.println("Error: "+e.getMessage());
                    }catch (Exception e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    limparConsola(true);
                    continue;
                case 2:

                    continue;
                case 3:

                    limparConsola(true);
                    continue;
                case 4:

                    limparConsola(true);
                    continue;
            }
            System.out.println("Saliendo del programa...");
            break;
        }
    }


    public static void escribirFicheiro(){
        try (
                FileOutputStream ficheiro = new FileOutputStream("ejer1.dat",true);
                ObjectOutputStream fo = new ObjectOutputStream(ficheiro);
        ) {
            //recollida de datos
            String novoNome = JOptionPane.showInputDialog("Introduce el nombre: ");
            if (novoNome == null || novoNome.equals("")) { throw new Exception("Non se pode ter un nome vacío!"); }
            String idadeString = JOptionPane.showInputDialog("Introduce a idade: ");
            int idade = Integer.parseInt(idadeString);

            //crease o obxeto e gardase
            Persona p=new Persona(novoNome,idade);
            fo.writeObject(p);
        } catch (FileNotFoundException e) {
            System.out.println("Error, fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("Error: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private static String getMenu(){
        StringBuilder sb=new StringBuilder();

        sb.append("#######Gestor de archivos y directorios#######\n")
                .append("1.Engadir estudiante\n")
                .append("2.Mostrar estudiantes\n")
                .append("3.Mostrar estudiante\n")
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
}
