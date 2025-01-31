package org.example.ejer06_01_EquipoEntrenador.Daos;

import java.util.List;
import java.util.Optional;

public interface Dao <T, K>{
    Optional<T> getById(K id);
    List<T> getAll();

    public T save(T o);
    public boolean update(T o);
    public boolean delete(T o);
    public boolean deleteById(K id);
}
