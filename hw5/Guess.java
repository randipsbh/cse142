import java.util.Scanner;
import java.util.Random;

public class Guess {
    private static final int MAX = 10;

    public static void main(String[] args) {
        intro();
        Scanner scan = new Scanner(System.in);
        int games = 0, totalGuesses = 0, minGuesses = Integer.MAX_VALUE;
        do {
            int guesses = play(scan);
            if (guesses < minGuesses) {
                minGuesses = guesses;
            }
            totalGuesses += guesses;
            games++;
        } while (playAgain(scan));
        report(games, totalGuesses, minGuesses);
    }

    public static void intro() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.printf("%d and will allow you to guess until\n", MAX);
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.printf("than your guess.\n");
    }

    private static int play(Scanner scan) {
        // Print header
        System.out.printf("\nI'm thinking of a number between 1 and %d...\n", MAX);
        int guessCount = 0;
        int guess = -1;
        // Pick random Number
        Random rand = new Random();
        int n = rand.nextInt(MAX) + 1;
        // Handle guesses
        while (guess != n) {
            System.out.print("Your guess? ");
            guess = scan.nextInt();
            guessCount++;
            if (guess > n) {
                System.out.println("It's lower.");
            } else if (guess < n) {
                System.out.println("It's higher.");
            }
        }
        if (guessCount == 1) {
            System.out.println("You got it right in 1 guess");
        } else {
            System.out.printf("You got it right in %d guesses\n", guessCount);
        }
        // return number of guesses
        return guessCount;
    }

    private static boolean playAgain(Scanner scan) {
        System.out.print("Do you want to play again? ");
        String ans = scan.next();
        if (ans.toLowerCase().startsWith("n")) {
            return false;
        } else if (ans.toLowerCase().startsWith("y")) {
            return true;
        }
        return true;
    }

    private static void report(int games, int totalGuesses, int minGuesses) {
        System.out.printf("\nOverall results\n");
        System.out.printf("     total games = %d\n", games);
        System.out.printf("     total guesses = %d\n", totalGuesses);
        System.out.printf("     guesses/game = %.1f\n", (1.0 * totalGuesses / games));
        System.out.printf("     best game = %d\n", minGuesses);
    }
}
