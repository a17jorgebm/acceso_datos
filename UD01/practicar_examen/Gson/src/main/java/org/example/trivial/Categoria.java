package org.example.trivial;

import java.util.Objects;

public final class Categoria implements Comparable<Categoria>{
    private static final String DEFAULT_CATEGORY = "General";

    private String nombre;

    public Categoria() {
        nombre=DEFAULT_CATEGORY;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Categoria o) {
        return nombre.compareTo(o.nombre);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Categoria categoria = (Categoria) object;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
