package org.example.trivialJson;

import java.util.function.Predicate;

public class PreguntaVerdaderoFalso extends Pregunta implements Predicate<boolean> {
    private boolean respuesta;

    public PreguntaVerdaderoFalso() {}

    public PreguntaVerdaderoFalso(String pregunta) {
        super(pregunta);
    }

    public PreguntaVerdaderoFalso(String pregunta, boolean respuesta) {
        super(pregunta);
        this.respuesta = respuesta;
    }
}
