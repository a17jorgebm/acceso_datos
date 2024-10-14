package org.example.boletin.gestionBaloncesto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipo implements Serializable, Comparable<Equipo>{
    public static final String FICHEIRO_EQUIPO="equipos.dat";

    private String nombre;
    private transient Set<Clasificacion> clasificacions;
    private transient Set<Partido> partidos;
    private transient int victorias;
    private transient int derrotas;
    private transient int puntosFavor;
    private transient int puntosContra;

    public Equipo(String nombre){
        this.nombre=nombre;
    }

    public Equipo(String nombre,Set<Clasificacion> clasificacions,HashSet<Partido> partidos) {
        this.nombre = nombre;
        this.clasificacions=clasificacions;
        calcularPuntosPartidos(partidos);
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
        int victorias=0, derrotas=0, puntosFavor=0, puntosContra=0;
        for (Partido partido : partidosEquipo){
            if (partido.getMarcador().size()<2) continue;
            int pFavorPartido=0;
            int pContraPartido=0;
            Set<String> clavesMarcador=partido.getMarcador().keySet();
            for (String clave: clavesMarcador){
                if (clave.equals(this.nombre)){
                    pFavorPartido=partido.getMarcador().get(clave);
                }else {
                    pContraPartido=partido.getMarcador().get(clave);
                }
            }
            if (pFavorPartido>pContraPartido) victorias++;
            if (pFavorPartido<pContraPartido) derrotas++;
            puntosFavor+=pFavorPartido;
            puntosContra+=pContraPartido;
        }
        this.victorias=victorias;
        this.derrotas=derrotas;
        this.puntosFavor=puntosFavor;
        this.puntosContra=puntosContra;
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
    public int getDiferenciaPuntos(){
        return puntosFavor-puntosContra;
    }
}
