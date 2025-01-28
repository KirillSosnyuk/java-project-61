package hexlet.code.games;

import java.util.Scanner;

public class Greet {
    public static String greeting(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        return userName;

    }
}
