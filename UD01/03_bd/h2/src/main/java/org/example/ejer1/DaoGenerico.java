package org.example.ejer1;

import java.util.List;

public interface DaoGenerico<T>{
    T get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
    boolean deleteById(long id);
    List<Integer> getAllIds();
    void updateLOB(T book, String f);
    void updateLOBById(long id, String f);
    void deleteAll();
}
