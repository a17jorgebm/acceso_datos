package org.example.boletin.gestionBaloncesto;

import java.io.Serializable;
import java.util.Objects;

public class Equipo_clasificacion implements Serializable {
    private String idEquipo;
    private String idClasificacion;

    public Equipo_clasificacion(String idEquipo, String idClasificacion) {
        this.idEquipo = idEquipo;
        this.idClasificacion = idClasificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo_clasificacion that = (Equipo_clasificacion) o;
        return Objects.equals(idEquipo, that.idEquipo) && Objects.equals(idClasificacion, that.idClasificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipo, idClasificacion);
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
