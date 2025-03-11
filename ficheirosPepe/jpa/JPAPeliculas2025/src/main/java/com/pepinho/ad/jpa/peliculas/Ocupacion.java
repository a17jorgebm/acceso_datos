package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Ocupacion {

    @Id
    private String ocupacion;
    private Integer orde;

    @OneToMany(mappedBy = "ocupacion")
    @Basic(fetch = jakarta.persistence.FetchType.LAZY)
    private List<PeliculaPersonaxe> peliculaPersonaxes;

    public Ocupacion() {
    }

    public Ocupacion(String ocupacion, Integer orde) {
        this.ocupacion = ocupacion;
        this.orde = orde;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getOrde() {
        return orde;
    }

    public void setOrde(Integer orde) {
        this.orde = orde;
    }

    public List<PeliculaPersonaxe> getPeliculaPersonaxes() {
        return peliculaPersonaxes;
    }

    public void setPeliculaPersonaxes(List<PeliculaPersonaxe> peliculaPersonaxes) {
        this.peliculaPersonaxes = peliculaPersonaxes;
    }

    public void addPeliculaPersonaxe(PeliculaPersonaxe peliculaPersonaxe) {
        this.peliculaPersonaxes.add(peliculaPersonaxe);
    }

    @Override
    public String toString() {
        return "[" + ocupacion + "] (" + orde + ')';
    }
}
