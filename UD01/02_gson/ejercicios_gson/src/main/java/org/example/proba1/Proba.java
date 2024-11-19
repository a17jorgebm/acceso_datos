package org.example.proba1;

import java.util.Date;

public class Proba {
    private String nome;
    private int idade;
    private Date fecha;

    public Proba(String nome, int idade, Date fecha) {
        this.nome = nome;
        this.idade = idade;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Proba{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", fecha=" + fecha +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
