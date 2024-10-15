package org.example;

import java.util.Objects;

public class Equipo implements Comparable<Equipo>{
    private String nombre;
    private int victorias;
    private int derrotas;
    private int puntosFavor;
    private int puntosContra;

    public Equipo(int victorias, String nombre, int derrotas, int puntosFavor, int puntosContra) {
        this.victorias = victorias;
        this.nombre = nombre;
        this.derrotas = derrotas;
        this.puntosFavor = puntosFavor;
        this.puntosContra = puntosContra;
    }

    @Override
    public String toString(){
        StringBuilder texto=new StringBuilder();
        texto.append("-----");
        texto.append("\n").append("Equipo: ").append(nombre);
        texto.append("\n").append("Victorias: ").append(victorias);
        texto.append("\n").append("Derrotas: ").append(derrotas);
        texto.append("\n").append("Puntos a favor: ").append(puntosFavor);
        texto.append("\n").append("Puntos en contra: ").append(puntosContra);
        texto.append("\n").append("Puntos: ").append(puntos());
        texto.append("\n").append("Partidos jugados: ").append(getPartidosJugados());
        texto.append("\n").append("Diferencia de puntos: ").append(getDiferenciaPuntos());
        texto.append("\n").append("-----");
        return texto.toString();
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

    public int puntos(){
        return victorias;
    }

    public int getPartidosJugados(){
        return victorias+derrotas;
    }

    public int getDiferenciaPuntos(){
        return puntosFavor-puntosContra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPuntosFavor() {
        return puntosFavor;
    }

    public void setPuntosFavor(int puntosFavor) {
        this.puntosFavor = puntosFavor;
    }

    public int getPuntosContra() {
        return puntosContra;
    }

    public void setPuntosContra(int puntosContra) {
        this.puntosContra = puntosContra;
    }
}
