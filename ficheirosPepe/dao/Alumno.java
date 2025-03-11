package com.pepinho.ad.e05baloncesto.dao;

/**
 * Clase do modelo.
 *
 */

import java.util.List;
import java.util.Objects;

public class Alumno {
    private String nome;
    private String email;
    private Integer idade; //

    public Alumno() {
    }

    public Alumno(String nome) {
        this.nome = nome;
    }

    public Alumno(String nome, String email, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    List<Alumno> getAlumnos() {
        return List.of(new Alumno("Pepe", "pepcalod@gmail.com", 23),
                new Alumno("Xan"), new Alumno("Ana"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(nome, alumno.nome);
    }

    @Override
    public String toString() {
        return nome + ' ' + " (" + email + ") " + idade;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }


}
