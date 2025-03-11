package com.pepinho.ad.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;
    private String nome;
    private String apelidos;
    private LocalDate dataNacemento;
    private String direccion;

    public Estudiante() {


    }

    public Estudiante(Long idEstudiante, String nome, String apelidos, LocalDate dataNacemento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.nome = nome;
        this.apelidos = apelidos;
        this.dataNacemento = dataNacemento;
        this.direccion = direccion;
    }

    public Estudiante(String nome, String apelidos, LocalDate dataNacemento) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.dataNacemento = dataNacemento;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "[" + idEstudiante + "] " + nome + " " + apelidos + '\'' +
                " (" + dataNacemento + ") " + direccion;
    }
}
