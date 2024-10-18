package org.example.trivialJson;

import java.util.List;

public class Pregunta {
    private String pregunta;
    private Tipo tipoPregunta;
    private Categoria categoria;
    private Dificultad dificultad;
    private String correcta;
    private List<String> incorrectas;

    public Pregunta(){} //para usar os setters como builder para crear o obxeto

    public Pregunta(String pregunta, Tipo tipoPregunta, Categoria categoria, Dificultad dificultad, String correcta, List<String> incorrectas) {
        this.pregunta = pregunta;
        this.tipoPregunta = tipoPregunta;
        this.categoria = categoria;
        this.dificultad = dificultad;
        this.correcta = correcta;
        this.incorrectas = incorrectas;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "pregunta='" + pregunta + '\'' +
                ", tipoPregunta=" + tipoPregunta +
                ", categoria=" + categoria +
                ", dificultad=" + dificultad +
                ", correcta='" + correcta + '\'' +
                ", incorrectas=" + incorrectas +
                '}';
    }

    public String getPregunta() {
        return pregunta;
    }

    public Pregunta setPregunta(String pregunta) {
        this.pregunta = pregunta;
        return this;
    }

    public Tipo getTipoPregunta() {
        return tipoPregunta;
    }

    public Pregunta setTipoPregunta(Tipo tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Pregunta setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public Pregunta setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
        return this;
    }

    public String getCorrecta() {
        return correcta;
    }

    public Pregunta setCorrecta(String correcta) {
        this.correcta = correcta;
        return this;
    }

    public List<String> getIncorrectas() {
        return incorrectas;
    }

    public Pregunta setIncorrectas(List<String> incorrectas) {
        this.incorrectas = incorrectas;
        return this;
    }
}
