package org.example.trivialJson;

public enum Dificultad {
    EASY("Fácil"), MEDIUM("Media"), HARD("Difícil");

    private String dificultad;

    Dificultad(String dificultad) {
        this.dificultad=dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public Dificultad getDificultad(String dificultad){
        for (Dificultad d: Dificultad.values()){
            if (d.getDificultad().equalsIgnoreCase(dificultad)) return d;
        }
        return null;
    }
}
