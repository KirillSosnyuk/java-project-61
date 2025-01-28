package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Gcd {

    public static void gcdGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Find the greatest common divisor of given numbers.");

        Engine.gameCycle(scanner, userName, "GCD");

    }


}
