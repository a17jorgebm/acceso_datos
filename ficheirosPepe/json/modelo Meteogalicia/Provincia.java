package com.pepinho.ad.gson.meteogalicia.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Provincia {

    public static final String BARRA = "--------------------------------------------------";

    private Integer idProvincia;
    private String nome;
    private List<Concello> concellos;

    public Provincia() {
        concellos = new ArrayList<>();
    }

    public Provincia(String nome) {
        this.nome = nome;
        concellos = new ArrayList<>();
    }

    public Provincia(Integer idProvincia, String nome) {
        this.idProvincia = idProvincia;
        this.nome = nome;
        concellos = new ArrayList<>();
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Concello> getConcellos() {
        return concellos;
    }

    public void setConcellos(List<Concello> concellos) {
        this.concellos = concellos;
    }

    public void addConcello(Concello c) {
        concellos.add(c);
    }

    @Override
    public String toString() {
        return BARRA + System.lineSeparator() +
                "[" + idProvincia + "] " + nome + ": " + System.lineSeparator()
                + BARRA + System.lineSeparator()
                + concellos.stream().collect(StringBuilder::new,
                (sb, c) -> sb.append(c.toString()).append(System.lineSeparator()), StringBuilder::append).toString();
    }

}
