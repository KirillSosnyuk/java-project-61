package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {

    public static void progressionGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("What number is missing in the progression?");

        Engine.gameCycle(scanner, userName, "Progression");
    }


}
