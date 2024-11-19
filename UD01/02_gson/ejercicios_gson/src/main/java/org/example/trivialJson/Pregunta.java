package org.example.trivialJson;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Pregunta implements Comparable<Pregunta>, Serializable {
    private Long idPregunta;
    private String pregunta;
    private TipoPregunta tipoPregunta;
    private Categoria categoria;
    private Dificultad dificultad;

    //dios esto dame a sensación de que pode causar mil errores por valores nulos
    public Pregunta(){} //para usar os setters como builder para crear o obxeto

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return idPregunta+". "+pregunta.substring(0,1).toUpperCase()+pregunta.substring(1);
    }

    @Override
    public int compareTo(Pregunta o) {
        if (this==o) return 0;

        //se algunha das comparacións non é 0 devolve esa
        int comparacion=this.pregunta.compareTo(o.getPregunta());
        if (comparacion==0) comparacion=this.tipoPregunta.compareTo(o.getTipoPregunta());
        if (comparacion==0) comparacion=this.dificultad.compareTo(o.getDificultad());
        if (comparacion==0) comparacion=this.categoria.compareTo(o.getCategoria());

        return comparacion;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pregunta pregunta1 = (Pregunta) object;
        return Objects.equals(pregunta, pregunta1.pregunta)
                && tipoPregunta == pregunta1.tipoPregunta
                && Objects.equals(categoria, pregunta1.categoria)
                && dificultad == pregunta1.dificultad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pregunta, tipoPregunta, categoria, dificultad);
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
}
