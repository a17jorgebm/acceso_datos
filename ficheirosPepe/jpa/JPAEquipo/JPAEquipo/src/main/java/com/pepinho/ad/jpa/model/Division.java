package com.pepinho.ad.jpa.model;

import java.util.Arrays;

public enum Division {
    ATLANTICO("ATLANTIC"), CENTRAL("CENTRAL"), SURESTE("SOUTHEAST"),
    NOROESTE("NORTHWEST"), PACIFICO("PACIFIC"), SUROESTE("SOUTHWEST");

    private String valor;

    Division(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

//    public String getInEnglish() {
//        return switch (this) {
//            case ATLANTICO -> "ATLANTIC";
//            case CENTRAL -> "CENTRAL";
//            case SURESTE -> "SOUTHEAST";
//            case NOROESTE -> "NORTHWEST";
//            case PACIFICO -> "PACIFIC";
//            case SUROESTE -> "SOUTHWEST";
//        };
//    }

    public static Division of(String nome) {
        return Arrays.stream(Division.values())
                .filter(division -> division.valor.equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}
