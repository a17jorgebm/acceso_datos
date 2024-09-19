package org.example.serializacion;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nome;
    private int edad;

    public Persona(String nome, int edad) {
        this.nome = nome;
        this.edad = edad;
    }

    @Override
    public String toString(){
        StringBuilder texto=new StringBuilder();
        texto.append("Nome: ").append(this.nome);
        texto.append("\nEdad: ").append(this.edad);
        return texto.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
