/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.ad.e05baloncesto.basketdao;

import java.io.*;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pepecalo
 */
public class Clasificacion implements Serializable {

    public static final String CABECERA = """
                                          *******************************************************
                                          EQUIPO               PJ  VI  DE   FAVOR  CONTRA  DIFER
                                          *******************************************************
                                          """;

    public static final String DEFAULT_COMPETITION = "Liga ACB";

    @Serial
    private final static long serialVersionUID = 1L;

    private final Set<Equipo> equipos;
    private final String competicion;


    public Clasificacion(String competicion) {
        equipos = new TreeSet<>();
        this.competicion = competicion;
    }

    public Clasificacion() {
        equipos = new TreeSet<>();
        competicion = DEFAULT_COMPETITION;
    }

    public boolean addEquipo(Equipo e) {
        return equipos.add(e);
    }

    public boolean addEquipos(Set<Equipo> equipos) {
        return this.equipos.addAll(equipos);
    }

    public boolean removeEquipo(Equipo e) {
        return equipos.remove(e);
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public String getCompeticion() {
        return competicion;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || ((o instanceof Clasificacion that) && Objects.equals(competicion, that.competicion));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(competicion);
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder(CABECERA);

        // Con programación funcional
        equipos.forEach(e -> {
            cadena.append(e).append(System.lineSeparator());
        });

//        for (Equipo e : equipos) {
//            cadena.append(e).append(System.lineSeparator());
//        }

        cadena.append(CABECERA);
        return cadena.toString();
    }

}
