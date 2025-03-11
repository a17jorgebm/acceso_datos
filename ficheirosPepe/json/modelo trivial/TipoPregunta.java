package com.pepinho.ad.trivial.model;

import java.util.Arrays;

public enum TipoPregunta {
    MULTIPLE("Multiple"), BOOLEAN("Verdadero/Falso");

    private String tipoPregunta;

    TipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public static TipoPregunta getTipoPregunta(String tipoPregunta) {
        // Con programación funcional:
        return Arrays.stream(TipoPregunta.values())
                .filter(tp -> tp.getTipoPregunta().equalsIgnoreCase(tipoPregunta)
                        || tp.name().equalsIgnoreCase(tipoPregunta))
                .findFirst()
                .orElse(null);

//        for (TipoPregunta tp : TipoPregunta.values()) {
//            if (tp.getTipoPregunta().equals(tipoPregunta) || tp.name().equals(tipoPregunta)) {
//                return tp;
//            }
//        }
//        return null;
    }
}
