/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.ad.biblioteca.model;

import java.util.List;

/**
 *
 * @author pepecalo
 * @param <T> Tipo de dato del objeto
 */
public interface DAO<T> {

    T get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);
   
    void delete(T t);

    public boolean deleteById(long id);

    public List<Long> getAllIds();

    public void updateLOB(T book, String f);

    public void updateLOBById(long id, String f);
    
    void deleteAll();
}