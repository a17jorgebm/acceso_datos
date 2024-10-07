package org.example.boletin.gestionBaloncesto.daos;

import java.util.List;

public interface DaoGenerico<T,K> {
    T get(K id);
    List<T> getAll();
    boolean save(T obj);
    boolean delete(T obj);
    boolean deleteAll();
    boolean deleteById(K id);
    boolean update(T obj);
}
