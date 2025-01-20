package org.example.trivial;

import java.util.function.Predicate;

public class PreguntaVerdaderoFalso extends Pregunta implements Predicate<Integer> {
    private Boolean respuesta;

    public PreguntaVerdaderoFalso() {}

    public PreguntaVerdaderoFalso(String pregunta) {
        super(pregunta);
    }

    public PreguntaVerdaderoFalso(String pregunta, Boolean respuesta) {
        super(pregunta);
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("\n\t 1. Verdadero").append(respuesta ? "[ * ]" : "");
        stringBuilder.append("\n\t 2. Falso").append(respuesta ? "" : "[ * ]");
        return stringBuilder.toString();
    }

    @Override
    public boolean test(Integer integer) {
        if (integer==1) return true == respuesta;
        if (integer==2) return false == respuesta;
        return false;
    }
}
