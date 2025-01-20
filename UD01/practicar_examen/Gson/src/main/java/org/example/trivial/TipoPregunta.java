package org.example.trivial;

public enum TipoPregunta {
    BOOLEAN("boolean"),MULTIPLE("multiple");

    private final String tipoPregunta;

    TipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getTipoPregunta(){
        return tipoPregunta;
    }

    public static TipoPregunta getTipoPreguntaFromString(String texto){
        for (TipoPregunta t : TipoPregunta.values()){
            if (t.getTipoPregunta().equalsIgnoreCase(texto)) return t;
        }
        return null;
    }
}
