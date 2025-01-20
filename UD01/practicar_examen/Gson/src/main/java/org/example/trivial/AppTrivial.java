package org.example.trivial;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class AppTrivial {
    public static void main(String[] args) {
        Gson gson=GsonManager.getInstance().getGson();
        Path file = Path.of("src/main/java/org/example/trivial/respuesta_api.json");
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toFile()))
                ){

        }catch (IOException e){

        }

    }
}
