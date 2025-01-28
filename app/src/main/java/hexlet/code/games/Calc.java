package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Calc {

    private static int generateNumber(int start, int end) {
        return new Random().nextInt(start, end);
    }

    public static String[] generateExpression() {

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

    public static void calcGame(Scanner scanner) {
        System.out.println("What is the result of the expression?");

        Engine.gameCycle(scanner, "Calc");

    }
}
