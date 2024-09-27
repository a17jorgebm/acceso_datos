package org.example;

import java.util.Scanner;

public class ClaseScanner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sc.useDelimiter(",\\s*"); //podese indicar o delimitador mediante expresions regulares

        //atencion ao facer sc.nextDouble(), mirar nos apuntes, pero hai que usar o set Locale()
        // porque en alguns paises delimitanse decimales por , e noutros por .

        while(sc.hasNext()){
            System.out.println(sc.next());
        }


    }
}
