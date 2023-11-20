import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManagerData {
    private String username;
    private String password;
    private double income;


    // Constructor to create a new manager profile
    public ManagerData(String username, String password) {
        this.username = username;
        this.password = password;
	try {
	   BufferedWriter writer = new BufferedWriter(new FileWriter(this.username + "1.txt"));//Δημιουργία ενός αρχείου για την ταυτοποίηση του χρήστη
	   writer.write(this.username);
	   writer.write("n\" + this.password);
	   writer.close();
	} catch (IOException e) {
	   e.printStackTrace();
	}

    }
§
    public double getIncome() {
        return income;
    }

    public void SetIncome(double income) {
        this.income=income;
    }

    // Getter methods for username and password
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
