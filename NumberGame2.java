package task1;
import java.util.Scanner;
import java.util.Random;
public class NumberGame2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int min_Number = 0, max_Number=100;
		int attempts = 5;
		int round =1;
		boolean playGame =true;
		int totalScore = 0;
		System.out.println("Welcome to Guess Number Game");
		while(playGame) {
			int randomNumber = random.nextInt(max_Number-min_Number+1)+min_Number;
			boolean guessCorrectly=false;
			System.out.println("\nRound " + round + ":");
            System.out.println("I have Selected a number between " + min_Number + " and " + max_Number + ". Can you guess it?");
            System.out.println("You have " + attempts + " attempts.");
            
            while(attempts>0 && !guessCorrectly) {
            	System.out.println("Enter your guess");
            	int userGuess;
            	try {
            		userGuess = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid input. Please enter a number.");
                    sc.next();  
                    continue;
				}
            	attempts--;
            	
            	if(userGuess == randomNumber) {
            		System.out.println("Congratulations! You guessed the correct number: "+randomNumber);
                    guessCorrectly = true;
                    totalScore += attempts + 1;
            	}else if(userGuess>randomNumber) {
            		System.out.println("Number is high"+ (attempts > 0 ? " Try again." : " No attempts left."));
            		
            	}else {
            		System.out.println("Number is low! " + (attempts > 0 ? " Try again." : " No attempts left."));
            	}
            }
            if(!guessCorrectly) {
            	 System.out.println("Sorry, you're out of attempts! The correct number was: " + randomNumber);
            }
            
            System.out.println("\nWould you like to play another round? yes/no:");
            String userResponce = sc.next().toLowerCase();
            playGame = userResponce.equals("yes");
            round++;
            
			
		}
		System.out.println("Game Over! Your total score is: " + totalScore);
        sc.close();
	

	}

}
