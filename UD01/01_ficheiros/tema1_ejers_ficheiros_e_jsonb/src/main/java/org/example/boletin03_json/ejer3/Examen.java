package org.example.boletin03_json.ejer3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Examen {
    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Examen(String materia, LocalDateTime fecha) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = new ArrayList<>();
    }

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        StringBuilder builder=new StringBuilder();
        builder.append(this.materia);
        builder.append("\n").append(this.fecha.format(formatter));
        builder.append("\n").append("Participantes");
        participantes.forEach(p -> builder.append("\n").append(p));
        return builder.toString();
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
