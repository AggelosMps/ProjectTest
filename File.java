import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Vasilis","Dimitris","Aggelos","Kostas","Stratos","Mpampis","Nikos"};

        
        System.out.println("Give your username");
        String username = sc.nextLine();
        System.out.println("Give your password");
        String password = sc.nextLine();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(username+".txt"));
            writer.write("Username:" +username);
            writer.write("\nPassword:" + password);
            for (String name : names) {
                writer.write("\n" + name);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
