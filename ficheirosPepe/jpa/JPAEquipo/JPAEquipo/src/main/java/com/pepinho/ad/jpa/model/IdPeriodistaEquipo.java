package com.pepinho.ad.jpa.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdPeriodistaEquipo implements Serializable {
    private Long idPeriodista;
    private Long idEquipo;

    public IdPeriodistaEquipo() {
    }

    public IdPeriodistaEquipo(Long idPeriodista, Long idEquipo) {
        this.idPeriodista = idPeriodista;
        this.idEquipo = idEquipo;
    }

    public Long getIdPeriodista() {
        return idPeriodista;
    }

    public void setIdPeriodista(Long idPeriodista) {
        this.idPeriodista = idPeriodista;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdPeriodistaEquipo that)) return false;
        return Objects.equals(idPeriodista, that.idPeriodista) && Objects.equals(idEquipo, that.idEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPeriodista, idEquipo);
    }

    @Override
    public String toString() {
        return '[' +idPeriodista + ", " + idEquipo + ']';
    }
}
