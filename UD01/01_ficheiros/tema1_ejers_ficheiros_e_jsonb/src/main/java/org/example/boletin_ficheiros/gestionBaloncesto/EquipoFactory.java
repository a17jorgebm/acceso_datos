package org.example.boletin_ficheiros.gestionBaloncesto;

import org.example.boletin_ficheiros.gestionBaloncesto.dao_implementations.ImpDaoPartido;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class EquipoFactory {
    public static Equipo createEquipoFromClasificacions(String nombre, Set<Clasificacion> c) throws IOException,ClassNotFoundException {
        ImpDaoPartido daoPartido=new ImpDaoPartido();
        HashSet<Partido> partidosEquipoEnClasificacion= daoPartido.getAllPartidosFromEquipoInClasificacion(new Equipo(nombre),c);
        return new Equipo(nombre,c, partidosEquipoEnClasificacion);
    }
}
