package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression {

    private static int generateNumber(int start, int end) {
        return new Random().nextInt(start, end);
    }

    public static String[] generateProgression() {
        String[] progression = new String[10];
        int delta = generateNumber(5, 17) * new int[]{-1, 1}[(int) Math.round(Math.random())];
        int startingNumber = generateNumber(2, 41);
        int randomIndex = generateNumber(0, 10);
        int i = 0;

        while (i < progression.length) {
            progression[i] = i != randomIndex ? String.valueOf(startingNumber + (i * delta)) : "..";
            i++;
        }
        return new String[]{String.join(" ", progression), String.valueOf(startingNumber + (randomIndex * delta))};
    }

    public static void progressionGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("What number is missing in the progression?");

        Engine.gameCycle(scanner, userName, "Progression");
    }


}
