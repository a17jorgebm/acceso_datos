package com.pepinho.ad.jpa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Entrenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrenador;
    private String nombre;
    private Integer salario;

    @OneToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;
    private LocalDate fechaNacimiento;

    public Entrenador() {
    }

    public Entrenador(Long idEntrenador, String nombre, Integer salario, Equipo equipo, LocalDate fechaNacimiento) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.salario = salario;
        this.equipo = equipo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Entrenador(String nombre, Integer salario, Equipo equipo, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.salario = salario;
        this.equipo = equipo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrenador that)) return false;
        return Objects.equals(idEntrenador, that.idEntrenador);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idEntrenador);
    }

    @Override
    public String toString() {
        return '[' + idEntrenador +
                "] " + nombre + '\'' +
                ", " + salario +
                ", " + equipo +
                ", " + fechaNacimiento;
    }
}
