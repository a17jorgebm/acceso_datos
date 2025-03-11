package com.pepinho.ad.jpa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;
    @Column(length = 128, nullable = false)
    private String nombre;
    private String ciudad;
    private Conferencia conferencia;
    @Column(length = 64)
    private Division division;
    @Column(length = 64)
    private String nombreCompleto;
    @Column(length = 4)
    private String abreviatura;
    @OneToOne(mappedBy = "equipo")
    private Entrenador entrenador;
    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores = new ArrayList<>();

    @OneToMany(mappedBy = "equipo")
    private List<PeriodistaEquipo> periodistas;

    public Equipo() {
    }

    public Equipo(String nombre, String ciudad, Conferencia conferencia, Division division, String nombreCompleto, String abreviatura) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
        this.nombreCompleto = nombreCompleto;
        this.abreviatura = abreviatura;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo equipo)) return false;
        return Objects.equals(abreviatura, equipo.abreviatura);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(abreviatura);
    }

    @Override
    public String toString() {
        return '[' + idEquipo + "] " + nombreCompleto + '(' + abreviatura + ") " +
                ", " + ciudad + '\'' +
                ", " + conferencia +
                ", " + division;
    }
}
