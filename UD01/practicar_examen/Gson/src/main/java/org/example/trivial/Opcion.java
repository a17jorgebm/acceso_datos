package org.example.trivial;

public final class Opcion {
    private String enunciado;
    private Boolean correcta;

    public Opcion() {}

    public Opcion(String enunciado) {
        this.enunciado = enunciado;
        this.correcta=false;
    }

    public Opcion(String enunciado, Boolean correcta) {
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    @Override
    public String toString(){
        if (enunciado==null||correcta==null) return null;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(enunciado);
        if (correcta) stringBuilder.append("*");

        return stringBuilder.toString();
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }
}
