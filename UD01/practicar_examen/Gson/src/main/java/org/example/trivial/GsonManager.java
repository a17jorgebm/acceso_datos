package org.example.trivial;

import com.google.gson.*;

public class GsonManager {
    private static final GsonBuilder gsonBuilder = new GsonBuilder()
            .registerTypeAdapter(TipoPregunta.class,
                    (JsonSerializer<TipoPregunta>) (tipoPregunta, type, context)
                            -> new JsonPrimitive(tipoPregunta.getTipoPregunta())
            )
            .setPrettyPrinting();

    private volatile static GsonManager instance;
    private final Gson gson;

    private GsonManager(){
        this.gson=gsonBuilder.create();
    }

    public static GsonManager getInstance(){
        if (instance==null){
            synchronized (GsonManager.class){
                if (instance==null){
                    instance=new GsonManager();
                }
            }
        }
        return instance;
    }

    public Gson getGson(){
        return gson;
    }
}
