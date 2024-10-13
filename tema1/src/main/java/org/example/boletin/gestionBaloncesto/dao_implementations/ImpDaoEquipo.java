package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.Equipo;
import org.example.boletin.gestionBaloncesto.Funcions;
import org.example.boletin.gestionBaloncesto.daos.DaoGenerico;

import java.io.IOException;
import java.util.Set;

public class ImpDaoEquipo implements DaoGenerico<Equipo,String> {
    public static final String FICHEIRO_EQUIPOS="equipos.ser";

    @Override
    public Equipo get(String id) throws IOException, ClassNotFoundException{
        return Funcions.getObxetoFicheiroById(FICHEIRO_EQUIPOS,new Equipo(id));
    }

    @Override
    public Set<Equipo> getAll() throws IOException, ClassNotFoundException{
        return Funcions.lerFicheiroObxetos(FICHEIRO_EQUIPOS,Equipo.class);
    }

    @Override
    public boolean save(Equipo obj) throws IOException, ClassNotFoundException {
        return Funcions.engadirObxetoFicheiro(FICHEIRO_EQUIPOS,obj);
    }

    @Override
    public boolean delete(Equipo obj) throws IOException, ClassNotFoundException, ClassCastException {
        return Funcions.borrarObxetoArquivo(FICHEIRO_EQUIPOS,obj);
    }

    @Override
    public boolean deleteAll() throws IOException {
        return Funcions.borrarTodosObxetosArquivo(FICHEIRO_EQUIPOS);
    }

    @Override
    public boolean update(Equipo obj, Equipo objActualizado) throws ClassNotFoundException, IOException, ClassCastException {
        return Funcions.actualizarObxetoArquivo(FICHEIRO_EQUIPOS,obj,objActualizado);
    }
}
