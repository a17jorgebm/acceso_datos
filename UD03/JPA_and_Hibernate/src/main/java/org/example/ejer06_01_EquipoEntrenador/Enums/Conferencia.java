package org.example.ejer06_01_EquipoEntrenador.Enums;

public enum Conferencia {
    ESTE("EAST"),OESTE("WEST");

    private String texto;

    Conferencia(String texto){
        this.texto=texto;
    }

    public String getTexto() {
        return texto;
    }

    public static Conferencia from(String texto){
        Conferencia[] conferencias = Conferencia.values();
        for (Conferencia conferencia : conferencias) {
            if (conferencia.getTexto().equals(texto)) {
                return conferencia;
            }
        }
        return null;
    }
}
