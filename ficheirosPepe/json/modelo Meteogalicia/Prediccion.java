package com.pepinho.ad.gson.meteogalicia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prediccion {

    public static final String BARRA = "--------------------------------------------------";

    private Concello concello;
    private List<PrediccionDia> listaPredDiaConcello;

    public Prediccion() {
        listaPredDiaConcello = new ArrayList<>();
    }

    public Prediccion(Concello concello) {
        this.concello = concello;
        listaPredDiaConcello = new ArrayList<>();
    }

    public Concello getConcello() {
        return concello;
    }

    public void setConcello(Concello concello) {
        this.concello = concello;
    }

    public List<PrediccionDia> getListaPredDiaConcello() {
        return listaPredDiaConcello;
    }

    public void setListaPredDiaConcello(List<PrediccionDia> listaPredDiaConcello) {
        this.listaPredDiaConcello = listaPredDiaConcello;
    }

    public void addPredDiaConcello(PrediccionDia predDia){
        listaPredDiaConcello.add(predDia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediccion that = (Prediccion) o;
        return Objects.equals(concello, that.concello);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(concello);
    }

    @Override
    public String toString() {
        return concello + System.lineSeparator() + BARRA + System.lineSeparator()
                + listaPredDiaConcello.stream().collect(StringBuilder::new,
                (sb, pd) -> sb.append(pd).append(System.lineSeparator())
                        .append(BARRA).append(System.lineSeparator()), StringBuilder::append);
    }


}
