package com.pepinho.ad.jpa.peliculas;

/**
 Acción y aventura
 Animación
 Aventura
 Ciencia ficción
 Comedia
 Crimen
 Drama
 Erótico
 Guerra
 Histórico
 Infantil
 Musical
 Policial
 Terror
 Thriller
 Vanguardia
 Western
 */
public enum Xenero {

    ACCION_AVENTURA("Acción y aventura"),
    ANIMACION("Animación"),
    AVENTURA("Aventura"),
    CIENCIA_FICCION("Ciencia ficción"),
    COMEDIA("Comedia"),
    CRIMEN("Crimen"),
    DRAMA("Drama"),
    EROTICO("Erótico"),
    GUERRA("Guerra"),
    HISTORICO("Histórico"),
    INFANTIL("Infantil"),
    MUSICAL("Musical"),
    POLICIAL("Policial"),
    TERROR("Terror"),
    THRILLER("Thriller"),
    VANGUARDIA("Vanguardia"),
    WESTERN("Western");

    private final String xenero;

    Xenero(String xenero) {
        this.xenero = xenero;
    }

    public String getXenero() {
        return xenero;
    }

    @Override
    public String toString() {
        return xenero;
    }

    public static Xenero of(String xenero) {
        for (Xenero x : Xenero.values()) {
            if (x.getXenero().equalsIgnoreCase(xenero)) {
                return x;
            }
        }
        return null;
    }

}
