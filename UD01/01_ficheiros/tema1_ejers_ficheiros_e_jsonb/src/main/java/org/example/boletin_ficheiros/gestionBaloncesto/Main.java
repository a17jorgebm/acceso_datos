package org.example.boletin_ficheiros.gestionBaloncesto;

import org.example.boletin_ficheiros.gestionBaloncesto.dao_implementations.ImpDaoClasificacion;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/*
- vou ter 4 arquivos:
    * equipos.dat
    * clasificacions.dat
    * partidos.dat
    * equipo_clasificacion.dat
 */
public class Main {
    public static void main(String[] args) {
        crearClasificacions();
        ImpDaoClasificacion impDaoCla=new ImpDaoClasificacion();
        try{
            System.out.println(impDaoCla.get("bbva"));
            if (impDaoCla.delete(impDaoCla.get("bbva"))){
                System.out.println("Borrado");
            }else {
                System.out.println("Non se borrou nada");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void crearClasificacions(){
        TreeSet<Clasificacion> clasificacionsMeter=new TreeSet<>(Set.of(
                new Clasificacion("ABC"),
                new Clasificacion("bbva")
        ));
        ImpDaoClasificacion daoClasificacion=new ImpDaoClasificacion();
        try {
            Set<Clasificacion> clasificacions = daoClasificacion.getAll();
            System.out.println("As que xa estan: "+clasificacions);
            System.out.println("A meter: "+clasificacionsMeter);


            clasificacionsMeter.forEach(c -> {
                if (clasificacions.contains(c)) {
                    System.out.println("Xa existe " + c);
                } else {
                    try {
                        if (daoClasificacion.save(c)) {
                            System.out.println("Gardado: " + c);
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao gardar: " + c + " . Erro:" + e.getMessage());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
