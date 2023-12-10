package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.example.*;
public class MethodsUser {
    public static Scanner scanner = new Scanner(System.in);
    public static String nameUser() {
        System.out.println("Δώσε το όνομα σου");
        String user = scanner.nextLine();
        return user;
    }
    public static String passwordUser() {
        System.out.println("Δώσε τον κωδικό σου");
        String userpa = scanner.nextLine();
        return userpa;
    }
    public static int menu() {
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        return answer;
    }
    public static void epilogesMenu() {
        boolean flag = true;
        int answer = 0;
        while (flag) {    
            System.out.println("Σε ποιόν τομέα θέλετε να σας εξυπηρετήσουμε;");
            System.out.println("1. Αποθέματα (Σας προτείνει το προιόν που πρέπει να αγοράσετε για να μεγιστοποιήσετε το κέρδος σας, βάση των πωλήσεων που έχετε κάνει τις προηγούμενες 3 μέρες.)");
            System.out.println("2. Τιμολόγηση (Σας προτείνει την καλύτερη τιμή για να μεγιστοποιήσετε το κέρδος σας, βάση των πωλήσεων που έχετε κάνει τις προηγούμενες 3 μέρες.)");
            System.out.println("3. Πρόγραμμα προσωπικού (Ωρολόγιο πρόγραμμα προσωπικού.)");
            System.out.println("4. Οικονομικές καταστάσεις (Έσοδα, Έξοδα, Κέρδη επιχείρησης, έχοντας την επιλογή και για διαγραμματική αναπαράσταση.)");
            try {
                answer = scanner.nextInt();
                if (answer >= 0 && answer <=4) {
                    flag = false;
                } else {
                    System.out.println("Παρακαλούμε επιλέξτε ένα απο τα ακόλουθα.");
                }    
            } catch (InputMismatchException e) {
                System.out.println("Παρακαλούμε επιλέξτε ένα απο τα ακόλουθα.");
            }
        }
        epilogesDiadikasia(answer);   
    }
    public static void insertdata(String username) {
        insertOperating_days(username);
        insertStore_Opening_Time(username);
        insertStore_Closing_Time(username);

        //synexeia



    }
    public static void insertOperating_days(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Πόσες μέρες λειτουργεί το κατάστημα;");
            int operating_days = scanner.nextInt();
            if (operating_days > 0) {
                y = false;
                UseDB.insertIntoDBInt("operaring_days", operating_days, username);
            } else {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertStore_Opening_Time(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Τι ώρα ανοίγει το κατάστημα");            
            try {
                String Store_Opening_Time = scanner.nextLine();
                UseDB.insertIntoDBString("Store_Opening_Time", Store_Opening_Time, username);
                y = false;
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void insertStore_Closing_Time(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Τι ώρα κλείνει το κατάστημα");            
            try {
                String Store_Closing_Time = scanner.nextLine();
                UseDB.insertIntoDBString("Store_Closing_Time", Store_Closing_Time, username);
                y = false;
            } catch (InputMismatchException e) {
                System.out.println("Λάθος καταχώρηση, παρακαλώ προσπαθήστε ξανά");
            }
        }
    }
    public static void epilogesDiadikasia(int answer) {
        // kalei tis katalhlles methodous gia thn leitourgia pou epeleje o xrhsths
    }







    public static void newuser(String username, String password) {
        UseDB.syndeshxrhsthprotifora(username);
        UseDB.createTableDB(username, password);
    } 
        
}
