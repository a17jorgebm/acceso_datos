package org.example.ejer06_01_EquipoEntrenador.Enums;

public enum Division {
    ATLANTICO("ATLANTIC"),
    CENTRAL("CENTRAL"),
    SURESTE("SOUTHEAST"),
    NOROESTE("NORTHWEST"),
    PACIFICO("PACIFIC"),
    SUROESTE("SOUTHWEST");

    private String texto;

    Division(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public static Division from(String texto) {
        Division[] divisiones = Division.values();
        for (Division division : divisiones) {
            if (division.getTexto().equals(texto)) {
                return division;
            }
        }
        return null;
    }
}

