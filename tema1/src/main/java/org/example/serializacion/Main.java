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
    public static String NOME_FICHEIRO="estudiantes.dat";

    public static void main(String[] args){
        while(true) {
            int optionEscollida = lerNumero(getMenu());
            JFileChooser fc = new JFileChooser();

            switch (optionEscollida) {
                case 1:
                    File ficheiro=new File(NOME_FICHEIRO);
                    try{
                        //recollida de datos
                        String novoNome = JOptionPane.showInputDialog("Introduce el nombre: ");
                        if (novoNome == null || novoNome.equals("")) { throw new Exception("Non se pode ter un nome vacío!"); }
                        String idadeString = JOptionPane.showInputDialog("Introduce a idade: ");
                        int idade = Integer.parseInt(idadeString);

                        //crease o obxeto e gardase
                        Persona p=new Persona(novoNome,idade);

                        //teño que facelo asi porque senon non podo elegir de que clase é o FileOutputStream dependendo de se o arquivo existe ou non
                        if (ficheiro.exists()){
                            try(
                                AppendObjectOutputStream os=new AppendObjectOutputStream(new FileOutputStream(NOME_FICHEIRO,true));
                            ){
                                os.writeObject(p);
                            }catch (IOException e){
                                System.out.println("Erro ao escribir o arquivo");
                            }
                        }else {
                            try(
                                    ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO));
                            ){
                                os.writeObject(p);
                            }catch (IOException e){
                                System.out.println("Erro ao escribir o arquivo");
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Estudiante gardado correctamente!");
                    }catch (NumberFormatException e){
                        System.out.println("Error: a idade debe ser un número enteiro");
                    }catch (Exception e){
                        System.out.println("Error ao gardar o usuario");
                    }
                    limparConsola(true);
                    continue;
                case 2:
                    try(
                        FileInputStream fi=new FileInputStream(NOME_FICHEIRO);
                        ObjectInputStream streamObjeto=new ObjectInputStream(fi);
                    ){
                        StringBuilder texto=new StringBuilder();
                        texto.append("\n---------Estudiantes guardados---------");
                        while(true) {
                            try{
                                Persona p=(Persona) streamObjeto.readObject();
                                texto.append("\n").append(p).append("\n-------------------");
                            }catch (EOFException e){
                                break;
                            }
                        }
                        System.out.println(texto.toString());
                    } catch (FileNotFoundException e) {
                        System.out.println("Error, fichero no encontrado");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }catch (NumberFormatException e){
                        System.out.println("Error: a idade debe ser un número enteiro");
                    }catch (Exception e){
                        System.out.println("Error ao gardar o usuario");
                    }
                    limparConsola(true);
                    continue;
                case 3:
                    String nombre=JOptionPane.showInputDialog("Introduce el nombre del estudiante: ");
                    try(
                            FileInputStream fi=new FileInputStream(NOME_FICHEIRO);
                            ObjectInputStream streamObjeto=new ObjectInputStream(fi);
                    ){
                        StringBuilder texto=new StringBuilder();
                        texto.append("\n---------Estudiante---------");
                        while(true) {
                            try{
                                Persona p=(Persona) streamObjeto.readObject();
                                if (p.getNome().equals(nombre)) {
                                    texto.append("\n").append(p).append("\n-------------------");
                                    System.out.println(texto.toString());
                                    break;
                                }
                            }catch (EOFException e){
                                System.out.println("No se ha encontrado al alumno con nombre "+nombre);
                                break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error, fichero no encontrado");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }catch (Exception e){
                        System.out.println("Error ao mostrar o usuario");
                    }
                    limparConsola(true);
                    continue;
            }
            System.out.println("Saliendo del programa...");
            break;
        }
    }

    private static String getMenu(){
        StringBuilder sb=new StringBuilder();

        sb.append("#######Gestor de estudiantes#######\n")
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
}
