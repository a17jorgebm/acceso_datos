package org.example.trivial;

public enum Dificultad {
    EASY("easy"),MEDIUM("medium"),HARD("hard");

    private final String dificultad;

    Dificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDificultad(){
        return dificultad;
    }

    public static Dificultad getDificultadFromText(String text){
        for (Dificultad d : Dificultad.values()){
            if (d.getDificultad().equalsIgnoreCase(text)) return d;
        }
        return null;
    }
}
