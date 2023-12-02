package com.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Connect to the SQLite database (creates the database if it doesn't exist)
            connection = DriverManager.getConnection("jdbc:sqlite:revenue_data.db");
            
            // Create a table to store revenue data
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Revenue (id INTEGER PRIMARY KEY, amount REAL, date TEXT)");
            
            // Insert revenue data into the table
            double revenueAmount = 2000.00; // Sample revenue amount
            String date = "2023-12-16"; // Sample date
            
            /*PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Revenue (amount, date) VALUES (?, ?)");
            insertStatement.setDouble(1, revenueAmount);
            insertStatement.setString(2, date);
            insertStatement.executeUpdate();
            
            */System.out.println("Revenue data added successfully!");
            
            // Retrieve and display the saved revenue data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Revenue WHERE amount=2000");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double amount = resultSet.getDouble("amount");
                String revenueDate = resultSet.getString("date");
                System.out.println("ID: " + id + ", Amount: " + amount + ", Date: " + revenueDate);
            }
            //statement.executeQuery("SELECT amount FROM Revenue WHERE amount=5000")

            
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
