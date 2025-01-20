package org.example.boletin_ficheiros.gestionBaloncestoNormal;

import java.util.List;

public interface DaoGenerico <T,K>{
    T get(K id);
    List<T> getAll();

}
