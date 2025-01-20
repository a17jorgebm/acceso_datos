package com.pepinho.programacion.biblioteca;

import com.pepinho.programacion.biblioteca.model.Book;
import com.pepinho.programacion.biblioteca.model.BookDAO;
import com.pepinho.programacion.biblioteca.model.BibliotecaConnectionMaganer;
import com.pepinho.programacion.biblioteca.model.DAO;
import com.pepinho.programacion.biblioteca.controller.BookController;
import com.pepinho.programacion.biblioteca.controller.IBookController;
import com.pepinho.programacion.biblioteca.view.BookView;
import com.pepinho.programacion.biblioteca.view.BookViewCutre;
import com.pepinho.programacion.biblioteca.view.IBookView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppBiblioteca {

    public static InputStream getFromURL(){
        try {
            URL url  = new URL("https://m.media-amazon.com/images/I/51pHAyAG4DL._SY445_SX342_.jpg");
            return url.openStream();
        } catch (MalformedURLException e) {
            System.err.println("URL incorrecta");
        } catch (IOException e) {
            System.err.println("Erro ó ler o arcquivo");
        }
        return null;
    }


    public static void main(String[] args) {

        BibliotecaConnectionMaganer bibliotecaConnection = BibliotecaConnectionMaganer.getInstance();

        DAO<Book> bookDAO = new BookDAO(bibliotecaConnection.getConnection());

        IBookController bookControler = BookController.getInstance();
        bookControler.setDao(bookDAO);
        IBookView bookView =  new BookView(bookControler); // new BookViewCutre(bookControler); // new BookView(bookControler);

        bookView.setVisible(true);



//
//        Connection con = bibliotecaConnection.getConnection();
//
//        try(PreparedStatement ps = con.prepareStatement("UPDATE Book SET PORTADA=? WHERE ISBN=?");
//            InputStream fi = Files.newInputStream(Path.of("E:\\elsentidodeunfinal.jpg"));){
//            ps.setBinaryStream(1, getFromURL());
//            ps.setString(2, "9780307959474");
//            int insertadas = ps.executeUpdate();
//            if(insertadas==0)
//                System.out.println("Non insertou a imaxe");
//        } catch (SQLException | IOException e) {
//            System.out.println("Erro ó insertar a imaxe: " + e.getMessage());
//        }

        // Ejemplo de cómo emplear supportsResultSetType y supportsResultSetConcurrency
        // para comprobar si el driver soporta el tipo de ResultSet que queremos emplear


//        Scanner sc = new Scanner(System.in);
//        System.out.println("Introduzca el título del libro a buscar: ");
//        String titulo = sc.nextLine();

//        if(con!=null){
//            try(PreparedStatement ps = con.prepareStatement("INSERT INTO PUBLIC.Book (isbn, title, author, ano, " +
//                    "available) VALUES (?, ?, ?, ?, ?);")){
//                ps.setString(1, "9780307959474");
//                ps.setString(2, "El Sentido de un Final");
//                ps.setString(3, "Julian Barnes");
//                ps.setInt(4, 2011);
//                ps.setBoolean(5, true);
//                int insertadas = ps.executeUpdate();
//                System.out.println("insertadas " + insertadas);
//
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }

//        if (con != null) {
//            try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_UPDATABLE);
//                 ResultSet rs = st.executeQuery("SELECT * FROM Book");) {
//
//
//                while (rs.next()) {
//                    System.out.printf("%d - %s%n", rs.getInt("idBook"), rs.getString("title"));
//                }
//
//
//            } catch (SQLException ex) {
//                System.out.println("Error al obtener libro: " + ex.getMessage());
//            }
//        }


//
//        BookDAO bookDAO = new BookDAO(bibliotecaConnection.getConnection());
//
//
//
//        new BibliotecaViewDAO("Biblioteca", bookDAO);
    }

    public static void admiteRetencion(Connection conn) throws SQLException {

        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println("ResultSet.HOLD_CURSORS_OVER_COMMIT = " +
                ResultSet.HOLD_CURSORS_OVER_COMMIT);
        System.out.println("ResultSet.CLOSE_CURSORS_AT_COMMIT = " +
                ResultSet.CLOSE_CURSORS_AT_COMMIT);
        System.out.println("Retención predeterminada del cursor: " +
                dbMetaData.getResultSetHoldability());
        System.out.println("¿Admite HOLD_CURSORS_OVER_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.HOLD_CURSORS_OVER_COMMIT));
        System.out.println("¿Admite CLOSE_CURSORS_AT_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.CLOSE_CURSORS_AT_COMMIT));
        try {
            if (conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("Soporta TYPE_SCROLL_INSENSITIVE");
            } else {
                System.out.println("No soporta TYPE_SCROLL_INSENSITIVE");
            }
            if (conn.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                System.out.println("Soporta CONCUR_UPDATABLE");
            } else {
                System.out.println("No soporta CONCUR_UPDATABLE");
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener metadatos: " + ex.getMessage());
        }

        if (conn != null) {
            System.out.println("Conexión establecida");
        } else {
            System.out.println("Conexión no establecida");
        }
    }


}
