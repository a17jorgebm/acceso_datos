package org.example.ImpDaoPartido;

import org.example.daos.DaoPartido;

public class ImpDaoPartidoFile implements DaoPartido {
    @Override
    public String imprimir() {
        return "desde ficheiro";
    }

    @Override
    public String get(String variable) {
        return variable;
    }
}
