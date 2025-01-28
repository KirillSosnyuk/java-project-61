package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Gcd {

    private static int generateNumber(int end) {
        return new Random().nextInt(2, end);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static String[] generateNumbers() {
        int divisor = generateNumber(11);
        int firstNumber = generateNumber(31);
        int secondNumber = generateNumber(31) * divisor;
        return new String[]{firstNumber + " " + secondNumber, String.valueOf(gcd(firstNumber, secondNumber))};
    }

    public static void gcdGame(Scanner scanner) {
        System.out.println("Find the greatest common divisor of given numbers.");

        Engine.gameCycle(scanner, "GCD");

    }


}
