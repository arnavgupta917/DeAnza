/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 4
 * Due date : 07/239/17
 * Date Submitted : 07/24/17
 */

/**
 * 
 * This SavingsAccount class provides api to display monthlyInterest for two accounts after inputting the annual interest and balance
 * Limitations : Interest Rate cannot be less than zero
 *
 */

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	SavingsAccount(double sBalance, double interestRate) {
		setSavingsBalance(sBalance);
		annualInterestRate = interestRate;
	}
	
	/**
	 * 
	 * @return the balance of the account
	 */
	public double savingBalance() {
		return getSavingsBalance();
	}
	
	/**
	 * For a specific amount, set the savings balance of both accounts
	 * @param newBalance
	 */
	public void setSavingBalance(double newBalance) {
		setSavingsBalance(newBalance);
	}

	public static void setAnnualInterestRate (double aInterestRate) {
		annualInterestRate = aInterestRate;
	}
	
	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/**
	 * Calculate the monthly interest rate  by multiplying the balance by annualInterestRate divided by 12
	 * @return Monthly Interest
	 */
	public double calculateMonthlyInterest() {
		double monthlyInterest;
		monthlyInterest = ((annualInterestRate * getSavingsBalance()) / (12 * 100));
		return monthlyInterest;
	}
	
	/**
	 * Add/Deposit a specific amount into the balance
	 * @param Deposit Value
	 */
	public void deposit(double depositVal) {
		 setSavingsBalance(getSavingsBalance() + depositVal);
	}
	
	/**
	 * Withdraw a specific amount into the balance
	 * @param Deposit Value
	 */
	public void withdraw(double withdrawalVal) {
		setSavingsBalance(getSavingsBalance() - withdrawalVal);
	}


	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public double newBalanceAfterInterest() {
		double newBalance = savingsBalance + calculateMonthlyInterest();
		return newBalance;
	}
}
