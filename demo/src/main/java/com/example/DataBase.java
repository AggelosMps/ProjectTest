package com.retail;
import java.sql.*;

public class DataBase {
    public static Connection connection = null;

    public static int selectFromTable(String username, String apantisi) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:revenue_data.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + apantisi + " FROM Manager WHERE username = '" + username + "'");
            if (resultSet.next()) {
                int temp = resultSet.getInt(apantisi);
                return temp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = selectFromTable("Nikos", "ap_1");
        System.out.println(i);
    }
}
