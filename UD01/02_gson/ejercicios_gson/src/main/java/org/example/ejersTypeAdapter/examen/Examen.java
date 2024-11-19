package org.example.ejersTypeAdapter.examen;

import java.time.LocalDateTime;
import java.util.List;

public class Examen {
    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Examen() {
    }

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "materia='" + materia + '\'' +
                ", fecha=" + fecha +
                ", participantes=" + participantes +
                '}';
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }
}
