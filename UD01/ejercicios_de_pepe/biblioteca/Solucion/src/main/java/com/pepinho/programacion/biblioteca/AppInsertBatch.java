
package com.pepinho.programacion.biblioteca;

import com.pepinho.programacion.biblioteca.model.BibliotecaConnectionMaganer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppInsertBatch {

    public static final String RUTA = "E:\\98 - Bases de datos\\biblioteca\\bookscovers\\";

    public static InputStream getCover(String archivo) {
        try {
            return Files.newInputStream(Path.of(RUTA + archivo + ".jpg"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {

        BibliotecaConnectionMaganer connectionLibrary = BibliotecaConnectionMaganer.getInstance();

        Connection con = connectionLibrary.getConnection();

        try (var br = Files.newBufferedReader(Path.of("E:\\98 - Bases de datos\\biblioteca\\" +
                "datosbiblioteca.csv"));) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("linea = " + linea);
                String[] campos = linea.split(";");
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO PUBLIC.Book " +
                        "(isbn, titulo, autor, anho, disponible, portada) VALUES (?, ?, ?, ?, ?, ?)")) {
                    ps.setString(1, campos[0]);
                    ps.setString(2, campos[1]);
                    ps.setString(3, campos[2]);
                    ps.setInt(4, Integer.parseInt(campos[3]));
                    ps.setBoolean(5, Boolean.parseBoolean(campos[4]));
                    ps.setBinaryStream(6, getCover(campos[0]));
                    int count = ps.executeUpdate();
                    if (count > 0)
                        System.out.println("count = " + count);
                    else
                        System.out.println("No se ha insertado");
//                    ps.addBatch();
//                    int[] filasAfectadas = ps.executeBatch();
//                    for (int i = 0; i < filasAfectadas.length; i++) {
//                        System.out.println("i = " + filasAfectadas[i]);
//                    }
                } catch (SQLException e) {
                    System.err.println(e.getMessage());

                }
            }


        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }


    }

}
