package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClasificacionJsonDao implements Dao<Clasificacion, String>{
    public static final Path DEFAULT_PATH= Paths.get("database");

    private Path ruta;

    public ClasificacionJsonDao() {
        this.ruta=DEFAULT_PATH;
    }

    public ClasificacionJsonDao(Path ruta) {
        this.ruta = ruta;
    }

    @Override
    public Clasificacion get(String id) {
        return null;
    }

    @Override
    public List<Clasificacion> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Clasificacion obxecto) {
        return false;
    }

    @Override
    public boolean delete(Clasificacion obx) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public void update(Clasificacion obx) {

    }
}
