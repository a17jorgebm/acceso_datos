package org.example.boletin.gestionBaloncesto.daos;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.Partido;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public interface DaoPartido extends DaoGenerico<Partido,Partido>{
    HashSet<Partido> getAllPartidosFromEquipo(Equipo equipo) throws IOException, ClassNotFoundException, ClassCastException;
    HashSet<Partido> getAllPartidosFromClasificacion(Clasificacion clasificacion) throws IOException, ClassNotFoundException, ClassCastException;
    HashSet<Partido> getAllPartidosFromEquipoInClasificacion(Equipo equipo, Set<Clasificacion> clasificacions) throws IOException, ClassNotFoundException, ClassCastException;
    boolean deleteAllPartidosFromEquipo(Equipo equipo) throws IOException, ClassNotFoundException, ClassCastException;
    boolean deleteAllPartidosFromClasificacion(Clasificacion clasificacion) throws IOException, ClassNotFoundException, ClassCastException;
}
