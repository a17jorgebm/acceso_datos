package org.example.boletin.gestionBaloncesto;

import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoPartido;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//fagoo de esta maneira para non mezclar a logica de lectura de archivos coa clase Equipo
public class EquipoFactory {
    public static Equipo createEquipoFromClasificacions(String nombre, Set<Clasificacion> c) throws IOException,ClassNotFoundException {
        ImpDaoPartido daoPartido=new ImpDaoPartido();
        HashSet<Partido> partidosEquipoEnClasificacion= daoPartido.getAllPartidosFromEquipoInClasificacion(new Equipo(nombre),c);
        return new Equipo(nombre,c, partidosEquipoEnClasificacion);
    }
}
