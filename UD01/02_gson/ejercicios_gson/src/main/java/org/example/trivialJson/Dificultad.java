package org.example.trivialJson;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Dificultad implements Comparable<Dificultad>{
    EASY("easy"), MEDIUM("medium"), HARD("hard");

    private String dificultad;

    Dificultad(String dificultad) {
        this.dificultad=dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public static Dificultad getDificultad(String dificultad){
        for (Dificultad d: Dificultad.values()){
            if (d.getDificultad().equalsIgnoreCase(dificultad)) return d;
        }
        return null;
    }
}
