package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.daos.DaoGenerico;

import java.util.List;

public class ImpDaoClasificacion implements DaoGenerico<Clasificacion,String> {
    @Override
    public Clasificacion get(String id) {
        return null;
    }

    @Override
    public List<Clasificacion> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Clasificacion obj) {
        return false;
    }

    @Override
    public boolean delete(Clasificacion obj) {
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
    public boolean update(Clasificacion obj) {
        return false;
    }
}
