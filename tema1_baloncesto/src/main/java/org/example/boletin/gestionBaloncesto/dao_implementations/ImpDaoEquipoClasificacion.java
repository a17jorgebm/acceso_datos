package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.*;
import org.example.boletin.gestionBaloncesto.daos.DaoEquipoClasificacion;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ImpDaoEquipoClasificacion implements DaoEquipoClasificacion{
    public static final String FICHEIRO_EQUIPOS_CLASIFICACION="equipos_clasificacion.ser";

    @Override
    public TreeSet<Equipo> getAllEquiposFromClasificacion(Clasificacion clasificacion) throws ClassNotFoundException, IOException, ClassCastException{
        Set<Equipo_clasificacion> eq_clas = new HashSet<>(this.getAll())
                .stream()
                .filter(ec -> ec.getIdClasificacion().equals(clasificacion.getCompeticion()))
                .collect(Collectors.toSet());
        TreeSet<Equipo> equipos=new TreeSet<>();
        for (Equipo_clasificacion ec : eq_clas){
            equipos.add(EquipoFactory.createEquipoFromClasificacions(ec.getIdEquipo(),Set.of(clasificacion)));
        }
        return equipos;
    }

    @Override
    public TreeSet<Clasificacion> getAllClasificacionesFromEquipo(Equipo equipo) throws ClassNotFoundException, IOException, ClassCastException{
        TreeSet<Equipo_clasificacion> eq_clas = (TreeSet<Equipo_clasificacion>) this.getAll()
                .stream()
                .filter(ec -> ec.getIdEquipo().equals(equipo.getNombre()))
                .collect(Collectors.toSet());
        TreeSet<Clasificacion> clasificacions=new TreeSet<>();
        ImpDaoClasificacion daoCla=new ImpDaoClasificacion();
        for (Equipo_clasificacion ec : eq_clas){
            clasificacions.add(daoCla.get(ec.getIdClasificacion()));
        }
        return clasificacions;
    }

    @Override
    public boolean deleteAllEquiposFromClasificacion(Clasificacion clasificacion) throws ClassNotFoundException, IOException, ClassCastException{
        HashSet<Equipo_clasificacion> equipos_clasi=(HashSet<Equipo_clasificacion>) this.getAll();
        if (clasificacion==null) return false;
        return true;


    }

    @Override
    public boolean deleteAllClasificacionesFromEquipo(Equipo equipo) throws ClassNotFoundException, IOException, ClassCastException{
        return false;
    }

    @Override
    public Equipo_clasificacion get(Equipo_clasificacion id) throws IOException, ClassNotFoundException, ClassCastException{
        return Funcions.getObxetoFicheiroById(FICHEIRO_EQUIPOS_CLASIFICACION,id);
    }

    @Override
    public Set<Equipo_clasificacion> getAll() throws IOException, ClassNotFoundException, ClassCastException{
        return Funcions.lerFicheiroObxetos(FICHEIRO_EQUIPOS_CLASIFICACION, Equipo_clasificacion.class);
    }

    @Override
    public boolean save(Equipo_clasificacion obj) throws IOException, ClassNotFoundException {
        return Funcions.engadirObxetoFicheiro(FICHEIRO_EQUIPOS_CLASIFICACION,obj);
    }

    @Override
    public boolean delete(Equipo_clasificacion obj) throws IOException, ClassNotFoundException, ClassCastException {
        return Funcions.borrarObxetoArquivo(FICHEIRO_EQUIPOS_CLASIFICACION,obj);
    }

    @Override
    public boolean deleteAll() throws IOException {
        return Funcions.borrarTodosObxetosArquivo(FICHEIRO_EQUIPOS_CLASIFICACION);
    }

    @Override
    public boolean update(Equipo_clasificacion obj, Equipo_clasificacion objActualizado) throws ClassNotFoundException, IOException, ClassCastException {
        return Funcions.actualizarObxetoArquivo(FICHEIRO_EQUIPOS_CLASIFICACION,obj,objActualizado);
    }
}
