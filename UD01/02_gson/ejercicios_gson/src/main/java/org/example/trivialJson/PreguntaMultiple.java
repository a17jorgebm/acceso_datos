package org.example.trivialJson;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class PreguntaMultiple extends Pregunta implements Predicate<Integer> {
    private List<Opcion> opcions;

    public PreguntaMultiple() {
        super();
        this.opcions = new LinkedList<>();
    }

    public PreguntaMultiple(String pregunta) {
        super(pregunta);
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(super.toString());
        int i=1;
        for (Opcion o:opcions){
            builder.append("\t").append(i).append(". ").append(o.getEnunciado());
        }
        return builder.toString();
    }

    @Override
    public boolean test(Integer integer) {
        if ((integer-1)<0 || integer>opcions.size()) return false;
        Opcion o=opcions.get(integer);
        if (o==null) return false;
        return o.isCorrecta();
    }

    public List<Opcion> getOpcions() {
        return opcions;
    }

    public PreguntaMultiple setOpcions(List<Opcion> opcions) {
        this.opcions = opcions;
        return this;
    }

    public PreguntaMultiple addOpcion(Opcion opcion){
        this.opcions.add(opcion);
        return this;
    }

    public PreguntaMultiple addOpciones(List<Opcion> opciones){
        this.opcions.addAll(opciones);
        return this;
    }

    public int getNumCorrectas(){
        return (int)this.opcions
                .stream()
                .filter(Opcion::isCorrecta)
                .count();
    }

    public int getPuntos(List<Integer> marcadas){
        int correctas=0;
        int incorrectas=0;
        for (Integer m:marcadas){
            if ((m-1)<0 || m>opcions.size()) continue;
            if (opcions.get(m)==null) continue;

            if (opcions.get(m).isCorrecta()){
                correctas++;
            }else {
                incorrectas++;
            }
        }
        return (correctas-incorrectas)/getNumCorrectas(); //pode dar excepcion div entre 0
    }
}
