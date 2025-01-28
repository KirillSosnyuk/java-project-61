package hexlet.code.games;


import java.util.Scanner;

public class Even {
    public static String evenGame(Scanner scanner) {
        String userName = Greet.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");


        for (int questionRemained = 3; questionRemained > 0; questionRemained--) {
            int randomNumber = (int) (Math.random() * 101);
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                return String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!",
                        userAnswer, correctAnswer, userName);
            }
        }
        return "Congratulations, " + userName + "!";
    }
}
