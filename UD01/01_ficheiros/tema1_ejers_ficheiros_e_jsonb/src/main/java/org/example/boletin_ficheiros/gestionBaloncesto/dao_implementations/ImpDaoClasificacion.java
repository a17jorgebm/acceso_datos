package org.example.boletin_ficheiros.gestionBaloncesto.dao_implementations;

import org.example.boletin_ficheiros.gestionBaloncesto.Clasificacion;
import org.example.boletin_ficheiros.gestionBaloncesto.Funcions;
import org.example.boletin_ficheiros.gestionBaloncesto.daos.DaoGenerico;

import java.io.IOException;
import java.util.Set;

public class ImpDaoClasificacion implements DaoGenerico<Clasificacion,String> {
    private static final String FICHEIRO_CLASIFICACIONS="clasificacions.ser";

    @Override
    public Clasificacion get(String id) throws IOException, ClassNotFoundException {
        return Funcions.getObxetoFicheiroById(FICHEIRO_CLASIFICACIONS,new Clasificacion(id));
    }

    @Override
    public Set<Clasificacion> getAll() throws IOException, ClassNotFoundException {
        Set<Clasificacion> clasificacions=Funcions.lerFicheiroObxetos(FICHEIRO_CLASIFICACIONS,Clasificacion.class);
        return clasificacions;
    }

    @Override
    public boolean save(Clasificacion obj) throws IOException, ClassNotFoundException {
        return Funcions.engadirObxetoFicheiro(FICHEIRO_CLASIFICACIONS,obj);
    }

    @Override
    public boolean delete(Clasificacion obj) throws IOException, ClassNotFoundException, ClassCastException {
        return Funcions.borrarObxetoArquivo(FICHEIRO_CLASIFICACIONS,obj);
    }

    @Override
    public boolean deleteAll() throws IOException {
        return Funcions.borrarTodosObxetosArquivo(FICHEIRO_CLASIFICACIONS);
    }

    @Override
    public boolean update(Clasificacion obj, Clasificacion objActualizado) throws ClassNotFoundException, IOException, ClassCastException {
        return Funcions.actualizarObxetoArquivo(FICHEIRO_CLASIFICACIONS,obj,objActualizado);
    }
}
