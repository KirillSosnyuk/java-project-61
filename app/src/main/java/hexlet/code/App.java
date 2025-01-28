package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.*;


public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String MENU_TEXT = """
            
            Please enter the game number and press Enter:
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            0 - Exit
            """;

    public static void main(String[] args) {
        while (true) {
            String userChoice = getUserChoice();
            System.out.println();
            if (userChoice.equals("0")) {
                System.out.println("Goodbye!");
                SCANNER.close();
                break;
            }

            switch (userChoice) {
                case "1" -> Greet.greeting(SCANNER);
                case "2" -> Even.evenGame(SCANNER);
                case "3" -> Calc.calcGame(SCANNER);
                case "4" -> Gcd.gcdGame(SCANNER);
                default -> System.out.println("Invalid choice. Please try again.");
            }

        }
    }
    private static String getUserChoice() {
        System.out.println(MENU_TEXT);
        System.out.print("Your choice: ");
        return SCANNER.nextLine();
    }
}





