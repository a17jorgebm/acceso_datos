package com.pepinho.ad.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Posicion {

    @Id
    private String idPosicion;
    private TipoPosicion posicion;
    private String descripcion;

    public Posicion() {
    }

    public Posicion(String idPosicion, TipoPosicion posicion, String descripcion) {
        this.idPosicion = idPosicion;
        this.posicion = posicion;
        this.descripcion = descripcion;
    }

    public Posicion(String idPosicion, TipoPosicion posicion) {
        this.idPosicion = idPosicion;
        this.posicion = posicion;
    }

    public String getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(String idPosicion) {
        this.idPosicion = idPosicion;
    }

    public TipoPosicion getPosicion() {
        return posicion;
    }

    public void setPosicion(TipoPosicion posicion) {
        this.posicion = posicion;
    }

    public Posicion(TipoPosicion posicion) {
        this.posicion = posicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return posicion.toString();
    }
}
