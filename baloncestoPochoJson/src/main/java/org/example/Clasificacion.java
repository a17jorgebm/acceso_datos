package org.example;

import java.util.Set;

public class Clasificacion {
    private String competicion;
    private Set<Equipo> equipos;

    public Clasificacion(String competicion, Set<Equipo> equipos) {
        this.competicion = competicion;
        this.equipos = equipos;
    }

    @Override
    public String toString(){
        StringBuilder texto=new StringBuilder();
        texto.append(getHeader());
        equipos.forEach(e -> texto.append("\n").append(e));
        texto.append("\n").append(getFooter(getHeader()));
        return texto.toString();
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
    }

    private String getHeader(){
        StringBuilder texto=new StringBuilder();
        texto.append("###################### CLASIFICACION ").append(competicion).append(" ######################");
        return texto.toString();
    }

    private String getFooter(String header){
        StringBuilder texto=new StringBuilder();
        for (int i=0;i<header.length();i++){
            texto.append("#");
        }
        return texto.toString();
    }
}
