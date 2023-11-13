import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteExample {
    public static void main(String[] args) {
        // Σύνδεση στη βάση δεδομένων
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/path/to/your/database.db")) {

            // Δημιουργία Statement
            try (Statement statement = connection.createStatement()) {
                // Δημιουργία πίνακα
                String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, username TEXT, password TEXT);";
                statement.execute(createTableSQL);
            }

            // Εισαγωγή δεδομένων
            try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?);")) {
                insertStatement.setString(1, "john_doe");
                insertStatement.setString(2, "password123");
                insertStatement.executeUpdate();
            }

            // Επεξεργασία δεδομένων
            try (PreparedStatement updateStatement = connection.prepareStatement("UPDATE users SET password = ? WHERE username = ?;")) {
                updateStatement.setString(1, "newpassword");
                updateStatement.setString(2, "john_doe");
                updateStatement.executeUpdate();
            }

            // Ανάκτηση δεδομένων
            try (PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?;")) {
                selectStatement.setString(1, "john_doe");
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password);
                    }
                }
            }

            // Διαγραφή δεδομένων
            try (PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM users WHERE username = ?;")) {
                deleteStatement.setString(1, "john_doe");
                deleteStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
