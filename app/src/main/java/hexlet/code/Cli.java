package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greeting(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");

        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");

        return userName;
    }

}
