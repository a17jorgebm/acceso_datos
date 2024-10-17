package org.example.ImpDaoPartido;

import org.example.daos.DaoPartido;

public class FactoryImpDaoPartido {
    public static DaoPartido getImpDaoPartido(String tipo){
        if (tipo.equals("file")){
            return new ImpDaoPartidoFile();
        }
        if (tipo.equals("json")){
            return new ImpDaoPartidoJson();
        }
        return null;
    }
}
