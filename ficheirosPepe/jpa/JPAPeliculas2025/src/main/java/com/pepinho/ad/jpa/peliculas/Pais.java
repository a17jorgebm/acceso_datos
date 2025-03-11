package com.pepinho.ad.jpa.peliculas;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Pais {

    @Id
    @Column(length = 125)
    private String pais;

    public Pais() {
    }

    public Pais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais pais1)) return false;
        return Objects.equals(pais, pais1.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pais);
    }

    @Override
    public String toString() {
        return pais;
    }
}
