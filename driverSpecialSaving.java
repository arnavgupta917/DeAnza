/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 4
 * Due date : 07/239/17
 * Date Submitted : 07/24/17
 */
import java.util.Scanner;

public class driverSpecialSaving {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter annual interest :");
		double annualInterestRate = in.nextDouble();
		
		System.out.printf("Enter Special Account Balance for account1 : ");
		double specialAccountBalance1 = in.nextDouble();		
		System.out.printf("Enter Special Account Balance for account2 : ");
		double specialAccountBalance2 = in.nextDouble();		
		
		if(annualInterestRate < 0 || annualInterestRate > 100) {
			System.out.println("Annual Interest Rate should be between 0 and 100: " );
			in.close();
			return;
		}
  
		SpecialSavings specialAccount1 = new SpecialSavings(specialAccountBalance1, annualInterestRate);
		SpecialSavings specialAccount2 = new SpecialSavings(specialAccountBalance2, annualInterestRate);
		
		
		SavingsAccount.setAnnualInterestRate(annualInterestRate);
		double monthlyInterest1 = specialAccount1.calculateMonthlyInterest();
		double monthlyInterest2 = specialAccount2.calculateMonthlyInterest();
		System.out.println("Monthly Interest 1= " + monthlyInterest1 + " Monthly Interest 2= " + monthlyInterest2);
		
        
			System.out.printf("Enter your deposit for Account 1: ");
			double deposit1 = in.nextDouble();
			System.out.println("");
			System.out.printf("Enter your deposit for Account 2: ");
			double deposit2 = in.nextDouble();
			System.out.println("");
			specialAccount1.deposit(deposit1);
			specialAccount2.deposit(deposit2);

			double monthlyInterest1afterDeposit = specialAccount1.calculateMonthlyInterest();
			double monthlyInterest2afterDeposit = specialAccount2.calculateMonthlyInterest();
			System.out.println("specialAccount1 balance=" + specialAccount1.savingBalance() + " InterestRate= " + specialAccount1.getAnnualSpecialInterestRate() + " InterestAfterDeposit= " + monthlyInterest1afterDeposit + 
					"\nspecialAccount2 balance=" + specialAccount2.savingBalance() + " InterestRate= " + specialAccount2.getAnnualSpecialInterestRate() + " InterestAfterDeposit= " + monthlyInterest2afterDeposit);
			System.out.println("");

			
			System.out.printf("Enter withdrawal for Account 1: ");
			double withdrawal1 = in.nextDouble();
			System.out.println("");
			System.out.printf("Enter withdrawal for Account 2: ");
			double withdrawal2 = in.nextDouble();
			System.out.println("");

			specialAccount1.withdraw(withdrawal1);
			specialAccount2.withdraw(withdrawal2);
			
			double monthlyInterest1afterWithdrawal = specialAccount1.calculateMonthlyInterest();
			double monthlyInterest2afterWithdrawal = specialAccount2.calculateMonthlyInterest();
			System.out.println("specialAccount1 balance= " + specialAccount1.savingBalance() + " InterestRate= " + specialAccount1.getAnnualSpecialInterestRate() + " InterestAfterWithdrawal= " + monthlyInterest1afterWithdrawal + 
					"\nspecialAccount2 balance= " + specialAccount2.savingBalance() + " InterestRate= " + specialAccount2.getAnnualSpecialInterestRate() + " InterestAfterWithdrawl= " + monthlyInterest2afterWithdrawal);
			System.out.println("");		
			in.close();		
	}

}
