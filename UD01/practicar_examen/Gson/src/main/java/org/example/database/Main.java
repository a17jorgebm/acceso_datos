package org.example.database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnectionManager.getInstance().getConnection();

        String sql = "SELECT * FROM USERS WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, 1);
        ResultSet resultSet = pstmt.executeQuery();
        if (!resultSet.isBeforeFirst()){
            while (resultSet.next()){
                System.out.println(resultSet.getString("TITULO"));
            }
        }

        connection.setAutoCommit(false);
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?)");
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"ola");
            preparedStatement.setString(3,"ola");
            preparedStatement.setString(4,"ola");
            preparedStatement.addBatch();

            /// e asi as veces que queiramos... despois ejecutanse todos a vez de devolven un array de columnas afectadas
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"chao");
            preparedStatement.setString(3,"chao");
            preparedStatement.setString(4,"chao");
            preparedStatement.addBatch();

            int[] columnasAfectadas = preparedStatement.executeBatch();
            connection.commit();
        }catch (SQLException e){

        }finally {
            connection.setAutoCommit(true); //sempre volver a poñer esto
        }


        //pillar as claves generadas
        //hai que activar no preparedstatement
        PreparedStatement preparedStatementConClaves = connection.prepareStatement(
                "INSERT INTO USUARIOS values (?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        );
        int filasInsertadas = preparedStatementConClaves.executeUpdate();
        if (filasInsertadas>0){
            try(ResultSet resultSetClavesGeneradas = preparedStatementConClaves.getGeneratedKeys()){
                while (resultSetClavesGeneradas.next()){
                    //para cada unha das claves generadas pillamos a primeira columa como long pa sabela
                    //
                    resultSetClavesGeneradas.getLong(1);
                }
            }
        }

        byte[] bytes = null;
        PreparedStatement p2=connection.prepareStatement("");
        p2.setBinaryStream(1,new ByteArrayInputStream(bytes),bytes.length);
    }
}
