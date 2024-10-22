package org.example.trivialJson;

import java.io.Serializable;
import java.util.List;

public class Pregunta implements Comparable<Pregunta>, Serializable {
    private Long idPregunta;
    private String pregunta;
    private TipoPregunta tipoPregunta;
    private Categoria categoria;
    private Dificultad dificultad;
    private List<Opcion> opcions;

    public Pregunta(){} //para usar os setters como builder para crear o obxeto

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(Pregunta o) {
        return 0;
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

    public List<Opcion> getOpcions() {
        return opcions;
    }

    public Pregunta setOpcions(List<Opcion> opcions) {
        this.opcions = opcions;
        return this;
    }
}
