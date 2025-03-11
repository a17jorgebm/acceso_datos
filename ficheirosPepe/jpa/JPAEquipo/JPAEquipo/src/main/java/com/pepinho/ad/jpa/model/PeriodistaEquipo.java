package com.pepinho.ad.jpa.model;

import jakarta.persistence.*;

@Entity
public class PeriodistaEquipo {
    @EmbeddedId
    private IdPeriodistaEquipo id;

    @ManyToOne
    @MapsId("idPeriodista")
    @JoinColumn(name = "idPeriodista")
    private Periodista periodista;
    @ManyToOne
    @MapsId("idEquipo")
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;
    private Integer temporada;


}
