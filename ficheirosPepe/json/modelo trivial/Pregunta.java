package com.pepinho.ad.trivial.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Pregunta implements Serializable, Comparable<Pregunta> {

    public static final String TABULACION = "  ";

    private Long idPregunta;
    private TipoPregunta tipoPregunta;
    private Dificultad dificultad;
    private Categoria categoria;
    private String pregunta;


    public Pregunta() {
    }

    public Pregunta(String pregunta) { //}, TipoPregunta tipoPregunta, Dificultad dificultad, Categoria categoria) {
        this.pregunta = pregunta;
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

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public Pregunta setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
        return this;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public Pregunta setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Pregunta setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(pregunta).append(" ")
                .append(tipoPregunta).append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Pregunta p) && Objects.equals(pregunta, p.pregunta);
//        return (o instanceof Pregunta p) &&
//                tipoPregunta == p.tipoPregunta &&
//                dificultad == p.dificultad
//                && Objects.equals(pregunta, p.pregunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pregunta);
//        return Objects.hash(tipoPregunta, dificultad, pregunta);
    }

    @Override
    public int compareTo(Pregunta o) {

        return this.pregunta.compareToIgnoreCase(o.pregunta);
//        int comparacion;
//        return ((comparacion = dificultad.compareTo(o.dificultad)) != 0) ? comparacion :
//                ((comparacion = tipoPregunta.compareTo(o.tipoPregunta)) != 0) ?
//                        comparacion : pregunta.compareTo(o.pregunta);

//        int comparacion = dificultad.compareTo(o.dificultad);
//        if (comparacion == 0) {
//            comparacion = tipoPregunta.compareTo(o.tipoPregunta);
//            if (comparacion == 0) {
//                comparacion = pregunta.compareTo(o.pregunta);
//            }
//        }
//        return comparacion;
    }
}
