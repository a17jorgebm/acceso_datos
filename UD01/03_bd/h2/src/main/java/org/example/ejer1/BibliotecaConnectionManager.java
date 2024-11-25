package org.example.ejer1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BibliotecaConnectionManager {
    private static final String DATABASE_URL="jdbc:h2:/home/sanclemente.local/a17jorgebm/Documentos/acceso_datos/UD01/03_bd/h2/db/biblioteca2;IFEXISTS=TRUE";

    private static volatile BibliotecaConnectionManager instance;

    private Connection connection;

    private BibliotecaConnectionManager(){
        connection=getConnection();
    }

    public static BibliotecaConnectionManager getInstance(){
        if (instance==null){
            synchronized (BibliotecaConnectionManager.class){
                if (instance==null){
                    instance=new BibliotecaConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws RuntimeException{
        try{
            if (connection == null || connection.isClosed()){
                synchronized (Connection.class){
                    if (connection==null){
                        try{
                            connection= DriverManager.getConnection(DATABASE_URL);
                        }catch (SQLException e){
                            System.out.println("error sync");
                            throw new RuntimeException("Error stating connection: "+e.getMessage());
                        }
                    }
                }
            }
        }catch (SQLException e){
            System.out.println("error fora");

            throw new RuntimeException("Error stating connection: "+e.getMessage());
        }

        System.out.println("establecida");
        return connection;
    }
}
