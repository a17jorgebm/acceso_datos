package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.Clasificacion;
import org.example.boletin.gestionBaloncesto.Funcions;
import org.example.boletin.gestionBaloncesto.daos.DaoGenerico;

import java.io.IOException;
import java.util.Set;

public class ImpDaoClasificacion implements DaoGenerico<Clasificacion,String> {
    private static final String FICHEIRO_CLASIFICACIONS="clasificacions.dao";

    @Override
    public Clasificacion get(String id) throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public Set<Clasificacion> getAll() throws IOException, ClassNotFoundException {
        Set<Clasificacion> clasificacions=Funcions.lerFicheiroObxetos(FICHEIRO_CLASIFICACIONS,Clasificacion.class);
        return clasificacions;
    }

    @Override
    public boolean save(Clasificacion obj) throws IOException {
        return Funcions.engadirObxetoFicheiro(FICHEIRO_CLASIFICACIONS,obj);
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
