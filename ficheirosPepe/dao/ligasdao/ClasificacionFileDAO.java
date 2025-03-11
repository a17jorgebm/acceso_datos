package com.pepinho.ad.e05baloncesto.basketdao;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ClasificacionFileDAO implements Dao<Clasificacion, String> {

    public static final String RUTA = "E:\\data\\";

    private static ClasificacionFileDAO instance;

    private final String ruta;

    // Thread save singleton y doble comprobación de nulidad
    public static ClasificacionFileDAO getInstance(String directorio) {
        if (instance == null) {
            synchronized (ClasificacionFileDAO.class) {
                if (instance == null) {
                    instance = new ClasificacionFileDAO(directorio);
                }
            }
        }
        return instance;
    }

    public static ClasificacionFileDAO getInstance() {
        return getInstance(RUTA);
    }


    private ClasificacionFileDAO(String path) {
        this.ruta = path;
    }

    @Override
    public Clasificacion get(String competicion) {
        EquipoFileDAO equipoFileDAO = EquipoFileDAO.getInstance(ruta + competicion + ".dat");
        Clasificacion clasificacion = new Clasificacion(competicion);
        List<Equipo> equipos = equipoFileDAO.getAll();
        equipos.forEach(clasificacion::addEquipo);
        return clasificacion;
    }

    @Override
    public List<Clasificacion> getAll() {
        try(Stream<Path> files = Files.list(Path.of(ruta))){
            List<String> competiciones =  files.filter(Files::isRegularFile)// Solo ficheros
                    .map(Path::getFileName)// Solo el nombre del fichero
                    .map(Path::toString) // Lo convierte a String
                    .map(s -> s.substring(0, s.lastIndexOf('.'))) // Quita la extensión
                    .toList(); // Lo convierte a una lista
            return competiciones.stream()
                    .map(this::get) // Obtiene la clasificación de cada competición
                    .toList();
        } catch (IOException e) {
            System.out.println("Error al leer los ficheros de clasificación");
        }
        return List.of();
    }

    @Override
    public boolean save(Clasificacion obxecto) {
        EquipoFileDAO equipoFileDAO = EquipoFileDAO.getInstance(ruta + obxecto.getCompeticion() + ".dat");
        obxecto.getEquipos().forEach(equipoFileDAO::save);
        return true;
    }

    @Override
    public boolean delete(Clasificacion obx) {
        EquipoFileDAO equipoFileDAO = EquipoFileDAO.getInstance(ruta + obx.getCompeticion() + ".dat");
        obx.getEquipos().forEach(equipoFileDAO::delete);
        return true;
    }

    @Override
    public boolean deleteAll() {
        try {
            Files.list(Path.of(ruta)).forEach(p -> {
                try {
                    Files.delete(p);
                } catch (IOException e) {
                    System.out.println("Error al borrar el fichero " + p);
                }
            });
            return true;
        } catch (IOException e) {
            System.out.println("Error al leer los ficheros de clasificación");
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        EquipoFileDAO equipoFileDAO = EquipoFileDAO.getInstance(ruta + id + ".dat");
        equipoFileDAO.deleteAll();
        return false;
    }

    @Override
    public void update(Clasificacion obx) {
        EquipoFileDAO equipoFileDAO = EquipoFileDAO.getInstance(ruta + obx.getCompeticion() + ".dat");
        obx.getEquipos().forEach(equipoFileDAO::update);
    }
}
