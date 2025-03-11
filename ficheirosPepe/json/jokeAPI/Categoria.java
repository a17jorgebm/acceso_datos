package com.pepinho.ad.joke;

/**
 * Created by Pepinho on 21/10/15.
 * <p>
 * Enumeración de categorías de chistes.
 * Pueden ser: Any, Misc, Programming, Dark, Pun, Spooky, Christmas
 * Atributo: nombre, de tipo cadena.
 */
public enum Categoria {
    ANY("Any"),
    MISC("Misc"),
    PROGRAMMING("Programming"),
    DARK("Dark"),
    PUN("Pun"),
    SPOOKY("Spooky"),
    CHRISTMAS("Christmas");

    private final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la categoría a partir de su nombre.
     *
     * @param nombre Nombre de la categoría
     * @return Categoría
     */
    public static Categoria getCategoria(String nombre) {
        for (Categoria c : Categoria.values()) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }
//    public static Categoria getCategoria(String nombre) {
//        return Arrays.stream(values())
//                .filter(c -> c.getNombre().equals(nombre))
//                .findFirst()
//                .orElse(null);
//    }

    /**
     * Sobreescribe el método toString() para que devuelva el nombre de la categoría.
     *
     * @return Nombre de la categoría
     * @see Enum#toString()
     */
    @Override
    public String toString() {
        return nombre;
    }

}
