package com.pepinho.ad.jpa.model.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pepinho.ad.jpa.model.Equipo;

import java.util.List;

public class GsonManager {

    private Gson gson;

    private static GsonManager instance;

    private GsonManager() {
        gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<Equipo>>(){}.getType(), new EquiposAdapter())
                .setPrettyPrinting().create();
    }

    public static GsonManager getInstance() {
        if (instance == null) {
            synchronized (GsonManager.class) {
                if (instance == null) {
                    instance = new GsonManager();
                }
            }
        }
        return instance;
    }

    public Gson getGson() {
        return gson;
    }



}
