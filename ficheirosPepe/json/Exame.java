package com.pepinho.ad.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class Exame {

    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Exame() {
    }

    public Exame(String materia) {
        this.materia = materia;
    }

    public Exame(String materia, LocalDateTime fecha) {
        this.materia = materia;
        this.fecha = fecha;
    }

    public Exame(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
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

    @Override
    public String toString() {
        return materia + ": "+ fecha + participantes;
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

    }
}
