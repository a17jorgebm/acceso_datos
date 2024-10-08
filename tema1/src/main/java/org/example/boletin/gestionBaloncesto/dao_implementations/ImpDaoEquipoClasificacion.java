package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.daos.DaoEquipoClasificacion;
import org.example.boletin.gestionBaloncesto.Equipo_clasificacion;

import java.util.HashSet;
import java.util.List;

class ImpDaoEquipoClasificacion implements DaoEquipoClasificacion{
    @Override
    public HashSet<Equipo> getAllEquiposFromClasificacion(Clasificacion clasificacion) {
        return null;
    }

    @Override
    public HashSet<Clasificacion> getAllClasificacionesFromEquipo(Equipo equipo) {
        return null;
    }

    @Override
    public boolean deleteAllEquiposFromClasificacion(Clasificacion clasificacion) {
        return false;
    }

    @Override
    public boolean deleteAllClasificacionesFromEquipo(Equipo equipo) {
        return false;
    }

    @Override
    public Equipo_clasificacion get(Equipo_clasificacion id) {
        return null;
    }

    @Override
    public List<Equipo_clasificacion> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Equipo_clasificacion obj) {
        return false;
    }

    @Override
    public boolean delete(Equipo_clasificacion obj) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(Equipo_clasificacion id) {
        return false;
    }

    @Override
    public boolean update(Equipo_clasificacion obj) {
        return false;
    }
}
