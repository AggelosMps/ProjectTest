package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class UseDB {
    public static Connection connection = null;

    public static boolean usernameExist(String usernameToCheck) {
        boolean y = false;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username FROM Manager");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                if (username.equals(usernameToCheck)) {
                    y = true;
                } else {
                    y = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return y;

    }

    public static boolean authenticateUser(String usernameToCheck, String passwordToCheck) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            boolean truename = false;
            boolean truepassword = false;
            ResultSet resultSet = statement.executeQuery("SELECT username FROM Manager ");
            while (resultSet.next()) {
               String username = resultSet.getString("username");
               if (username.equals(usernameToCheck)) {
                  truename = true;
                }
            }
        if (truename = true) {
           ResultSet resultSet2 = statement.executeQuery("SELECT password FROM Manager ");
            while (resultSet2.next()) {
               String password = resultSet.getString("password");
               if (password.equals(passwordToCheck)) {
                  truepassword = true;
                }
            }
        }
         if (truename && truepassword) {
            return true;
        } else {
            return false;
        }
       } catch (SQLException e) {
        e.printStackTrace();
       }
       return false;

    }

    public static void syndeshxrhsthprotifora(String username) {
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(username  + "timeslogin.txt"));
        writer.write("0");
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void elegxossyndesis(String username) {
        try {
            File file = new File(username + "timeslogin.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
    
            // Read the existing content
            String line = reader.readLine();
            reader.close();
    
            // Update the content
            if (line != null && line.equals("0")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("1");
                writer.close();
                System.out.println("File content updated successfully.");
            } else {
                System.out.println("File content was not updated. Current content may not be '0'.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checkfores(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(username + "timeslogin.txt"));
            String firstline = reader.readLine();
            int intValue = Integer.parseInt(firstline);
            return intValue;
        } catch(IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void createTableDB(String username, String password) {
        try {
            // Connect to the SQLite database (creates the database if it doesn't exist)
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Manager (username VARCHAR(40) PRIMARY KEY, password VARCHAR(40), operating_days INT, Store_Opening_Time VARCHAR(20), Store_Closing_Time VARCHAR(20), employees INT, product_name VARCHAR(40), pr_now INT, pr_yesterday INT, pr_db_yesterday INT, price DOUBLE, pr_cost DOUBLE)");

            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Manager (username, password) VALUES (?, ?)");
            insertStatement.setString(1, username);
            insertStatement.setString(2, password);
            insertStatement.executeUpdate();

            System.out.println("Manager data added successfully!");

            // Retrieve and display the saved revenue data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Manager ");
            while (resultSet.next()) {
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
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

    public static void insertIntoDBDouble(String column, double value,String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET "+ column +" = ? WHERE username = ?");
            pS.setDouble(1, value);
            pS.setString(2, username);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertIntoDBString(String column, String value,String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET "+ column +" = ? WHERE username = ?");
            pS.setString(1, value);
            pS.setString(2, username);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertIntoDBInt(String column, int value, String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET "+ column +" = ? WHERE username = ?");
            pS.setInt(1, value);
            pS.setString(2, username);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Number selectFromTableNumber(String username, String apantisi) {
    try {
        connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + apantisi + " FROM Manager WHERE username = " + "'" + username + "'");         //Warning may cause error in the Diagrams!!!
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
public static String selectFromTableString(String username, String apantisi) {
    try {
        connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + apantisi + " FROM Manager WHERE username = " + "'" + username + "'");
        if (resultSet.next()) {
            return resultSet.getString(apantisi);   
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}
