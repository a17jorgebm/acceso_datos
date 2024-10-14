package org.example.boletin.gestionBaloncesto.daos;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.Equipo_clasificacion;

import java.io.IOException;
import java.util.TreeSet;

public interface DaoEquipoClasificacion extends DaoGenerico<Equipo_clasificacion,Equipo_clasificacion>{
    TreeSet<Equipo> getAllEquiposFromClasificacion(Clasificacion clasificacion) throws ClassNotFoundException, IOException, ClassCastException;
    TreeSet<Clasificacion> getAllClasificacionesFromEquipo(Equipo equipo) throws ClassNotFoundException, IOException, ClassCastException;
    boolean deleteAllEquiposFromClasificacion(Clasificacion clasificacion) throws ClassNotFoundException, IOException, ClassCastException;
    boolean deleteAllClasificacionesFromEquipo(Equipo equipo) throws ClassNotFoundException, IOException, ClassCastException;
}