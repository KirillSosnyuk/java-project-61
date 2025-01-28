package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {

    public static void calcGame(Scanner scanner) {
        String userName = Engine.greetUser(scanner);
        System.out.println("What is the result of the expression?");

        Engine.gameCycle(scanner, userName, "Calc");

    }
}
