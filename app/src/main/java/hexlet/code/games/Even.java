package hexlet.code.games;


import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Even {

    public static int generateNumber(int start, int end) {
        return new Random().nextInt(start, end);
    }

    public static void evenGame(Scanner scanner) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Engine.gameCycle(scanner, "Even");

    }
}
