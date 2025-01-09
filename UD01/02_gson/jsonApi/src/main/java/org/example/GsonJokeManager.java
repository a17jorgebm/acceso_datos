package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonJokeManager {
    public static final String API_URL="";

    private GsonJokeManager instance;
    private Gson gson;

    private GsonJokeManager(){
        gson= new GsonBuilder()
                .create();
    }

    public GsonJokeManager getInstance(){
        if (instance==null){
            synchronized (this){
                if (instance==null){
                    instance=new GsonJokeManager();
                }
            }
        }
        return instance;
    }
}
