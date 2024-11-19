package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDemo {
    public static void main(String[] args) {
        Gson gson=new Gson();

        String nome=gson.fromJson("\"Sylvia Plath\"",String.class);
        System.out.println("nome = " + nome);

        gson.toJson(256,System.out);
        System.out.println(); //salto liña

        gson.toJson("<html>",System.out);
        System.out.println();

        gson = new GsonBuilder().disableHtmlEscaping().create();
        gson.toJson("<html>",System.out);

    }
}
