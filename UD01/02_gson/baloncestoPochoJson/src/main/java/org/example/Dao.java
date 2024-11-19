package org.example;

import java.util.List;

public interface Dao <T, K>{
    T get(K id);
    List<T> getAll();
    boolean save(T obxecto);
    boolean delete(T obx);
    boolean deleteAll();
    boolean deleteById(K id);
    void update(T obx);
}
