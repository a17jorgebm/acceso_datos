package com.pepinho.ad.trivial.model;

import java.util.function.Predicate;

/*
Clase `PreguntaVerdaderoFalso` que hereda de `Pregunta` e implementa la interfaz `Predicate<Boolean>`.

 */
public class PreguntaBoolean extends Pregunta implements Predicate<Boolean> {
    private boolean respuesta;

    public PreguntaBoolean() {
        setTipoPregunta(TipoPregunta.BOOLEAN);
    }

    public PreguntaBoolean(String pregunta) {
        super(pregunta);
        setTipoPregunta(TipoPregunta.BOOLEAN);
    }

    public PreguntaBoolean(String pregunta, boolean respuesta) {
        super(pregunta);
        this.respuesta = respuesta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public PreguntaBoolean setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
        return this;
    }

    @Override
    public String toString() {
        return super.toString()
                + TABULACION + "a. Verdadero" + (respuesta ? " *" : "") + System.lineSeparator()
                + TABULACION + "b. Falso" + (respuesta ? "" : " *");
    }

    @Override
    public boolean test(Boolean aBoolean) {
        return respuesta == aBoolean;
    }
}
