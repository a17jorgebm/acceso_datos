package org.example.freeToGame;

public enum Plataforma {
    BROWSER("Web Browser"), PC("Windows"), ALL("All");

    private final String plataforma;

    Plataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma(){
        return plataforma;
    }

    public static Plataforma getPlataformaFromString(String plataforma){
        for (Plataforma p:Plataforma.values()){
            if (p.getPlataforma().equalsIgnoreCase(plataforma)) return p;
        }
        return null;
    }
}
