import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Savefile {

    public static void createusernamesfile(String username, String password) {
        try {
            // Ο δεύτερος παράμετρος του FileWriter είναι true για να επιτρέπει τον αντικαταστατικό εγγραφή
            BufferedWriter writer = new BufferedWriter(new FileWriter("usernames_passwords.txt", true));
            writer.write(username);
            writer.write("\n" + password + "\n");  // Προσθήκη κενής γραμμή για διάχωρισμό
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean usernameExist(String usernameToCheck) {
        String filename = "usernames_passwords.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Διαβάστε κάθε μονή γραμμή του αρχείου
            while ((line = reader.readLine()) != null) {
                // Ελέγξτε αν το όνομα χρήστη υπάρχει στην μονή γραμμή
                if (line.trim().equals(usernameToCheck)) {
                    return true;  // Το όνομα χρήστη υπάρχει
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;  // Το όνομα χρήστη δεν υπάρχει
    }

    public static boolean authenticateUser(String usernameToCheck, String passwordToCheck) {
        String filename = "usernames_passwords.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Διαβάστε κάθε μια γραμμή του αρχείου
            while ((line = reader.readLine()) != null) {
                String storedUsername = line.trim();  // Διαβάστε το όνομα χρήστη
                String storedPassword = reader.readLine().trim();  // Διαβάστε τον κωδικό χρήστη

                // Ελέγξτε αν το όνομα χρήστη και ο κωδικός ταιριάζουν
                if (storedUsername.equals(usernameToCheck) && storedPassword.equals(passwordToCheck)) {
                    return true;  // Η ταυτοποίηση επιτυχής
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;  // Η ταυτοποίηση αποτυχημένη
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

    public static void userquenstion(String username, String answer) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(username + ".txt"));
            writer.write(answer + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       System.out.println("Δώσε το όνομα σου");
       String username = sc.nextLine();
       System.out.println("Δώσε το password");
       String password = sc.nextLine();
       createusernamesfile(username, password);
       System.out.println("Δώσε το όνομα");
       String chechusername = sc.nextLine();
       System.out.print(usernameExist(chechusername));
       String name = sc.nextLine();
       String pass = sc.nextLine();
       System.out.print(authenticateUser(name, pass));
    
      createusernamesfile("HFFH", "FABF");
     }  
     */
    
}

