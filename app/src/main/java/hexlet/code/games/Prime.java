package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Prime {

    private static final int MIN_LIMIT_PRIME_GAME = 2;
    private static final int MAX_LIMIT_PRIME_GAME = 501;

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
        int generatedNumber = Engine.generateNumber(MIN_LIMIT_PRIME_GAME, MAX_LIMIT_PRIME_GAME);
        generatedNumber += generatedNumber % 2 == 0 ? 1 : 0;
        return new String[]{String.valueOf(generatedNumber), isPrime(generatedNumber) ? "yes" : "no"};
    }

    public static void primeGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Engine.gameCycle(scanner, userName, "Prime");
    }


}
