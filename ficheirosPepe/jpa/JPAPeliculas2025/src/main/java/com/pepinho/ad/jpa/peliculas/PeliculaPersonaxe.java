package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.*;

@Entity
public class PeliculaPersonaxe {

    @EmbeddedId
    private IdPeliculaPersonaxe idPeliculaPersonaxe;

    @ManyToOne
    @MapsId("idPelicula")
    @JoinColumn(name = "idPelicula")
    private Pelicula pelicula;

    @ManyToOne
    @MapsId("idPersonaxe")
    @JoinColumn(name = "idPersonaxe")
    private Personaxe personaxe;

    @ManyToOne
    @MapsId("ocupacion")
    @JoinColumn(name = "ocupacion")
    private Ocupacion ocupacion;

    private String personaxeInterpretado;

    public PeliculaPersonaxe() {
    }

    public PeliculaPersonaxe(Pelicula pelicula, Personaxe personaxe, Ocupacion ocupacion, String personaxeInterpretado) {
        this.pelicula = pelicula;
        this.personaxe = personaxe;
        this.ocupacion = ocupacion;
        this.personaxeInterpretado = personaxeInterpretado;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Personaxe getPersonaxe() {
        return personaxe;
    }

    public void setPersonaxe(Personaxe personaxe) {
        this.personaxe = personaxe;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getPersonaxeInterpretado() {
        return personaxeInterpretado;
    }

    public void setPersonaxeInterpretado(String personaxeInterpretado) {
        this.personaxeInterpretado = personaxeInterpretado;
    }

    @Override
    public String toString() {
        return " [" + personaxe +
                "] (" + ocupacion +
                ") as '" + personaxeInterpretado + '\'';
    }
}
