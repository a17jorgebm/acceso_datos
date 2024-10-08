package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.Partido;
import org.example.boletin.gestionBaloncesto.daos.DaoPartido;

import java.util.HashSet;
import java.util.List;

public class ImpDaoPartido implements DaoPartido {
    @Override
    public HashSet<Partido> getAllPartidosFromEquipo(Equipo equipo) {
        return null;
    }

    @Override
    public HashSet<Partido> getAllPartidosFromClasificacion(Clasificacion clasificacion) {
        return null;
    }

    @Override
    public boolean deleteAllPartidosFromEquipo(Equipo equipo) {
        return false;
    }

    @Override
    public boolean deleteAllPartidosFromClasificacion(Clasificacion clasificacion) {
        return false;
    }

    @Override
    public Partido get(Partido id) {
        return null;
    }

    @Override
    public List<Partido> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Partido obj) {
        return false;
    }

    @Override
    public boolean delete(Partido obj) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(Partido id) {
        return false;
    }

    @Override
    public boolean update(Partido obj) {
        return false;
    }
}
