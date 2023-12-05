package com.example; 
import java.sql.*;

public class MethodsDB {
    public static Connection connection = null;

    public static void insertApantisi1intoDB(int apothemata,String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");\\Αλλαγή ονόματος βάσης
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET ap_1 = ? WHERE username = ?");
            pS.setInt(1, apothemata);
            pS.setString(2, username);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertApantisi2intoDB(double timologisi,String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");\\Αλλαγή ονόματος βάσης
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET ap_2 = ? WHERE username = ?");
            pS.setDouble(1, timologisi);
            pS.setString(2, username);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertApantisi3intoDB(double oikonomikaapotelesmata,String username) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Manager_data.db");\\Αλλαγή ονόματος βάσης
            Statement statement = connection.createStatement();
            PreparedStatement pS = connection.prepareStatement("UPDATE Manager SET ap_3 = ? WHERE username = ?");
            pS.setDouble(1, oikonomikaapotelesmata);
            pS.setString(2, username);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
