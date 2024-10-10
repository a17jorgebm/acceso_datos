package org.example.boletin.gestionBaloncesto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipo implements Serializable, Comparable<Equipo>{
    private String nombre;
    private Set<Clasificacion> clasificacions;
    private int victorias;
    private int derrotas;
    private int puntosFavor;
    private int puntosContra;

    public Equipo(String nombre,Set<Clasificacion> clasificacions) {
        this.nombre = nombre;
        this.clasificacions=clasificacions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public int compareTo(Equipo o) {
        int diferenciaThis=this.puntosFavor-this.puntosContra;
        int difereniaOtro=o.getPuntosFavor()-o.getPuntosContra();
        if (o.getVictorias()<this.getVictorias() || difereniaOtro<diferenciaThis){
            return 1;
        }else if (o.getVictorias()>this.getVictorias() || difereniaOtro>diferenciaThis){
            return -1;
        }
        return 0;
    }

    private void calcularPuntosPartidos(HashSet<Partido> partidosEquipo){
        //a partir dos partidos calcular todo
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Clasificacion> getClasificacions() {
        return clasificacions;
    }

    public void setClasificacions(Set<Clasificacion> clasificacions) {
        this.clasificacions = clasificacions;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPuntosFavor() {
        return puntosFavor;
    }

    public int getPuntosContra() {
        return puntosContra;
    }
}
