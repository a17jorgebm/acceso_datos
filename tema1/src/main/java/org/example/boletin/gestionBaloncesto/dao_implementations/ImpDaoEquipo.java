package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.daos.DaoGenerico;

import java.util.List;

public class ImpDaoEquipo implements DaoGenerico<Equipo,String> {
    @Override
    public Equipo get(String id) {
        return null;
    }

    @Override
    public List<Equipo> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Equipo obj) {
        return false;
    }

    @Override
    public boolean delete(Equipo obj) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public boolean update(Equipo obj) {
        return false;
    }
}
