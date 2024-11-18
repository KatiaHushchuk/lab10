package ua.edu.ucu.apps.decorator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.SneakyThrows;

public class DBConnection {

    private Connection connection;
    private static DBConnection dbConnection;

    @SneakyThrows
    private DBConnection() {
        this.connection = DriverManager.getConnection("/Users/admin/Desktop/oop 2/cache1.db");
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    @SneakyThrows
    public String getDocument(String gcsPath) {
        PreparedStatement statement = 
            connection.prepareStatement("SELECT * FROM DOCUMENT WHERE path=?");
            statement.setString(1, gcsPath);
            ResultSet resultSet =  statement.executeQuery();
        return resultSet.getString("parsed");
    }

    @SneakyThrows
    public void createDocument(String gcsPath, String parse) {
        PreparedStatement callablStatement = connection
            .prepareStatement("INSERT INTO test(path, parsed) VALUES(?,");
            callablStatement.setString(1, gcsPath);
            callablStatement.setString(2, parse);
            callablStatement.executeUpdate();
            callablStatement.close();

    }
    
}



