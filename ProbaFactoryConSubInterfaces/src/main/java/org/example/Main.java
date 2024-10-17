package org.example;

import org.example.ImpDaoPartido.FactoryImpDaoPartido;
import org.example.daos.DaoPartido;

public class Main {
    public static void main(String[] args) {
        DaoPartido daoPartido= FactoryImpDaoPartido.getImpDaoPartido("file");
        System.out.println(daoPartido.imprimir());

        daoPartido= FactoryImpDaoPartido.getImpDaoPartido("json");
        System.out.println(daoPartido.imprimir());
    }
}