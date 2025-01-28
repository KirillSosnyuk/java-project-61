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



    private static String[] generate(String currentGame) {
        String[] generatedDigits;

        generatedDigits = switch (currentGame) {
            case "Even" -> Even.generateEvenNumber();
            case "Calc" -> Calc.generateExpression();
            case "GCD" -> Gcd.generateNumbers();
            case "Progression" -> Progression.generateProgression();
            case "Prime" -> Prime.generatePrimeNumber();

            default -> throw new IllegalStateException("Unexpected value: " + currentGame);
        };

        return generatedDigits;
    }

    public static void gameCycle(Scanner scanner, String userName, String game) {
        int questionRemained = 3;
        boolean continueGame = true;

        while (questionRemained != 0 && continueGame) {
            String[] createExpressionAndCorrectAnswer = generate(game);
            String userAnswer = askQuestion(scanner, createExpressionAndCorrectAnswer[0]);

            continueGame = isCorrect(userAnswer, createExpressionAndCorrectAnswer[1], userName);
            questionRemained--;

        }
        if (continueGame) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
