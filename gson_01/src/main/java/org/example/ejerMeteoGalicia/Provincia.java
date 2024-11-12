package org.example.ejerMeteoGalicia;

import java.util.List;

public class Provincia {
    private String nombre;
    private List<Concello> concellos;

    public Provincia(List<Concello> concellos, String nombre) {
        this.concellos = concellos;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                ", concellos=" + concellos +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Concello> getConcellos() {
        return concellos;
    }

    public void setConcellos(List<Concello> concellos) {
        this.concellos = concellos;
    }
}
