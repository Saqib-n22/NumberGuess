import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGuess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char playAgain;

        do {
            int target = random.nextInt(100) + 1;
            int attempts = 0;
            final int MAX_Guesses = 7;
            boolean won = false;

            System.out.println("\n----------- (Number Guessing Game) -----------");
            System.out.println("Guess the number between 1 and 100.");
            System.out.println("You have " + MAX_Guesses + " attempts. Good luck!");

            while (attempts < MAX_Guesses && !won) {
                System.out.print("Enter your Guess: ");
                int guess;

                try {
                    guess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Enter a valid number. Try again.");
                    scanner.nextLine();
                    continue;
                }

                attempts++;

                if (guess == target) {
                    won = true;
                    System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
                } else if (guess > target) {
                    System.out.println("Too high! Attempts left: " + (MAX_Guesses - attempts));
                } else {
                    System.out.println("Too low! Attempts left: " + (MAX_Guesses - attempts));
                }
            }

            if (!won) {
                System.out.println("Out of attempts! The number was: " + target);
            }


            scanner.nextLine();
            System.out.print("Play again? (Y/N): ");
            String response = scanner.next();
            playAgain = response.isEmpty() ? 'N' : Character.toUpperCase(response.charAt(0));

        } while (playAgain == 'Y');

        System.out.println("\nThanks for playing!");
        scanner.close();
    }
}