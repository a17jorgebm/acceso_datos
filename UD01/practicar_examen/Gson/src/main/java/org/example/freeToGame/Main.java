package org.example.freeToGame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Game.class, new GameTypeAdapter())
                .registerTypeAdapter(Game.class, new GameInstanceCreator())
                .setPrettyPrinting()
                .create();

        Path file = Path.of("src/main/java/org/example/freeToGame/json.json");
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toFile()))
                ){
            Game game = gson.fromJson(bufferedReader, Game.class);
            System.out.println(game);
            game.saveInFile();
            game.getMiniatura().saveToFile();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
