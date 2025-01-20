package org.example.ejer1Proba;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Pelicula implements Serializable {
    @Id
    private Long idPelicula;
    private String titulo;
    private Short ano;

    private transient LocalDate fechaCreacion;

    public Pelicula() {}

    public Pelicula(Short ano, String titulo) {
        this.ano = ano;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                '}';
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }
}
