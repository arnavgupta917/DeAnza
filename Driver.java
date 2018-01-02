/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 3
 * Due date : 07/19/17
 * Date Submitted : 07/19/17
 */

import java.io.IOException; 
import java.util.Scanner;

public class Driver {
	
	private static Scanner in;

	public static void main(String[] args) throws IOException {	
		String fileName = "/Users/parul/Documents/workspace/DeAnza/Assignment3/Salesdat.txt";
		Franchise franchise = new Franchise();
		franchise.fillFranchiseStore(fileName);

		in = new Scanner(System.in);
		System.out.printf("Enter the store number :");
		int storeNumber = in.nextInt();
		if(storeNumber < 1 || storeNumber > 6) {
			System.out.printf("storeNumber should be between 1 and 6: " );
			return;
		}

		System.out.printf("\nEnter the week : ");
		int weekNumber = in.nextInt();
		if(weekNumber < 1 || weekNumber > 5) {
			System.out.printf("weekNumber should be between 1 and 5: " );
			return;
		}
		System.out.println();
	    Store store = franchise.getStore(storeNumber);
	    store.analyzeResults(weekNumber);
	    store.printResults();
		in.close();	    	
		System.out.println("\nDone Analyzing store data");

	}

}
