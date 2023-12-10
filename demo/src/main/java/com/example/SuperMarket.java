package com.example;

import java.util.Scanner;
import com.example.UseDB; 

public class SuperMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // ProfileManager profileManager = new ProfileManager();//Όταν δημιουργούμε ένα αντικείμενο ProfileManager για να χρησιμοποιήσουμε τις μεθόδους της κλάσης ProfileManager και δημιουργεί ένα ArrayList<> που περιέχει προσωρινά τα ονόματα των χρηστών
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

                if (UseDB.authenticateUser(username, password)) {//Καλούμε μία μέθοδο του ProfileManager η οποία ελέγχει αν υπάρχει αυτός ο χρήστης
                    System.out.println("Login successful!");
                    // Proceed with the application logic for the logged-in manager.
                    if (UseDB.checkfores(username) == 0) {
                        UseDB.elegxossyndesis(username);
                        System.out.println("Δώσε αποθέματα");
                        double apothemata = scanner.nextDouble();
                        UseDB.insertIntoDB(apothemata, username);
                    } 
                } else {
                    System.out.println("Login failed. Incorrect username or password.");
                }
} else if (choice == 2) { 
                System.out.print("Enter a new username: ");
                String username = scanner.nextLine();
                if (UseDB.usernameExist(username)) {//Καλούμε μία μέθοδο του ProfileManager η οποία ελέγχει αν το όνομα που εισάγει ο χρήστης υπάρχει ήδη. Πρέπει να το φτίαξουμε εδώ όταν το κάνει λάθος να του δίνεται η δυνατότητα να το ξαναβάλει. 
                    System.out.println("Username already taken. Please choose another.");
                } else {
                    System.out.print("Enter a password: ");
                    String password = scanner.nextLine();
                    System.out.println("Registration successful! You can now log in.");
                    UseDB.syndeshxrhsthprotifora(username);
                    UseDB.createTableBD(username, password);
                }

            } else if (choice == 3) {
                System.out.println("Exiting the application.");
                successful_login=true;
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        //System.out.println(profileManager.profiles.get(0).getUsername());//Δείχνει το username του πρώτου χρήστη
        //System.out.println("1) Give me an income");
        //Double income= scanner.nextDouble();
       // profileManager.profiles.get(0).SetIncome(income);//Προσθέτει το εισόδημα του χρήστη στην private μεταβλητή income 
       // System.out.println(profileManager.profiles.get(0).getIncome());//Επιστρέφει το εισόδημα του χρήστη

    }


}
