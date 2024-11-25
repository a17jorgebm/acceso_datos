package org.example.ejer1;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            connection=BibliotecaConnectionManager.getInstance().getConnection();
            System.out.println(connection);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
