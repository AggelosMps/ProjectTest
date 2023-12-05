package com.example;
import java.sql.*;

public class DataBase {
    public static Connection connection = null;
    public static Number selectFromTable(String username, String apantisi) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + apantisi + " FROM Manager WHERE username = " + "'" + username + "'");
            if (resultSet.next()) {
                if (resultSet.getObject(apantisi) instanceof Integer) {
                    return resultSet.getInt(apantisi);
                } else if (resultSet.getObject(apantisi) instanceof Double) {
                    return resultSet.getDouble(apantisi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(selectFromTable("Nikos", "ap_1"));
    }
}
