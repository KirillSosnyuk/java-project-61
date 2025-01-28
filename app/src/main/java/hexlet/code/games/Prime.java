package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {

    public static void primeGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Engine.gameCycle(scanner, userName, "Prime");
    }


}
