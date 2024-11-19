package org.example.ImpDaoPartido;

import org.example.daos.DaoPartido;

public class ImpDaoPartidoJson implements DaoPartido {
    @Override
    public String imprimir() {
        return "desde json";
    }

    @Override
    public String get(String variable) {
        return variable;
    }
}
