package org.example.boletin.gestionBaloncesto;

import org.example.boletin.gestionBaloncesto.dao_implementations.ImpDaoClasificacion;

import java.util.Set;

/*
- vou ter 5 arquivos:
    * equipos.dat
    * clasificacions.dat
    * partidos.dat
    * equipo_clasificacion.dat
    * equipo_partido.dat
 */
public class Main {
    public static void main(String[] args) {
        Clasificacion c=new Clasificacion("ACB");
        ImpDaoClasificacion daoClasificacion=new ImpDaoClasificacion();
        try {
            Set<Clasificacion> clasificacions=daoClasificacion.getAll();
            clasificacions.forEach(clasi -> System.out.println(clasi));
            if (clasificacions.contains(c)){
                //throw new Exception("Xa conten o obxeto");
            }
            if(daoClasificacion.save(c)){
                System.out.println("Gardado");
            }else{
                System.out.println("Erro ao gardar");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
