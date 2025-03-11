package com.pepinho.ad.joke;

import java.util.Arrays;

/**
 * Lenguajes admitidos por la API de chistes.
 *  * "jokeLanguages": [
 *  *         "cs",
 *  *         "de",
 *  *         "en",
 *  *         "es",
 *  *         "fr",
 *  *         "pt"
 *  *     ]
 *  Atributo con el nombre del lenguaje del chiste.
 *
 * @see <a href="https://sv443.net/jokeapi/v2/#languages">https://sv443.net/jokeapi/v2/#languages</a>
 */
public enum Lenguaje {
    CS("cs"),
    DE("de"),
    EN("en"),
    ES("es"),
    FR("fr"),
    PT("pt");

    private final String lenguaje;

    /**
     * Constructor de la clase Lenguajes.
     * @param lenguaje Nombre del lenguaje
     */
    Lenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    /**
     * Devuelve el nombre del lenguaje.
     * @return Nombre del lenguaje
     */
    public String getLenguaje() {
        return lenguaje;
    }

    public static Lenguaje getLenguaje(String lenguaje) {
        // Con expresiones lambda:
        return Arrays.stream(Lenguaje.values()).filter(l -> l.getLenguaje().equals(lenguaje)).findFirst()
                .orElse(null);
        /* // Con un bucle for:
//        for (Lenguaje l : Lenguaje.values()) {
//            if (l.getLenguaje().equals(lenguaje)) {
//                return l;
//            }
//        }
//         return null;
*/

    }



    @Override
    public String toString() {
        return lenguaje;
    }
}
