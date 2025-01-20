package org.example.trivial;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PreguntaMultiple extends Pregunta implements Predicate<Integer> {

    private List<Opcion> opciones;

    public PreguntaMultiple() {
        this.opciones=new LinkedList<>();
    }

    public PreguntaMultiple(String pregunta) {
        super(pregunta);
        this.opciones=new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        int i=1;
        for (Opcion o:opciones){
            stringBuilder.append("\n\t").append(i++).append(". ").append(o.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean test(Integer integer) {
        if(opciones==null || opciones.isEmpty()) return false;
        if (integer<1 || integer>(opciones.size())) return false;
        return opciones.get(integer-1).getCorrecta();
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public PreguntaMultiple addOpcion(Opcion opcion) {
        this.opciones.addAll(opciones);
        return this;
    }

    public PreguntaMultiple addOpciones(List<Opcion> opciones) {
        this.opciones.addAll(opciones);
        return this;
    }
}
