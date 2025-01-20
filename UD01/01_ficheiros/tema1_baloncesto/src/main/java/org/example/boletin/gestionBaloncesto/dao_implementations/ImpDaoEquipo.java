package org.example.boletin.gestionBaloncesto.dao_implementations;

import org.example.boletin.gestionBaloncesto.*;
import org.example.boletin.gestionBaloncesto.daos.DaoGenerico;

import java.io.IOException;
import java.util.HashSet;
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
        Equipo equipo=obj;
        ImpDaoPartido daoPartido=new ImpDaoPartido();
        ImpDaoEquipoClasificacion daoEquipoClasificacion=new ImpDaoEquipoClasificacion();
        HashSet<Partido> partidosEquipo=null;
        HashSet<Clasificacion> equipos_clasificacion=null;
        try{
            //borranse os partidos do equipo, xa que non tería consistencia de datos
            partidosEquipo=new HashSet<>(daoPartido.getAllPartidosFromEquipo(equipo));
            for (Partido p: partidosEquipo) { daoPartido.delete(p); }
            //e borranse todas as entradas en equipo_clasificacion que tivera que ver co equipo
            equipos_clasificacion=new HashSet<>(daoEquipoClasificacion.getAllClasificacionesFromEquipo(equipo));
            for (Clasificacion c: equipos_clasificacion) { daoEquipoClasificacion.delete(new Equipo_clasificacion(equipo.getNombre(),c.getCompeticion())); }
            //borrase o equipo
            Funcions.borrarObxetoArquivo(FICHEIRO_EQUIPOS,obj);
        }catch (IOException | ClassNotFoundException | ClassCastException e){
            throw e;
        }finally { //reseteo todo o borrado, efectivamente finally lanzase igual ainda que fagas un return ou throw dentro do catch
            try{
                if (partidosEquipo!=null) for (Partido p: partidosEquipo) { daoPartido.save(p); }
                if (equipos_clasificacion!=null) for (Clasificacion c: equipos_clasificacion) { daoEquipoClasificacion.save(new Equipo_clasificacion(equipo.getNombre(),c.getCompeticion())); }
                this.save(equipo);
            }catch (Exception e){
                //eso si, o bloque finally non debería lanzar excepcions, xa que sobreescribe as do try catch anterior e perdense
            }
        }
        return true;
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
