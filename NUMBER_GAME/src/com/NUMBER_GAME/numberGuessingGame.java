package com.NUMBER_GAME;
import java.util.Random;
import java.util.Scanner;
public class numberGuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!!!");
        System.out.println("Instructions:");
        System.out.println("1. You have to guess the correct number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("2. You have a maximum of " + maxAttempts + " attempts in each round.");
        System.out.println("3. Your score is based on the number of attempts taken. The faster you guess, the higher your score!");
        System.out.println("4. Have fun!");

        do {
        	// Generate a random target number for each round
        	int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int roundScore = 0;
            boolean correctGuess = false;

            // Display round information
            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

         // Allow the user to guess until they reach the maximum attempts or guess correctly
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

             // Displaying a message for a correct guess and calculate round score
                if (userGuess == targetNumber) {
                    System.out.println("Well done! You have guessed the correct number in " + attempts + " attempts.");
                    roundScore = calculateScore(attempts);
                    totalScore += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    correctGuess = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // Display a message if the user did not guess correctly within the maximum attempts
            if (!correctGuess && attempts == maxAttempts) {
                System.out.println("Oops! You've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            // Increment the round counter
            rounds++;

         // Asking the user if they want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();

         // Exit the game loop if the user chooses not to play another round
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

        } while (true);

     // Display the total score when the game is over
        System.out.println("\nGame is Over! Your total score is: " + totalScore);
        scanner.close();
    }

	// Method to calculate the score based on the number of attempts
    private static int calculateScore(int attempts) {
        int baseScore = 50;
        int scorePerAttempt = 10;
        int maxScore = 10;

        // Calculate the score based on the formula
        int score = Math.max(baseScore - (attempts - 1) * scorePerAttempt, maxScore);

        return score;
    }
}