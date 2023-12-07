package com.example;

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
    public static void question1(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Δώσε αποθέματα");
            int apothemata = scanner.nextInt();
            if (apothemata >= 0) {
                y = false;
                MethodsDB.insertApantisi1intoDB(apothemata, username);
            }
        }
    }
    public static void question2(String username) {
        boolean y = true;
        while (y) {
            System.out.println("Δώσε τιμές των προϊόντων");
            double price = scanner.nextDouble();
            if (price >= 0) {
                y = false;
                MethodsDB.insertApantisi2intoDB(price, username);
            }
        }
    }
    public static void question3(String username) {
        System.out.println("Δώσε οικονομικά αποτελέσματα");
        double financial = scanner.nextDouble();
        MethodsDB.insertApantisi3intoDB(financial, username);
        BarChartFX.main(null);
        PieChartFX.main(null);
        AreaChart.main(null);
        LineChart.main(null);
    }
    public static void newuser(String username, String password) {
        UseDB.syndeshxrhsthprotifora(username);
        UseDB.createTableBD(username, password);
    }
}
