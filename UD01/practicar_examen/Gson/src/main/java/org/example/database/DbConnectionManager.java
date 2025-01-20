package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManager {
    private static final String URL_CONNECTION = "jdbc:h2:C:\\Users\\jorge\\Documents\\dam\\acceso_datos\\UD01\\practicar_examen\\Gson\\src\\main\\java\\org\\example\\database\\bd";

    private volatile static DbConnectionManager instance;
    private Connection connection;

    public DbConnectionManager() throws SQLException{
        getConnection();
    }

    public static DbConnectionManager getInstance() throws SQLException{
        if (instance==null){
            synchronized (DbConnectionManager.class){
                if (instance==null){
                    instance=new DbConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{
        if (connection==null || connection.isClosed()){
            synchronized (DbConnectionManager.class){
                if (connection==null || connection.isClosed()){
                    connection = DriverManager.getConnection(URL_CONNECTION);
                }
            }
        }
        return connection;
    }
}
