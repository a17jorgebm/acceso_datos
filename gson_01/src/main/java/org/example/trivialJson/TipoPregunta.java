package org.example.trivialJson;

public enum TipoPregunta {
    MULTIPLE("Multiple"),BOOLEAN("Verdadero/Falso");

    String tipoPregunta;

    TipoPregunta(String tipoPregunta){
        this.tipoPregunta=tipoPregunta;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public static TipoPregunta getTipoPregunta(String tipoPregunta){
        for (TipoPregunta tipo : TipoPregunta.values()){
            if (tipo.tipoPregunta.equalsIgnoreCase(tipoPregunta)) return tipo;
        }
        return null;
    }
}
