package com.pepinho.ad.joke;

/**
 * Created by Pepinho on 21/10/15.
 * Enumeración de banderas de chistes.
 * Pueden ser: NSFW, RELIGION, POLITICAL, RACIST, SEXIST
 * Atributo: String nombre.
 * Constructor: Flag(String nombre)
 * @see Categoria
 * @link <a href="https://v2.jokeapi.dev/flags">https://v2.jokeapi.dev/flags</a>
 */
public enum Flag {
    EXPLICIT("Explicit"),
    NSFW("NSFW"),
    RELIGION("Religion"),
    POLITICAL("Political"),
    RACIST("Racist"),
    SEXIST("Sexist");

    private final String nombre;

    Flag(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la bandera a partir de su nombre.
     * @param nombre Nombre de la bandera
     * @return Bandera
     */
    public static Flag getFlag(String nombre) {
        // Con expresiones lambda:
        return java.util.Arrays.stream(Flag.values()).filter(f -> f.getNombre().equals(nombre)).findFirst()
                .orElse(null);
/*        // Con un bucle for:
//        for (Flag f : Flag.values()) {
//            if (f.getNombre().equals(nombre)) {
//                return f;
//            }
//        }
//        return null;
        */
    }

    /**
     * Sobreescribe el método toString() para que devuelva el nombre de la bandera.
     * @return Nombre de la bandera
     * @see Enum#toString()
     */
    @Override
    public String toString() {
        return nombre;
    }
}
