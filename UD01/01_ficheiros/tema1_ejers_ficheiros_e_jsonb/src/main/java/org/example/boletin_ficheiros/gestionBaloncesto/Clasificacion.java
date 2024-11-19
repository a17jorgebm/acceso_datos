package org.example.boletin_ficheiros.gestionBaloncesto;

import java.io.Serializable;
import java.util.Objects;

public class Clasificacion implements Serializable, Comparable<Clasificacion> {
    private String competicion;

    public Clasificacion(String competicion) {
        this.competicion = competicion;
    }

    @Override
    public String toString(){
        return this.competicion;
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {return true;}
        if (o==null || !(o instanceof Clasificacion)){return false;}
        Clasificacion objeto=(Clasificacion) o;
        return Objects.equals(this.competicion,objeto.getCompeticion());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.competicion);
    }

    @Override
    public int compareTo(Clasificacion o) {
        return this.competicion.compareToIgnoreCase(o.getCompeticion());
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }
}
