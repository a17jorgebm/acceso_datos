package org.example.trivialJson;

public final class Opcion {
    private String enunciado;
    private boolean correcta;

    public Opcion() {
    }

    public Opcion(String enunciado) {
        this.enunciado = enunciado;
        this.correcta=false;
    }

    public Opcion(String enunciado, boolean correcta) {
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return this.enunciado + (correcta ? "*" : "");
    }
}
