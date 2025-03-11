package com.pepinho.ad.jpa.model;

public enum Conferencia {
    ESTE("EAST"), OESTE("WEST");

    private String valor;

    Conferencia(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

    public static Conferencia of(String nome){
        return switch (nome) {
            case "EAST" -> ESTE;
            case "WEST" -> OESTE;
            default -> null;
        };
    }
}
