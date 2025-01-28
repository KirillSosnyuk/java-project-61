package hexlet.code;

import java.util.Random;
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

    private static String askQuestion(String expression, Scanner scanner) {
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


    private static int generateNumber(int start, int end) {
        return new Random().nextInt(start, end);
    }

    private static String[] generateExpression() {

        String sign = new String[]{"+", "-", "*"}[generateNumber(0, 3)];
        int firstNumber;
        int secondNumber;
        String fullExpression;

        String[] result;
        result = switch (sign) {
            case "*" -> {
                firstNumber = generateNumber(1, 16);
                secondNumber = generateNumber(1, 16);
                fullExpression = firstNumber + " * " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber * secondNumber)};
            }
            case "+" -> {
                firstNumber = generateNumber(1, 101);
                secondNumber = generateNumber(1, 101);
                fullExpression = firstNumber + " + " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber + secondNumber)};
            }
            case "-" -> {
                firstNumber = generateNumber(1, 101);
                secondNumber = generateNumber(1, 101);
                fullExpression = firstNumber + " - " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber - secondNumber)};
            }
            default -> throw new IllegalStateException("Unknown error while generating expression");
        };
        return result;
    }

    private static String[] generate(String currentGame) {
        String[] generatedDigits;

        generatedDigits = switch (currentGame) {
            case "Even" -> {
                int generatedNumber = generateNumber(1, 101);
                yield new String[]{String.valueOf(generatedNumber), generatedNumber % 2 == 0 ? "yes" : "no"};
            }

            case "Calc" -> generateExpression();

            default -> throw new IllegalStateException("Unexpected value: " + currentGame);
        };
        return generatedDigits;
    }

    public static void gameCycle(Scanner scanner, String userName, String game) {

        int questionRemained = 3;
        boolean continueGame = true;

        while (questionRemained != 0 && continueGame) {
            String[] createAnswer = generate(game);

            String userAnswer = askQuestion(createAnswer[0], scanner);

            continueGame = isCorrect(userAnswer, createAnswer[1], userName);
            questionRemained--;

        }
        if (continueGame) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
