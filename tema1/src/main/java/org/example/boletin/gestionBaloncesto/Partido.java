package org.example.boletin.gestionBaloncesto;

import java.util.Date;

public class Partido {
    private Date fecha;
    private Clasificacion clasificacion;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
}
