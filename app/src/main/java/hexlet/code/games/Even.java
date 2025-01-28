package hexlet.code.games;


import hexlet.code.Engine;

import java.util.Scanner;

public class Even {
    public static void evenGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Engine.gameCycle(scanner, userName, "Even");

    }
}
