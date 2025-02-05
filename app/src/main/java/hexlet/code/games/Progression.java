package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Progression {

    private static final int  PROGRESSION_LENGTH = 10;
    private static final int MIN_LIMIT_PROGRESSION_GAME = 2;
    private static final int MAX_LIMIT_PROGRESSION_GAME = 71;
    private static final int MIN_LIMIT_DELTA_PROGRESSION_GAME = 5;
    private static final int MAX_LIMIT_DELTA_PROGRESSION_GAME = 17;

    public static String[] generateProgression() {
        String[] progression = new String[PROGRESSION_LENGTH];
        int delta = Engine.generateNumber(MIN_LIMIT_DELTA_PROGRESSION_GAME,
                MAX_LIMIT_DELTA_PROGRESSION_GAME) * new int[]{-1, 1}[(int) Math.round(Math.random())];
        int startingNumber = Engine.generateNumber(MIN_LIMIT_PROGRESSION_GAME, MAX_LIMIT_PROGRESSION_GAME);
        int randomIndex = Engine.generateNumber(0, PROGRESSION_LENGTH);
        int i = 0;

        while (i < progression.length) {
            progression[i] = i != randomIndex ? String.valueOf(startingNumber + (i * delta)) : "..";
            i++;
        }
        return new String[]{String.join(" ", progression),
                String.valueOf(startingNumber + (randomIndex * delta))};
    }
    public static void progressionGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("What number is missing in the progression?");

        Engine.gameCycle(scanner, userName, "Progression");
    }


}
