import java.util.Random;
import java.util.Scanner;

public class number{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 5; // Change this value to set the number of attempts per round
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number. Attempts left: " + (numberOfAttempts - attempts));
                } else {
                    System.out.println("Try a lower number. Attempts left: " + (numberOfAttempts - attempts));
                }
            }

            if (attempts == numberOfAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Your final score is: " + score + " rounds won.");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
