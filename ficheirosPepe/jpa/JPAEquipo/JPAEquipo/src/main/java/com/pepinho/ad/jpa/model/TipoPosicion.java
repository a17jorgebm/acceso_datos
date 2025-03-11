package com.pepinho.ad.jpa.model;

import java.util.Arrays;

public enum TipoPosicion {
    // ‘G’, ‘C’, ‘F’, ‘F-C’, ‘C-F’, ‘F-G’, ‘G-F’
    BASE("Point Guard"), ESCOLTA("Shooting Guard"), ALERO("Forward"), ALA_PIVOT("Power Forward"),
    PIVOT("Center");

    private final String valor;

    TipoPosicion(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

    public static TipoPosicion of(String nome){
        return Arrays.stream(TipoPosicion.values())
                .filter(tipoPosicion -> tipoPosicion.valor.equalsIgnoreCase(nome))
                .findFirst().orElse(null);
    }
}
