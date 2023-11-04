public class ManagerData {
    private String username;
    private String password;
    private double income;


    // Constructor to create a new manager profile
    public ManagerData(String username, String password) {
        this.username = username;
        this.password = password;
    }
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