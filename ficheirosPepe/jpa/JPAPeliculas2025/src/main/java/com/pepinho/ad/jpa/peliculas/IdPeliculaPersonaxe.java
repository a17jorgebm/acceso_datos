package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class IdPeliculaPersonaxe implements java.io.Serializable {
    @Column(name = "idPelicula")
    private Long idPelicula;

    @Column(name = "idPersonaxe")
    private Long idPersonaxe;

    @Column(name = "ocupacion")
    private String ocupacion;

    public IdPeliculaPersonaxe() {
    }

    public IdPeliculaPersonaxe(Long idPelicula, Long idPersonaxe, String ocupacion) {
        this.idPelicula = idPelicula;
        this.idPersonaxe = idPersonaxe;
        this.ocupacion = ocupacion;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(Long idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdPeliculaPersonaxe that)) return false;
        return Objects.equals(idPelicula, that.idPelicula) && Objects.equals(idPersonaxe, that.idPersonaxe) && Objects.equals(ocupacion, that.ocupacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, idPersonaxe, ocupacion);
    }

    @Override
    public String toString() {
        return '[' + idPelicula + ", " + idPersonaxe +
                ", " + ocupacion + ']';
    }
}
