package com.pepinho.ad.e05baloncesto.dao;

import java.util.List;

/**
 * Dao genérico.
 * Esta clase define los métodos que deben implementar las clases que quieran
 * ser un Dao.
 * La T es el tipo de objeto que se va a manejar y la K es el tipo de clave
 * primaria.
 * @param <T>
 * @param <K>
 */
public interface Dao <T, K> {

    T get(K id);
    List<T> getAll();
    void save(T obxecto);
    void delete(T obx);
    void update(T obx);

}
