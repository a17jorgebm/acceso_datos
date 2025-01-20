package org.example.boletin_ficheiros.gestionBaloncesto.dao_implementations;

import org.example.boletin_ficheiros.gestionBaloncesto.Clasificacion;
import org.example.boletin_ficheiros.gestionBaloncesto.Equipo;
import org.example.boletin_ficheiros.gestionBaloncesto.Funcions;
import org.example.boletin_ficheiros.gestionBaloncesto.Partido;
import org.example.boletin_ficheiros.gestionBaloncesto.daos.DaoPartido;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ImpDaoPartido implements DaoPartido {
    public static final String FICHEIRO_PARTIDOS="partidos.ser";

    @Override
    public HashSet<Partido> getAllPartidosFromEquipo(Equipo equipo) throws IOException, ClassNotFoundException, ClassCastException {
        return (HashSet<Partido>) this.getAll()
                .stream()
                .filter(p -> (p.getEquipoLocal().equals(equipo) || p.getEquipoVisitante().equals(equipo)))
                .collect(Collectors.toSet());
    }

    @Override
    public HashSet<Partido> getAllPartidosFromClasificacion(Clasificacion clasificacion) throws IOException, ClassNotFoundException, ClassCastException{
        return (HashSet<Partido>) this.getAll()
                .stream()
                .filter(p -> p.getClasificacion().equals(clasificacion))
                .collect(Collectors.toSet());
    }

    @Override
    public HashSet<Partido> getAllPartidosFromEquipoInClasificacion(Equipo equipo, Set<Clasificacion> clasificacion) throws IOException, ClassNotFoundException, ClassCastException{
        return (HashSet<Partido>) this.getAll()
                .stream()
                .filter(p -> clasificacion.contains(p.getClasificacion()) &&
                        (p.getEquipoLocal().equals(equipo) || p.getEquipoVisitante().equals(equipo)))
                .collect(Collectors.toSet());
    }

    @Override
    public boolean deleteAllPartidosFromEquipo(Equipo equipo) throws IOException, ClassNotFoundException, ClassCastException{
        return false;
    }

    @Override
    public boolean deleteAllPartidosFromClasificacion(Clasificacion clasificacion) throws IOException, ClassNotFoundException, ClassCastException {
        return false;
    }

    @Override
    public Partido get(Partido id) throws IOException, ClassNotFoundException, ClassCastException{
        return Funcions.getObxetoFicheiroById(FICHEIRO_PARTIDOS,id);
    }

    @Override
    public Set<Partido> getAll() throws IOException, ClassNotFoundException{
        return Funcions.lerFicheiroObxetos(FICHEIRO_PARTIDOS,Partido.class);
    }


    @Override
    public boolean save(Partido obj) throws IOException, ClassNotFoundException {
        return Funcions.engadirObxetoFicheiro(FICHEIRO_PARTIDOS,obj);
    }

    @Override
    public boolean delete(Partido obj) throws IOException, ClassNotFoundException, ClassCastException {
        return Funcions.borrarObxetoArquivo(FICHEIRO_PARTIDOS,obj);
    }

    @Override
    public boolean deleteAll() throws IOException {
        return Funcions.borrarTodosObxetosArquivo(FICHEIRO_PARTIDOS);
    }

    @Override
    public boolean update(Partido obj, Partido objActualizado) throws ClassNotFoundException, IOException, ClassCastException {
        return Funcions.actualizarObxetoArquivo(FICHEIRO_PARTIDOS,obj,objActualizado);
    }
}
