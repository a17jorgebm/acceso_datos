package org.example;

import java.sql.*;

public class Main {
    private static final String urlConexion="jdbc:sqlite:/home/sanclemente.local/a17jorgebm/Documentos/acceso_datos/db-sqlite/databases/zoo_ejemplo.db";
    public static void main(String[] args) throws SQLException {
        Connection conexion= DriverManager.getConnection(urlConexion);

        PreparedStatement ps=conexion.prepareStatement("SELECT * FROM animales a");
        ResultSet resultSet= ps.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
        System.out.println("conectado");
    }
}