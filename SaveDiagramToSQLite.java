import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveDiagramToSQLite {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/path/to/your/database.db")) {
            // Δημιουργία πίνακα με στήλη BLOB
            String createTableSQL = "CREATE TABLE IF NOT EXISTS diagrams (id INTEGER PRIMARY KEY, diagram BLOB);";
            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL)) {
                createTableStatement.execute();
            }

            // Ανέβασμα διαγράμματος από αρχείο
            File diagramFile = new File("/path/to/your/diagram.png");
            byte[] diagramBytes = readBytesFromFile(diagramFile);

            // Εισαγωγή του διαγράμματος ως BLOB στον πίνακα
            String insertDiagramSQL = "INSERT INTO diagrams (diagram) VALUES (?);";
            try (PreparedStatement insertDiagramStatement = connection.prepareStatement(insertDiagramSQL)) {
                insertDiagramStatement.setBytes(1, diagramBytes);
                insertDiagramStatement.executeUpdate();
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] readBytesFromFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            return fileBytes;
        }
    }
}
