package org.example.boletin_ficheiros.ejer1;


import java.io.*;
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
        if (!archivoOrigen.exists() || !archivoOrigen.isFile()){
            System.out.println("O arquivo de orixe non existe ou non é válido, salindo do programa...");
            return;
        }

        File archivoDestino=new File(lerLinea("Introduce o nome do arquivo destino: "));
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
            BufferedInputStream bi=new BufferedInputStream(new FileInputStream(archivoOrigen));
            BufferedOutputStream bo=new BufferedOutputStream(new FileOutputStream(archivoDestino));
        )
        {
            byte[] datos=new byte[200]; //innecesario pero para practicar
            while ((bi.read(datos))!=-1){
                bo.write(datos);
            }
            System.out.println("Archivos copiados correctamente!");
        }catch (Exception e){
            System.out.println("Erro ao copiar os arquivos: "+e.getMessage());
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
