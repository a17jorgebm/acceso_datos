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

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}
