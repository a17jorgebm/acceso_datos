package org.example.daos;

import java.io.IOException;
import java.util.Set;

public interface DaoGenerico<T,K> {
    T get(K variable);
}
