package hexlet.code.games;


import hexlet.code.Engine;
import java.util.Scanner;

public class Even {

    private static final int MIN_LIMIT_EVEN_GAME = 1;
    private static final int MAX_LIMIT_EVEN_GAME = 101;

    public static String[] generateEvenNumber() {
        int generatedNumber = Engine.generateNumber(MIN_LIMIT_EVEN_GAME, MAX_LIMIT_EVEN_GAME);
        return new String[]{String.valueOf(generatedNumber), generatedNumber % 2 == 0 ? "yes" : "no"};
    }
    public static void evenGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Engine.gameCycle(scanner, userName, "Even");

    }
}
