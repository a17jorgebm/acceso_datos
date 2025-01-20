package org.example.boletin_ficheiros.gestionBaloncesto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class Partido implements Serializable {
    private Date fecha;
    private String equipoLocal;
    private String equipoVisitante;
    private HashMap<String,Integer> marcador;
    private String clasificacion;

    public Partido(Date fecha, String equipoLocal, String equipoVisitante, String clasificacion, HashMap<String,Integer> marcador) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.clasificacion = clasificacion;
        this.marcador=marcador;
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || !(o instanceof Partido)) return false;
        Partido p2=(Partido) o;
        return Objects.equals(fecha,p2.getFecha())
                && Objects.equals(equipoLocal,p2.getEquipoLocal())
                && Objects.equals(equipoVisitante,p2.getEquipoVisitante())
                && Objects.equals(clasificacion,p2.getClasificacion());
    }

    @Override
    public int hashCode(){
        return Objects.hash(fecha,equipoLocal,equipoVisitante,clasificacion);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public HashMap<String, Integer> getMarcador() {
        return marcador;
    }

    public void setMarcador(HashMap<String, Integer> marcador) {
        this.marcador = marcador;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
