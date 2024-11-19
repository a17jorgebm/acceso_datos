package org.example;

import java.util.List;

public class CodigoPostal {

    private String codigoPostal;
    private String pais;
    private String abreviaturaPais;
    private List<Lugar> lugares;

    public CodigoPostal(String codigoPostal, String pais, String abreviaturaPais, List<Lugar> lugares) {
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.abreviaturaPais = abreviaturaPais;
        this.lugares = lugares;
    }
    //...
    /**
     * Devuelve la lista de lugares como HTML, empleando un forEach para concatenar los lugares.
     * El método forEach recibe un Consumer, que es una interfaz funcional que tiene un método
     * abstracto accept() que recibe un objeto de tipo T y no devuelve nada (void).
     *
     * @return cadena de texto con los lugares en formato HTML
     */
    public String getLugaresAsHTML() {
        StringBuilder sb = new StringBuilder("<html><body>");
        lugares.forEach(lugar -> {
            sb.append(lugar.toHTML()).append("<br>");
        });
        sb.append("</body></html>");
        return sb.toString();
    }

    /**
     * Método que devuelve la lista de lugares como HTML, empleando un forEach para concatenar los lugares.
     * El método forEach recibe un Consumer, que es una interfaz funcional que tiene un método
     * abstracto accept() que recibe un objeto de tipo T y no devuelve nada (void).
     *
     * @param asTable boolean que indica si quiero devolver los lugares en formato fila de una tabla HTML.
     * @return  cadena de texto con los lugares en formato HTML
     */
    public String getLugaresAsHTML(boolean asTable) {
        StringBuilder sb = new StringBuilder("<html><body>");
        if (asTable) {
            sb.append("<table border=\"1\">");
            sb.append("<tr style=\"background-color: #cccccc\">");
            sb.append("<th>Lugar</th>");
            sb.append("<th>Longitud</th>");
            sb.append("<th>Latitud</th>");
            sb.append("<th>Comunidad</th>");
            sb.append("<th>Abreviatura Comunidad</th>");
            sb.append("</tr>");
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML(true));
            });
            sb.append("</table>");
        } else {
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML()).append("<br>");
            });
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("Código Postal: '"
                + codigoPostal + System.lineSeparator()
                + "Pais: '" + pais + System.lineSeparator()
                + "AbreviaturaPais: " + abreviaturaPais + System.lineSeparator());
        lugares.forEach(lugar -> {
            sb.append(lugar).append(System.lineSeparator());
        });
        return sb.toString();
    }



}