/**
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 1
 * Due date : 07/09/17
 * Date Submitted : 07/07/17
 */
import java.util.Scanner;

/**
 * 
 * This Assignment1Part2 provides api for calculating the square root for a given number
 * Limitations : Given number should be between 0 and 1000
 *
 */
public class Assignment1Part2 {

	/**
	 * 
	 * @param n for which square root needs to be calculated
	 * @return represents the square root of a given number
	 */
	public static double sqrt(long n) {
		if (n < 0 || n > 100000) {
			System.out.printf("Input should be between 0 and 100000: " );
			return n; 
		}

		double lastGuess = n/2; //Initial guess as any positive value
		double nextGuess = 0; 
		double diff = 0;
		do{
			nextGuess = (lastGuess + n/ lastGuess) / 2; //based on the Babylonian Method
			diff = lastGuess - nextGuess;
			lastGuess = nextGuess;
		} while (diff > 0.0001); //Repeating until the diff of last guess and next guess is very close (using 0.0001 as very close)

		return nextGuess;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter a number between 0 and 100000 : ");
		int number = in.nextInt();
		double sqrtResult = sqrt(number); 
		System.out.printf("%d\n\n", number);
		System.out.printf("Here is the square root of %d = %.2f", number, sqrtResult);
		System.out.printf("\n\n");
		in.close();
	}

}
