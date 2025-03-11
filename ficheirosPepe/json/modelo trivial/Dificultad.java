package com.pepinho.ad.trivial.model;

import java.util.Arrays;

public enum Dificultad {
    EASY("Fácil"), MEDIUM("Media"), HARD("Difícil");

    Dificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    private String dificultad;

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public static Dificultad getDificultad(String dificultad) {
        return Arrays.stream(Dificultad.values())
                .filter(d -> d.getDificultad()
                        .equalsIgnoreCase(dificultad)
                        || d.name().equalsIgnoreCase(dificultad))
                .findFirst().orElse(null);
//        for (Dificultad d : Dificultad.values()) {
//            if (d.getDificultad().equals(dificultad) || d.name().equalsIgnoreCase(dificultad)) {
//                return d;
//            }
//        }
//        return null;
    }

}
