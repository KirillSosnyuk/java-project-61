package hexlet.code.games;


import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Even {

    private static int generateNumber() {
        return new Random().nextInt(1, 101);
    }

    public static String[] generateEvenNumber() {
        int generatedNumber = generateNumber();
        return new String[]{String.valueOf(generatedNumber), generatedNumber % 2 == 0 ? "yes" : "no"};
    }

    public static void evenGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Engine.gameCycle(scanner, userName,"Even");

    }
}
