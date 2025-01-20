package org.example.boletin_ficheiros.gestionBaloncesto;

import java.io.Serializable;

public class Equipo_clasificacion implements Serializable {
    private String idEquipo;
    private String idClasificacion;

    public Equipo_clasificacion(String idEquipo, String idClasificacion) {
        this.idEquipo = idEquipo;
        this.idClasificacion = idClasificacion;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(String idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
}
