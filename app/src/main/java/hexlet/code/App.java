package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;


public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String MENU_TEXT = """
            Please enter the game number and press Enter:
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit
            """;

    public static void main(String[] args) {
        String userChoice = getUserChoice();
        System.out.println();

        switch (userChoice) {
            case "0" -> System.out.println("Goodbye!");
            case "1" -> Greet.greeting(SCANNER);
            case "2" -> Even.evenGame(SCANNER);
            case "3" -> Calc.calcGame(SCANNER);
            case "4" -> Gcd.gcdGame(SCANNER);
            case "5" -> Progression.progressionGame(SCANNER);
            case "6" -> Prime.primeGame(SCANNER);
            default -> System.out.println("Invalid choice. Please try again.");
        }

        SCANNER.close();
    }

    private static String getUserChoice() {
        System.out.print(MENU_TEXT);
        System.out.print("Your choice: ");
        return SCANNER.nextLine();
    }
}





