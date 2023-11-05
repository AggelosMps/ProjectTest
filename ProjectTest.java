import java.util.Scanner;
public class ProjectTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProfileManager profileManager = new ProfileManager();
        boolean successful_login=false;
        while (!successful_login) {
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (profileManager.authenticate(username, password)) {
                    System.out.println("Login successful!");
                    successful_login=true;
                    // Proceed with the application logic for the logged-in manager.
                } else {
                    System.out.println("Login failed. Incorrect username or password.");
                }
            } else if (choice == 2) {
                System.out.print("Enter a new username: ");
                String username = scanner.nextLine();
                if (profileManager.managerExists(username)) {
                    System.out.println("Username already taken. Please choose another.");
                } else {
                    System.out.print("Enter a password: ");
                    String password = scanner.nextLine();
                    ManagerData newProfile = new ManagerData(username, password);
                    profileManager.addProfile(newProfile);
                    System.out.println("Registration successful! You can now log in.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting the application.");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        System.out.println(profileManager.profiles.get(0).getUsername());
        System.out.println("1) Give me an income");
        Double income= scanner.nextDouble();
        profileManager.profiles.get(0).SetIncome(income);
        System.out.println(profileManager.profiles.get(0).getIncome());

    }
}
