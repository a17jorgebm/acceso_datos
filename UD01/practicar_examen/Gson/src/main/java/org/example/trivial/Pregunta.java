package org.example.trivial;

import java.io.Serializable;
import java.util.Objects;

public class Pregunta implements Comparable<Pregunta>, Serializable {

    private Long idPregunta;
    private TipoPregunta tipoPregunta;
    private Dificultad dificultad;
    private Categoria categoria;
    private String pregunta;

    public Pregunta() {}

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String textoPreguntaConMayusc =
                this.pregunta.substring(0,1).toUpperCase()
                + this.pregunta.substring(1);
        stringBuilder.append("\n").append(idPregunta).append(". ").append(textoPreguntaConMayusc);
        return stringBuilder.toString();
    }

    /**
     * Compares 2 questions based on the text, if its equal, then it compares the type, the difficulty and the category
     * @param o the object to be compared.
     * @return -1 or 1 if different, 0 if equal
     */
    @Override
    public int compareTo(Pregunta o) {
        int resultado = this.pregunta.compareTo(o.pregunta);

        if (resultado!=0) return resultado;

        resultado = this.tipoPregunta.compareTo(o.tipoPregunta);
        if (resultado!=0) return resultado;

        resultado = this.dificultad.compareTo(o.dificultad);
        if (resultado!=0) return resultado;

        return this.categoria.compareTo(o.categoria);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pregunta pregunta1 = (Pregunta) object;
        return tipoPregunta == pregunta1.tipoPregunta && dificultad == pregunta1.dificultad && Objects.equals(categoria, pregunta1.categoria) && Objects.equals(pregunta, pregunta1.pregunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoPregunta, dificultad, categoria, pregunta);
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public Pregunta setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
        return this;
    }

    public String getPregunta() {
        return pregunta;
    }

    public Pregunta setPregunta(String pregunta) {
        this.pregunta = pregunta;
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

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public Pregunta setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
        return this;
    }
}
