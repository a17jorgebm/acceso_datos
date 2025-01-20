/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.ad.bliblioteca.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pepecalo
 */
public class BibliotecaConnectionMaganer {

    private static final Logger log = LoggerFactory.getLogger(BibliotecaConnectionMaganer.class);

//    public static final String URL = "jdbc:h2:E:\\98 - Bases de datos\\h2\\bd\\library"
//            + ";DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";

    public static final String URL = "jdbc:h2:E:\\98 - Bases de datos\\h2\\biblioteca2"
            + ";DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE;FILE_LOCK=NO";

    public static final String DRIVER = "org.h2.Driver";

    private static BibliotecaConnectionMaganer instance;

    private Connection conexion;

    private BibliotecaConnectionMaganer() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Driver not found: %s".formatted(e.getMessage()));
        }
        conexion = getConnection();
    }

    public static BibliotecaConnectionMaganer getInstance() {
        if (instance == null) {
            // esperas ti e eu
            synchronized (BibliotecaConnectionMaganer.class) {
                if (instance == null) {
                    instance = new BibliotecaConnectionMaganer();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (conexion == null || conexion.isClosed()) {
                synchronized (BibliotecaConnectionMaganer.class) {
                    if (conexion == null || conexion.isClosed()) {
                        try {
                            conexion = DriverManager.getConnection(URL);
                            log.info("Establecida conexión");
                        } catch (SQLException ex) {
                            log.error("Erro ó establecer a conexión: %s".formatted(ex.getMessage()));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            log.debug(MessageFormat.format("Erro ó establecer a conexión: {0}", e.getMessage()));

        }
        return conexion;
    }


}
