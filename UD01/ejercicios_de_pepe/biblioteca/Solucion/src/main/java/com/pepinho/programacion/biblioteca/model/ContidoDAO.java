package com.pepinho.programacion.biblioteca.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContidoDAO implements DAO<Contido> {

    private final Connection con;

    public ContidoDAO(Connection con) {
        this.con = con;
    }

    @Override
    public Contido get(long id) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try (var st = con.prepareStatement("SELECT idContido, idBook, contido" +
                        " FROM Contido WHERE idContido=?");) {
                    st.setInt(1, (int) id);
                    // ResultSet:
                    var rs = st.executeQuery();
                    if (rs.next()) {
                        Contido contido = new Contido(rs.getLong(1),
                                rs.getLong(2));
                        Clob clob = rs.getClob("contido");
                        contido.setContido(clob.getSubString(1, (int) clob.length()));
                        return contido;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener contenido del libro: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Contido> getAll() {
        List<Contido> contidos = null;
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try (var st = con.prepareStatement("SELECT idContido, idBook, contido" +
                        " FROM Contido");) {
                    // ResultSet:
                    var rs = st.executeQuery();
                    while (rs.next()) {
                        Contido contido = new Contido(rs.getLong("idContido"),
                                rs.getLong("idBook"));
                        Clob clob = rs.getClob("contido");
                        contido.setContido(clob.getSubString(1, (int) clob.length()));
                        return List.of(contido);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener contenido del libro: " + ex.getMessage());
        }
        return contidos;
    }

    @Override
    public void save(Contido contido) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try (var st = con.prepareStatement("INSERT INTO Contido " +
                        "(idBook, contido) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {
                    st.setLong(1, contido.getIdBook());
                    Clob clob = con.createClob();
                    clob.setString(1, contido.getContido());
                    st.setClob(2, clob);
                    int count = st.executeUpdate();
                    if (count > 0) {
                        System.out.println("count = " + count);
                        // Asigno id:
                        ResultSet rs = st.getGeneratedKeys();
                        if (rs.next()) {
                            contido.setIdContido(rs.getLong(1));
                        }
                    } else
                        System.out.println("No se ha insertado");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar contenido del libro: " + ex.getMessage());
        }
    }

    @Override
    public void update(Contido contido) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try (var st = con.prepareStatement("UPDATE Contido SET " +
                        "idBook=?, contido=? WHERE idContido=?");) {
                    st.setLong(1, contido.getIdBook());
                    Clob clob = con.createClob();
                    clob.setString(1, contido.getContido());
                    st.setClob(2, clob);
                    st.setLong(3, contido.getIdContido());
                    int count = st.executeUpdate();
                    if (count > 0)
                        System.out.println("count = " + count);
                    else
                        System.out.println("No se ha actualizado");
                }
            } else {
                System.out.println("No se ha podido conectar");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar contenido del libro: " + e.getMessage());
        }
    }

    @Override
    public void delete(Contido contido) {
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try (var st = con.prepareStatement("DELETE FROM Contido WHERE idContido=?");) {
                    st.setLong(1, contido.getIdContido());
                    int count = st.executeUpdate();
                    if (count > 0)
                        System.out.println("count = " + count);
                    else
                        System.out.println("No se ha borrado");
                }
            } else {
                System.out.println("No se ha podido conectar");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar contenido del libro: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long idContido) {
        try {
            if (con != null && !con.isClosed()) {
                try (var st = con.prepareStatement("DELETE FROM Contido WHERE " +
                        "idContido=?");) {
                    st.setLong(1, idContido);
                    int count = st.executeUpdate();
                    if (count > 0)
                        System.out.println("count = " + count);
                    else
                        System.out.println("No se ha borrado");
                }
            } else {
                System.out.println("No se ha podido conectar");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar contenido del libro: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Long> getAllIds() {
        List<Long> ids = new ArrayList<>();
        try {
            if (con != null && !con.isClosed()) {
                // Crear Statement
                try (var st = con.prepareStatement("SELECT idContido FROM " +
                        "Contido ORDER BY idContido");) {
                    // ResultSet:
                    var rs = st.executeQuery();
                    while (rs.next()) {
                        ids.add(rs.getLong("idContido"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al leer contenido del libro: " + ex.getMessage());
        }
        return ids;
    }

    @Override
    public void updateLOB(Contido book, String f) {
        try {
            if (con != null && !con.isClosed()) {
                try (var ps = con.prepareStatement("UPDATE Contido SET " +
                        "contido=? WHERE idContido=?");) {
                    ps.setLong(2, book.getIdContido());
                    Clob clob = con.createClob();
                    clob.setString(1, book.getContido());
                    ps.setClob(1, clob);
                    int count = ps.executeUpdate();
                    if (count > 0)
                        System.out.println("count = " + count);
                    else
                        System.out.println("No se ha actualizado");
                }
            } else {
                System.out.println("No se ha podido conectar");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar contenido del libro: " + e.getMessage());
        }
    }

    @Override
    public void updateLOBById(long idContido, String f) {
        try {
            if (con != null && !con.isClosed()) {
                try (var ps = con.prepareStatement("UPDATE Contido SET " +
                        "contido=? WHERE idContido=?");) {
                    ps.setLong(2, idContido);
                    Clob clob = con.createClob();
                    clob.setString(1, f);
                    ps.setClob(1, clob);
                    int count = ps.executeUpdate();
                    if (count > 0)
                        System.out.println("count = " + count);
                    else
                        System.out.println("No se ha actualizado");
                }
            } else {
                System.out.println("No se ha podido conectar");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar contenido del libro: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        try {
            if (con != null && !con.isClosed()) {
                try (var st = con.prepareStatement("DELETE FROM Contido");) {
                    int count = st.executeUpdate();
                    if (count > 0)
                        System.out.println("count = " + count);
                    else
                        System.out.println("No se ha borrado");
                }
            } else {
                System.out.println("No se ha podido conectar");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar contenido del libro: " + e.getMessage());
        }
    }
}
