package org.example.singleton;

public class Singleton1 {
    private int valor;

    public Singleton1() {}

    private static final Singleton1 instancia = new Singleton1();

    public static Singleton1 getInstance(){
        return instancia;
    }
}
