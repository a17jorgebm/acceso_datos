package com.pepinho.ad.trivial.model;

import java.util.Objects;

public final class Categoria {
    public static final String DEFAUlT_CATEGORY = "General Knowledge";
    private final String nome;

    public Categoria() {
        this.nome = DEFAUlT_CATEGORY;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return  (o instanceof Categoria categoria) && Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
