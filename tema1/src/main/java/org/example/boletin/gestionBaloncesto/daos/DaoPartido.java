package org.example.boletin.gestionBaloncesto.daos;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.Partido;

import java.util.HashSet;

public interface DaoPartido extends DaoGenerico<Partido,Partido>{
    HashSet<Partido> getAllPartidosFromEquipo(Equipo equipo);
    HashSet<Partido> getAllPartidosFromClasificacion(Clasificacion clasificacion);
    boolean deleteAllPartidosFromEquipo(Equipo equipo);
    boolean deleteAllPartidosFromClasificacion(Clasificacion clasificacion);
}
