package com.examplel;

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
            connection = DriverManager.getConnection("jdbc:sqlite:revenue_data.db");
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
            connection = DriverManager.getConnection("jdbc:sqlite:revenue_data.db");
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
            BufferedReader reader = new BufferedReader(new FileReader(username + "timeslogin.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(username + "temp.txt"));

            // Διαβάστε την πρώτη γραμμή και ενημερώστε την
            String firstLine = reader.readLine();

            // Εγγράψτε την ενημερωμένη πρώτη γραμμή στο νέο αρχείο
            writer.write("1");
            writer.newLine();  
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

     File oldFile = new File(username + "timeslogin.txt");
     File newFile = new File(username +"temp.txt"); 
    newFile.renameTo(oldFile);
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

    public static void createTableBD(String username, String password) {
        try {
            // Connect to the SQLite database (creates the database if it doesn't exist)
            connection = DriverManager.getConnection("jdbc:sqlite:revenue_data.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Manager (username VARCHAR(40) PRIMARY KEY, password VARCHAR(40), ap_1 INT)");

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

    public static void insertIntoDB(double apothemata,String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:revenue_data.db");
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET ap_1 = ? WHERE username = ?");
            pS.setDouble(1, apothemata);
            pS.setString(2, username);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(usernameExist("Nikos"));
    }
    
}
