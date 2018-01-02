import java.util.Scanner;

public class accountDriver {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter annual interest :");
		double annualInterestRate = in.nextDouble();
		
		System.out.printf("Enter savingsBalance for account1 :");
		double savingsBalance1 = in.nextDouble();		
		System.out.printf("Enter savingsBalance for account2 :");
		double savingsBalance2 = in.nextDouble();
		
		if(annualInterestRate < 0 || annualInterestRate > 100) {
			System.out.println("Annual Interest Rate should be between 0 and 100: " );
			in.close();
			return;
		}
	
		SavingsAccount savingAccount1 = new SavingsAccount(savingsBalance1, annualInterestRate);
		SavingsAccount savingAccount2 = new SavingsAccount(savingsBalance2, annualInterestRate);

		
		double monthlyInterest1 = savingAccount1.calculateMonthlyInterest();
		double monthlyInterest2 = savingAccount2.calculateMonthlyInterest();
		System.out.println("Account1 : Monthly Interest 1 = " + monthlyInterest1 + " Balance After Interest: " + savingAccount1.newBalanceAfterInterest() + 
				"\nAccount2 Monthly Interest 2 = " + monthlyInterest2 + " Balance After Interest: " + savingAccount1.newBalanceAfterInterest());
	
		//Set interest rate to different value
		System.out.printf("Enter annual interest :");
		annualInterestRate = in.nextDouble(); 
		SavingsAccount.setAnnualInterestRate(annualInterestRate);
		
		monthlyInterest1 = savingAccount1.calculateMonthlyInterest();
		monthlyInterest2 = savingAccount2.calculateMonthlyInterest();
		System.out.println("Account1 : Monthly Interest 1=  " + monthlyInterest1 + " Balance After Interest: " + savingAccount1.newBalanceAfterInterest() + 
				"\nAccount2 Monthly Interest 2= " + monthlyInterest2 + " Balance After Interest: " + savingAccount1.newBalanceAfterInterest());
		
		
		in.close();

	}

}
