package br.edu.ifsp.application.repository.sqlite;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory implements AutoCloseable {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;

    public static Connection createConnection(){
        try {
        instantiateConnectionIfNull();}
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    private static void instantiateConnectionIfNull() throws SQLException {
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:database.db");
        if(connection == null) {
            connection = ds.getConnection();
        }
    }

    public static PreparedStatement createPreparedStatement(String sql){
        try {
           preparedStatement = createConnection().prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static Statement createStatement(){
        try {
            statement = createConnection().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return statement;
    }



    @Override
    public void close() throws Exception{
        closeStatementsIfNotNull();
        closeConnectionIfNotNull();
    }

    public void closeConnectionIfNotNull() throws Exception{
        closeStatementsIfNotNull();
        if (connection != null)
            connection.close();
    }

    public void closeStatementsIfNotNull() throws Exception {
        if (preparedStatement != null)
            preparedStatement.close();
        if (statement != null)
            statement.close();
    }
}
