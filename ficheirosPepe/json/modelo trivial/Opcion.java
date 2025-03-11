package com.pepinho.ad.trivial.model;

public final class Opcion {
    private String enunciado;
    private boolean correcta;

    public Opcion() {
    }

    public Opcion(String enunciado) {
        this.enunciado = enunciado;
    }

    public Opcion(String enunciado, boolean correcta) {
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        // Devuelve el enunciado con la primera letra en mayúsculas y el resto en minúsculas, marcando la respuesta correcta con un asterisco:
        return (enunciado!=null && !enunciado.isEmpty()) ?
                Character.toUpperCase(enunciado.charAt(0))
                + enunciado.substring(1).toLowerCase()
                        + (correcta ? " *" : "") : "-";

    }
}
