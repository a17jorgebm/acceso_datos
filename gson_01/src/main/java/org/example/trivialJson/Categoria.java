package org.example.trivialJson;

import java.util.Objects;

public class Categoria implements Comparable<Categoria>{
    private static final String DEFAULT_CATEGORY="General";

    private final String nombre;

    public Categoria() {
        this.nombre=DEFAULT_CATEGORY;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "categoria='" + nombre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Categoria o) {
        if (this==o) return 0;
        return this.nombre.compareTo(o.getNombre());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
