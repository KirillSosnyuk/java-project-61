package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {

    private static final int OPERATORS_COUNT = 3;
    private static final int MIN_LIMIT_CALC_GAME = 1;
    private static final int MAX_LIMIT_MULTIPLY_CALC_GAME = 16;
    private static final int MAX_LIMIT_SUM_CALC_GAME = 101;
    private static final int MAX_LIMIT_REDUCE_CALC_GAME = 101;

    public static String[] generateExpression() {

        String sign = new String[]{"+", "-", "*"}[Engine.generateNumber(0, OPERATORS_COUNT)];
        int firstNumber;
        int secondNumber;
        String fullExpression;

        String[] result;
        result = switch (sign) {
            case "*" -> {
                firstNumber = Engine.generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_MULTIPLY_CALC_GAME);
                secondNumber = Engine.generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_MULTIPLY_CALC_GAME);
                fullExpression = firstNumber + " * " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber * secondNumber)};
            }
            case "+" -> {
                firstNumber = Engine.generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_SUM_CALC_GAME);
                secondNumber = Engine.generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_SUM_CALC_GAME);
                fullExpression = firstNumber + " + " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber + secondNumber)};
            }
            case "-" -> {
                firstNumber = Engine.generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_REDUCE_CALC_GAME);
                secondNumber = Engine.generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_REDUCE_CALC_GAME);
                fullExpression = firstNumber + " - " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber - secondNumber)};
            }
            default -> throw new IllegalStateException("Unknown error while generating expression");
        };
        return result;
    }

    public static void calcGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("What is the result of the expression?");

        Engine.gameCycle(scanner, userName, "Calc");

    }
}
