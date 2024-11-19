package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class LecuraTecladoManual {
    public static void main(String[] args) throws IOException {
        Reader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String linha;
        //a non ser que o string sea _EXIT_(ignorando mayusculas) sigue preguntandoo e escribindo
        while(!(linha=br.readLine()).equalsIgnoreCase("_EXIT_")){
            System.out.println(linha);
        }
        br.close();
    }
}
