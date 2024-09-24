package org.example.boletin.ejer1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

/*
Se realice un programa para copiar archivos. El programa debe recoger el
nombre del archivo origen y destino. Se existe debe solicitar confirmación sobrescribir.
Úsese I/O con buffer y métodos estáticos (tenga en cuenta que los archivos pueden ser
binarios).

a) Para la lectura desde teclado puede emplearse la clase Scanner.
 */
public class ApartadoA {
    private static final Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        File archivoOrigen=new File(lerLinea("Introduce o nome do arquivo de orixe: "));
        File archivoDestino=new File(lerLinea("Introduce o nome do arquivo destino: "));

        //comprobacións
        if (!archivoOrigen.exists() || !archivoOrigen.isFile()){
            System.out.println("O arquivo de orixe non existe ou non é válido, salindo do programa...");
            return;
        }

        if (archivoDestino.isDirectory()){
            System.out.println("Non se pode crear o arquivo de destino, xa existe un directorio con ese nome");
            return;
        }

        if (archivoDestino.exists()){
            String confirmacion=lerLinea("O arquivo de destino existe, queres sobreescribilo? (S/N): ");
            if (!confirmacion.toUpperCase().equals("S")){
                System.out.println("Cancelando operación, no se copiará el archivo...");
                return;
            }
        }

        //copia dos ficheiros
        try(
            FileInputStream fileInput=new FileInputStream(archivoOrigen);
            FileOutputStream fileOutput=new FileOutputStream(archivoDestino);
        )
        {
            
        }catch (Exception e){

        }
    }

    public static String lerLinea(String mensaje){
        System.out.print(mensaje);
        String input=scanner.nextLine();
        return input;
    }

    public static void limparConsola(){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<50;){
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
