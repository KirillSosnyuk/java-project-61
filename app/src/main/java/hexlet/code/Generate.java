package hexlet.code;

import java.util.Random;

public class Generate {
    private static final int MIN_LIMIT_EVEN_GAME = 1;
    private static final int MAX_LIMIT_EVEN_GAME = 101;

    private static final int MIN_LIMIT_CALC_GAME = 1;
    private static final int MAX_LIMIT_MULTIPLY_CALC_GAME = 16;
    private static final int MAX_LIMIT_SUM_CALC_GAME = 101;
    private static final int MAX_LIMIT_REDUCE_CALC_GAME = 101;

    private static final int MIN_LIMIT_GCD_GAME = 5;
    private static final int MAX_LIMIT_GCD_GAME = 31;
    private static final int MIN_DIVISOR_GCD_GAME = 2;
    private static final int MAX_DIVISOR_GCD_GAME = 7;

    private static final int MIN_LIMIT_PROGRESSION_GAME = 2;
    private static final int MAX_LIMIT_PROGRESSION_GAME = 71;
    private static final int MIN_LIMIT_DELTA_PROGRESSION_GAME = 5;
    private static final int MAX_LIMIT_DELTA_PROGRESSION_GAME = 17;

    private static final int MIN_LIMIT_PRIME_GAME = 2;
    private static final int MAX_LIMIT_PRIME_GAME = 501;


    public static int generateNumber(int start, int end) {
        return new Random().nextInt(start, end);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static String[] generateEvenNumber() {
        int generatedNumber = generateNumber(MIN_LIMIT_EVEN_GAME, MAX_LIMIT_EVEN_GAME);
        return new String[]{String.valueOf(generatedNumber), generatedNumber % 2 == 0 ? "yes" : "no"};
    }

    public static String[] generateGcdNumbers() {
        int divisor = Generate.generateNumber(MIN_DIVISOR_GCD_GAME, MAX_DIVISOR_GCD_GAME);
        int firstNumber = Generate.generateNumber(MIN_LIMIT_GCD_GAME, MAX_LIMIT_GCD_GAME);
        int secondNumber = Generate.generateNumber(MIN_LIMIT_GCD_GAME, MAX_LIMIT_GCD_GAME) * divisor;
        return new String[]{firstNumber + " " + secondNumber, String.valueOf(gcd(firstNumber, secondNumber))};
    }

    public static String[] generateExpression() {

        String sign = new String[]{"+", "-", "*"}[generateNumber(0, 3)];
        int firstNumber;
        int secondNumber;
        String fullExpression;

        String[] result;
        result = switch (sign) {
            case "*" -> {
                firstNumber = generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_MULTIPLY_CALC_GAME);
                secondNumber = generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_MULTIPLY_CALC_GAME);
                fullExpression = firstNumber + " * " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber * secondNumber)};
            }
            case "+" -> {
                firstNumber = generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_SUM_CALC_GAME);
                secondNumber = generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_SUM_CALC_GAME);
                fullExpression = firstNumber + " + " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber + secondNumber)};
            }
            case "-" -> {
                firstNumber = generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_REDUCE_CALC_GAME);
                secondNumber = generateNumber(MIN_LIMIT_CALC_GAME, MAX_LIMIT_REDUCE_CALC_GAME);
                fullExpression = firstNumber + " - " + secondNumber;
                yield new String[]{fullExpression, String.valueOf(firstNumber - secondNumber)};
            }
            default -> throw new IllegalStateException("Unknown error while generating expression");
        };
        return result;
    }

    public static String[] generateProgression() {
        String[] progression = new String[10];
        int delta = Generate.generateNumber(MIN_LIMIT_DELTA_PROGRESSION_GAME,
                MAX_LIMIT_DELTA_PROGRESSION_GAME) * new int[]{-1, 1}[(int) Math.round(Math.random())];
        int startingNumber = Generate.generateNumber(MIN_LIMIT_PROGRESSION_GAME, MAX_LIMIT_PROGRESSION_GAME);
        int randomIndex = Generate.generateNumber(0, 10);
        int i = 0;

        while (i < progression.length) {
            progression[i] = i != randomIndex ? String.valueOf(startingNumber + (i * delta)) : "..";
            i++;
        }
        return new String[]{String.join(" ", progression),
                String.valueOf(startingNumber + (randomIndex * delta))};
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String[] generatePrimeNumber() {
        int generatedNumber = generateNumber(MIN_LIMIT_PRIME_GAME, MAX_LIMIT_PRIME_GAME);
        return new String[]{String.valueOf(generatedNumber), isPrime(generatedNumber) ? "yes" : "no"};
    }
}
