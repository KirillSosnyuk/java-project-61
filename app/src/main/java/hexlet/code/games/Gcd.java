package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Gcd {

    private static final int MIN_LIMIT_GCD_GAME = 5;
    private static final int MAX_LIMIT_GCD_GAME = 31;
    private static final int MIN_DIVISOR_GCD_GAME = 2;
    private static final int MAX_DIVISOR_GCD_GAME = 7;

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static String[] generateGcdNumbers() {
        int divisor = Engine.generateNumber(MIN_DIVISOR_GCD_GAME, MAX_DIVISOR_GCD_GAME);
        int firstNumber = Engine.generateNumber(MIN_LIMIT_GCD_GAME, MAX_LIMIT_GCD_GAME);
        int secondNumber = Engine.generateNumber(MIN_LIMIT_GCD_GAME, MAX_LIMIT_GCD_GAME) * divisor;
        return new String[]{firstNumber + " " + secondNumber, String.valueOf(gcd(firstNumber, secondNumber))};
    }

    public static void gcdGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Find the greatest common divisor of given numbers.");

        Engine.gameCycle(scanner, userName, "GCD");

    }


}
