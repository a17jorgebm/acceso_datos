package com.pepinho.ad.jpa.peliculas;

/**
 * B/N
 * B/N  y Color
 * Color
 */
public enum Cor {
    BN("B/N"),
    BN_Y_COLOR("B/N y Color"),
    COLOR("Color");

    private final String cor;

    Cor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public static Cor of(String cor) {
        for (Cor c : Cor.values()) {
            if (c.getCor().trim().equalsIgnoreCase(cor)) {
                return c;
            }
        }
        return null;
    }
}
