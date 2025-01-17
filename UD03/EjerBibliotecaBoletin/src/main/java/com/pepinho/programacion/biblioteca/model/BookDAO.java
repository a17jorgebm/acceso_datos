/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.biblioteca.model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @autor pepecalo
 */
public class BookDAO implements DAO<Book> {

    private final Connection con;

    public BookDAO(Connection con) {
        this.con = con;
    }

    @Override
    public Book get(long idBook) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try ( var st = con.prepareStatement("SELECT idBook, isbn, titulo, autor, anho, disponible, portada" +
                        " FROM Book WHERE idBook=?");) {
                    st.setInt(1, (int) idBook);
                    // ResultSet:
                    var rs = st.executeQuery();
                    if (rs.next()) {
                        Book book = new Book(rs.getInt("idBook"),
                                rs.getString("isbn"), rs.getString("titulo"),
                                rs.getString("autor"), rs.getInt("anho"),
                                rs.getBoolean("disponible"),
                                rs.getBytes("portada"));
                        return book;

                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener libro: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> biblioteca = new ArrayList<>();
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try ( Statement st = con.createStatement();) {
                    // ResultSet:
                    ResultSet rs = st.executeQuery("SELECT * FROM Book");
                    while (rs.next()) {
                        Book book = new Book(rs.getInt("idBook"),
                                rs.getString("isbn"), rs.getString("titulo"),
                                rs.getString("autor"), rs.getInt("anho"),
                                rs.getBoolean("disponible"),
                                rs.getBytes("portada"));
                        biblioteca.add(book);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al leer libros: " + ex.getMessage());
        }
        return biblioteca;
    }

    @Override
    public void save(Book book) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try ( var ps = con.prepareStatement("INSERT "
                        + "INTO Book (isbn, titulo, autor, anho, disponible, portada)"
                        + " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);) {
                    //

                    System.out.println("book = " + book);
                    setBookValues(book, ps);
                    ps.executeUpdate();
                    // Asigno id:
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        book.setIdBook(rs.getInt(1));
                    }

                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
        }

    }

    private void setBookValues(Book book, PreparedStatement ps) throws SQLException {
        ps.setString(1, book.getIsbn());
        ps.setString(2, book.getTitle());
        ps.setString(3, book.getAuthor());
        ps.setInt(4, book.getYear());
        ps.setBoolean(5, book.isAvailable());
        ps.setBytes(6, book.getCover());
    }

    @Override
    public void update(Book book) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try ( var ps = con.prepareStatement("UPDATE  "
                        + "Book SET isbn=?, titulo=?, autor=?, "
                        + "anho=?, disponible=?, portada=? WHERE idBook= ?");) {
                    // 
                    setBookValues(book, ps);
                    ps.setInt(7, book.getIdBook());
                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        }
    }

    @Override
    public void delete(Book f) {
        try {
            if (con != null && !con.isClosed()) {
                try ( var ps = con.prepareStatement("DELETE FROM "
                        + "Book WHERE idBook=?")) {
                    ps.setLong(1, f.getIdBook());
                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    @Override
    public boolean deleteById(long idBook) {
        try {
            if (con != null && !con.isClosed()) {
                try ( Statement ps = con.createStatement()) {
                    ps.executeUpdate("DELETE FROM "
                            + "Book WHERE idBook=" + idBook);
                    return true;
                }
            }
        } catch (SQLException ex) {

            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Integer> getAllIds() {
        List<Integer> ids = new ArrayList<>();
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try ( Statement st = con.createStatement();) {
                    // ResultSet:
                    ResultSet rs = st.executeQuery("SELECT idBook FROM Book ORDER BY idBook");
                    while (rs.next()) {
                        ids.add(rs.getInt("idBook"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al leer libros: " + ex.getMessage());
        }
        return ids;
    }

    public void updateLOB(Book book, String f) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try ( PreparedStatement ps = con.prepareStatement("UPDATE  "
                        + "Book SET portada=? WHERE idBook= ?");
                      var bis = new BufferedInputStream(new FileInputStream(f));) {
                    // 
                    ps.setBinaryStream(1, bis);
                    ps.setInt(2, book.getIdBook());
                    ps.executeUpdate();
                    book.setPortada(f);
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo non atopado: "
                            + ex.getMessage());
                } catch (IOException ex) {
                    System.out.println("Erro de E/S : " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        }
    }

    @Override
    public void updateLOBById(long id, String f) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try ( PreparedStatement ps = con.prepareStatement("UPDATE  "
                        + "Book SET portada=? WHERE idBook= ?");
                      var bis = new BufferedInputStream(new FileInputStream(f));) {
                    //
                    ps.setBinaryStream(1, bis);
                    ps.setLong(2, id);
                    ps.executeUpdate();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo non atopado: " + ex.getMessage());
                } catch (IOException ex) {
                    System.out.println("Erro de E/S : " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        try {
            if (con != null && !con.isClosed()) {
                try ( Statement ps = con.createStatement()) {
                    ps.executeUpdate("DELETE FROM Book");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar los Libros. " + ex.getMessage());
        }
}

}
