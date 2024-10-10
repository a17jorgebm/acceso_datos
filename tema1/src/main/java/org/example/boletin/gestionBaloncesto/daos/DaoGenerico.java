package org.example.boletin.gestionBaloncesto.daos;

import java.io.IOException;
import java.util.Set;

public interface DaoGenerico<T,K> {
    T get(K id) throws IOException, ClassNotFoundException;
    Set<T> getAll() throws IOException, ClassNotFoundException;
    boolean save(T obj) throws IOException;
    boolean delete(T obj);
    boolean deleteAll();
    boolean deleteById(K id);
    boolean update(T obj);
}
