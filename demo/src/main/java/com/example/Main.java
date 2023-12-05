package com.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Connect to the SQLite database (creates the database if it doesn't exist)
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");

            // Create a table to store revenue data
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Revenue (id INTEGER PRIMARY KEY, amount REAL, date TEXT, age INT)");

            //Insert revenue data into the table
            double revenueAmount = 840.00; // Sample revenue amount
            String date = "2023-04-20"; // Sample date
            int age = 25;

            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Manager (amount, date, age) VALUES (?, ?, ?)");
            insertStatement.setDouble(1, revenueAmount);
            insertStatement.setString(2, date);
            insertStatement.setInt(3, age);
            insertStatement.executeUpdate();

            //PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET amount = ? WHERE id = ?");
            //pS.setDouble(1, 888.00);
            //pS.setInt(2, 6);
            //pS.executeUpdate();

            System.out.println("Revenue data added successfully!");

            // Retrieve and display the saved revenue data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Manager");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double amount = resultSet.getDouble("amount");
                String revenueDate = resultSet.getString("date");
                int hlikia = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Amount: " + amount + ", Date: " + revenueDate + ", Age: " + hlikia);
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
    }
}