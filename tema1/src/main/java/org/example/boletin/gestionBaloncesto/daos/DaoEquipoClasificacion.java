package org.example.boletin.gestionBaloncesto.daos;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.Equipo_clasificacion;

import java.util.HashSet;

public interface DaoEquipoClasificacion extends DaoGenerico<Equipo_clasificacion,Equipo_clasificacion>{
    HashSet<Equipo> getAllEquiposFromClasificacion(Clasificacion clasificacion);
    HashSet<Clasificacion> getAllClasificacionesFromEquipo(Equipo equipo);
    boolean deleteAllEquiposFromClasificacion(Clasificacion clasificacion);
    boolean deleteAllClasificacionesFromEquipo(Equipo equipo);
}