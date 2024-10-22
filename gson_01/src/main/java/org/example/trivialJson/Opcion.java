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

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
}
