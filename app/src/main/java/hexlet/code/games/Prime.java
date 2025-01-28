package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Prime {
    private static int generateNumber() {
        return new Random().nextInt(1, 1001);
    }

    public static boolean isPrime(int number) {
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
        int generatedNumber = generateNumber();
        return new String[]{String.valueOf(generatedNumber), isPrime(generatedNumber) ? "yes" : "no"};
    }

    public static void primeGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Answer 'yes' if the number is prime, otherwise answer 'no'.");

        Engine.gameCycle(scanner, userName, "Prime");
    }


}
