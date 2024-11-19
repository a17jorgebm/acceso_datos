package org.example.boletin.gestionBaloncesto.daos;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.Equipo_clasificacion;

import java.io.IOException;
import java.util.Set;

public interface DaoEquipoClasificacion extends DaoGenerico<Equipo_clasificacion,Equipo_clasificacion>{
    Set<Equipo> getAllEquiposFromClasificacion(Clasificacion clasificacion) throws ClassNotFoundException, IOException, ClassCastException;
    Set<Clasificacion> getAllClasificacionesFromEquipo(Equipo equipo) throws ClassNotFoundException, IOException, ClassCastException;
    boolean deleteAllEquiposFromClasificacion(Clasificacion clasificacion) throws ClassNotFoundException, IOException, ClassCastException;
    boolean deleteAllClasificacionesFromEquipo(Equipo equipo) throws ClassNotFoundException, IOException, ClassCastException;
}