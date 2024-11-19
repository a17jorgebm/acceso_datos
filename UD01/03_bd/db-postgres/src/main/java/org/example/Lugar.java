package org.example;

public class Lugar {

    private String nome;
    private double longitud;
    private double latitud;
    private String estado;
    private String abreviaturaEstado;
    // ...


    public Lugar(String nome, String abreviaturaEstado, String estado, double latitud, double longitud) {
        this.nome = nome;
        this.abreviaturaEstado = abreviaturaEstado;
        this.estado = estado;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    /**
     * Método que devuelve un String con los datos del lugar en formato HTML con colores.
     * @return String con los datos del lugar en formato HTML con colores.
     */
    public String toHTML() {
        return "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    /**
     * Método que recoge un boolean si quiero devolver el lugar en formato fila de una tabla HTML.
     * Devuelve un String con los datos del lugar en formato HTML con colores.
     * Si está en una fila de una tabla HTML, el fondo de la fila es de color gris.
     * @param fila boolean que indica si quiero devolver el lugar en formato fila de una tabla HTML.
     */
    public String toHTML(boolean fila) {
        return (fila) ? "<tr style=\"background-color: #cccccc\">"
                + "<td>" + nome + "</td>"
                + "<td>" + longitud + "</td>"
                + "<td>" + latitud + "</td>"
                + "<td>" + estado + "</td>"
                + "<td>" + abreviaturaEstado + "</td>"
                + "</tr>"
                : "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    /**
     * Método que devuelve un String con los datos del lugar en formato texto.
     * @return String con los datos del lugar en formato texto.
     */
    @Override
    public String toString() {
        return " Lugar: " + nome + System.lineSeparator()
                + " Longitud: " + longitud + System.lineSeparator()
                + " Latitud: " + latitud + System.lineSeparator()
                + " Comunidad: " + estado + System.lineSeparator()
                + " Abreviatura Comunidad: " + abreviaturaEstado + System.lineSeparator();
    }
    //...


}
