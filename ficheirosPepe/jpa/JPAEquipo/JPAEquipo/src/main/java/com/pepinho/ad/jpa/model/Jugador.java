package com.pepinho.ad.jpa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  entidad Jugador con los siguientes atributos:
 *
 * idJugador: identificador del jugador.
 * nombre: nombre del jugador.
 * apellidos: apellidos del jugador.
 * equipo: equipo al que pertenece el jugador.
 * altura: altura del jugador (Double).
 * peso: peso del jugador (Double).
 * numero: número de camiseta del jugador (SmallInt).
 * anoDraft: año de elección en el draft (entero).-
 * numeroDraft: número de elección en el draft (SmallInt).
 * rondaDraft: ronda de elección en el draft (SmallInt).
 * posicion: posición en la que juega (base, escolta, alero, ala-pívot, pívot, como enumeración, que debe guardarse como ‘G’, ‘C’, ‘F’, ‘F-C’, ‘C-F’).
 * pais: país de origen del jugador.
 * colegio: universidad o equipo en el que jugó.
 * foto: foto del jugador.
 */

@Entity
public class Jugador implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJugador")
    private Long idJugador;
    private String nombre;
    private String apellidos;
    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;
    private Double altura;
    private Double peso;
    private Short numero;
    private Integer anoDraft;
    private Short numeroDraft;
    private Short rondaDraft;
    @ManyToMany
    @Basic(fetch = FetchType.LAZY)
    @JoinTable(name = "JugadorPosicion", joinColumns = {@JoinColumn(name = "idJugador")},
            inverseJoinColumns = @JoinColumn(name = "idPosicion"))
    private List<Posicion> posicions = new ArrayList<>();
    private String pais;
    private String colegio;
    private byte[] foto;

    public Jugador() {
    }

    public Jugador(String nombre, String apellidos, Equipo equipo, Double altura, Double peso, Short numero,
                   Integer anoDraft, Short numeroDraft, Short rondaDraft, Posicion tipoPosicion, String pais, String colegio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
        this.anoDraft = anoDraft;
        this.numeroDraft = numeroDraft;
        this.rondaDraft = rondaDraft;
        this.posicions.add(tipoPosicion);
        this.pais = pais;
        this.colegio = colegio;
    }

    public Long getidJugador() {
        return idJugador;
    }

    public void setIidJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getAnoDraft() {
        return anoDraft;
    }

    public void setAnoDraft(Integer anoDraft) {
        this.anoDraft = anoDraft;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public Short getNumeroDraft() {
        return numeroDraft;
    }

    public void setNumeroDraft(Short numeroDraft) {
        this.numeroDraft = numeroDraft;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public List<Posicion> getPosicions() {
        return posicions;
    }

    public void setPosicions(List<Posicion> posicions) {
        this.posicions = posicions;
    }

    public void  addPosicion(Posicion posicion){
        this.posicions.add(posicion);
    }

    public Short getRondaDraft() {
        return rondaDraft;
    }

    public void setRondaDraft(Short rondaDraft) {
        this.rondaDraft = rondaDraft;
    }

    @Override
    public String toString() {
        return '[' + idJugador + "] " + nombre + " " + apellidos + " [" + numero +
                "] (" + (equipo!=null ? equipo.getNombre() : "-") +
                ") " + altura +
                " cm, " + peso +
                " kg, " + numeroDraft +
                " del draft de la ronda " + rondaDraft
                + " del " + anoDraft +
                ", " + posicions +
                ", '" + pais + '\'' +
                ", procendente de '" + colegio;
    }
}