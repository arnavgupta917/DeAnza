/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 4
 * Due date : 07/239/17
 * Date Submitted : 07/24/17
 */

/**
 * 
 * This SpecialSavings class provides api to display monthlyInterest and interest rate after depositing or withdrawing money from the original balance
 * Limitations : Interest Rate cannot be less than zero 
 *
 */
public class SpecialSavings extends SavingsAccount {
	private double specialSavingInterestRate;
	
	SpecialSavings(double sBalance, double interestRate) {
		super(sBalance, interestRate);	
		this.specialSavingInterestRate = interestRate;
	}

	public void setAnnualSpecialInterestRate (double aInterestRate) {
		this.specialSavingInterestRate = aInterestRate;
	}
	
	public double getAnnualSpecialInterestRate() {
		return this.specialSavingInterestRate;
	}

	
	public void deposit(double depositVal) {
		double mySavingBalance = savingBalance();
		mySavingBalance = mySavingBalance + depositVal;
		setSavingBalance(mySavingBalance);	
		if (mySavingBalance > 10000) 
			setAnnualSpecialInterestRate(10);
	}    

	public void withdraw(double depositVal) {
		double mySavingBalance = savingBalance(); 
		mySavingBalance = mySavingBalance - depositVal;
		setSavingBalance(mySavingBalance);	
		if (mySavingBalance < 10000) {
			setAnnualSpecialInterestRate(4);
		//	System.out.printf(" Withdraw interest " + getAnnualSpecialInterestRate());

		}
		//else System.out.printf(" Withdraw interest " + getAnnualSpecialInterestRate());

	}

	public double calculateMonthlyInterest() {
		double monthlyInterest;
		monthlyInterest = ((getAnnualSpecialInterestRate() * getSavingsBalance()) / (12 * 100));
		return monthlyInterest;
	}

}
