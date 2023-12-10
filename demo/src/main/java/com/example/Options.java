package com.example; 
import com.example.*;

public class Options {
    public static void choice1() {
        String username = MethodsUser.nameUser();
        String password = MethodsUser.passwordUser();
        if (UseDB.authenticateUser(username, password)) {
            System.out.println("Login successful!");
            if (UseDB.checkfores(username) == 0) {
                UseDB.elegxossyndesis(username);
                MethodsUser.insertdata(username);
            }
            
        } else {
            System.out.println("Login failed.Incorrect username or password.");
        }
    }
    public static void choice2() {
        String username = MethodsUser.nameUser();
        if (UseDB.usernameExist(username)) {
            System.out.println("Username already taken. Please choose another.");
        } else {
            String password = MethodsUser.passwordUser();
            System.out.println("Registration successful! You can now log in.");
            MethodsUser.newuser(username, password);
        }
    }
    public static void choice3() {
        System.out.println("Exit the program.");
    }
}
