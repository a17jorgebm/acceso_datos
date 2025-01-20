package org.example.trivialJson;

import java.util.function.Predicate;

public class PreguntaVerdaderoFalso extends Pregunta implements Predicate<Boolean> {
    private boolean respuesta;

    public PreguntaVerdaderoFalso() {}

    public PreguntaVerdaderoFalso(String pregunta) {
        super(pregunta);
    }

    public PreguntaVerdaderoFalso(String pregunta, boolean respuesta) {
        super(pregunta);
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(super.toString());
        builder.append("\n\ta. Verdadero").append(this.respuesta ? "[*]" : "");
        builder.append("\n\tb. Falso").append(this.respuesta ? "[*]" : "");
        return builder.toString();
    }

    @Override
    public boolean test(Boolean b) {
        return b==this.respuesta;
    }
}
