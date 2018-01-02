/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 1
 * Due date : 07/09/17
 * Date Submitted : 07/07/17
 */

import java.util.Scanner;
/**
 * 
 * This Assignment1Part1 provides api for displaying the amortization schedule for a loan
 * Limitations : Years should be greater than 0 and less than 30
 *
 */
public class Assignment1Part1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int loanAmount;
		int years;
		double interestRate;
		double monthlyInterestRate;
		double totalPayment;
		double monthlyPayment;
		
		// Enter amounts
		System.out.printf("Enter the loan amount : ");
		loanAmount = in.nextInt();
		System.out.printf("Enter the number of years : ");
		years = in.nextInt();
		System.out.printf("Enter the interest rate : ");		
		interestRate = in.nextInt();
		if(years < 0 || years > 30) {
			System.out.printf("Years should be between 0 and 30: " );
			in.close();
			return;
		}
		if(interestRate < 0 || interestRate > 20) {
			System.out.printf("interestRate should be between 0 and 20: " );
			in.close();
			return;
		}

		monthlyInterestRate = interestRate /1200;
		//Calculate the monthly payment based on the loan amortization schedule
		monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
		System.out.printf("Monthly Payment: %.2f",  monthlyPayment);
		System.out.printf("\n\n");
		
		totalPayment = monthlyPayment * 12;
		System.out.printf("Total Payment: %.2f", totalPayment );
		System.out.printf("\n\n");
		System.out.println("Payments#\tInterest\tPrincipal\tBalance\n");

		double balanceAmount = loanAmount;
		double principalAmount;
		double interestAmount;
		for (int paymentNo = 1; paymentNo <= years*12; paymentNo++) {
			interestAmount = monthlyInterestRate * balanceAmount; 
			principalAmount = monthlyPayment - interestAmount;
			balanceAmount = balanceAmount - principalAmount;		
			System.out.print(paymentNo);
			System.out.printf("\t\t");
			System.out.printf("%.2f", interestAmount);
			System.out.printf("\t\t");
			System.out.printf("%.2f", principalAmount);
			System.out.printf("\t\t");
			System.out.printf("%.2f", balanceAmount);
			System.out.printf("\n\n");
			
			in.close();
		}

	}

}
