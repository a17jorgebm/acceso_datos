package com.pepinho.ad.jpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Periodista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeriodista;
    private String nome;

    @OneToMany(mappedBy = "periodista")
    @ToString.Exclude
    private List<PeriodistaEquipo> equipos;

    public Periodista(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Periodista{" +
                "idPeriodista=" + idPeriodista +
                ", nome='" + nome + '\'' +
                '}';
    }
}
