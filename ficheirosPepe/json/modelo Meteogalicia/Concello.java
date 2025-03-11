package com.pepinho.ad.gson.meteogalicia.model;

public class Concello {

    private String nome;
    private Integer idConcello;

    public Concello() {
    }

    public Concello(String nome) {
        this.nome = nome;
    }

    public Concello(String nome, Integer idConcello) {
        this.nome = nome;
        this.idConcello = idConcello;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdConcello() {
        return idConcello;
    }

    public void setIdConcello(Integer idConcello) {
        this.idConcello = idConcello;
    }

    @Override
    public String toString() {
        return nome + " [" +idConcello + ']';
    }
}
