package hexlet.code;

import hexlet.code.games.*;
import java.util.Scanner;


public class Engine {

    private static boolean isCorrect(String userAnswer, String correctAnswer, String userName) {
        boolean right = userAnswer.equals(correctAnswer);
        if (right) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n",
                    userAnswer, correctAnswer, userName);
        }
        return right;
    }

    private static String askQuestion(Scanner scanner, String expression) {
        System.out.println("Question: " + expression);
        System.out.print("Your answer: ");
        return scanner.nextLine().trim().toLowerCase();
    }

    public static String greetUser(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");

        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");

        return userName;
    }


    private static String[] generate(String currentGame) {
        String[] generatedDigits;

        generatedDigits = switch (currentGame) {
            case "Even" -> {
                int generatedNumber = Even.generateNumber(1, 101);
                yield new String[]{String.valueOf(generatedNumber), generatedNumber % 2 == 0 ? "yes" : "no"};
            }

            case "Calc" -> Calc.generateExpression();
            case "GCD" -> Gcd.generateNumbers();

            default -> throw new IllegalStateException("Unexpected value: " + currentGame);
        };
        return generatedDigits;
    }

    public static void gameCycle(Scanner scanner,  String game) {
        String userName = greetUser(scanner);
        int questionRemained = 3;
        boolean continueGame = true;

        while (questionRemained != 0 && continueGame) {
            String[] createAnswer = generate(game);

            String userAnswer = askQuestion(scanner, createAnswer[0]);

            continueGame = isCorrect(userAnswer, createAnswer[1], userName);
            questionRemained--;

        }
        if (continueGame) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
