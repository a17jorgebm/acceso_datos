package org.example.freeToGame;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class GameInstanceCreator implements InstanceCreator<Game> {
    @Override
    public Game createInstance(Type type) {
        Game game=new Game();
        game.setPlataforma(Plataforma.BROWSER);
        return game;
    }
}
