package org.example.boletin.gestionBaloncesto.daos;

import java.io.IOException;
import java.util.Set;

public interface DaoGenerico<T,K> {
    T get(K id) throws IOException, ClassNotFoundException;
    Set<T> getAll() throws IOException, ClassNotFoundException;
    boolean save(T obj) throws IOException, ClassNotFoundException;
    boolean delete(T obj) throws IOException, ClassNotFoundException, ClassCastException;
    boolean deleteAll() throws IOException;
    boolean update(T obj, T objActualizado) throws ClassNotFoundException, IOException, ClassCastException;
}
