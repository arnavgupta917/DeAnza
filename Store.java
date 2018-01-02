/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 3
 * Due date : 07/19/17
 * Date Submitted : 07/19/17
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * This Store class provides api to display specific values of the Store
 * Limitations : Number of stores should not exceed 6
 *
 */

public class Store {
	static final int MAX_SUPPORTED_WEEKS = 5;
	static final int MAX_WEEK_DAYS = 7;
	boolean debug;
	private float salesAllWeek[][];
	private float salesByWeek[];

	float totalSalesForWeek;
	float avgSalesForWeek;
	float totalSalesForAllWeeks;
	float averageWeeklySales;
	int weekWithHighestSaleAmt;
	int weekWithLowestSaleAmt;


	public Store() {
		salesAllWeek = new float[5][MAX_WEEK_DAYS];
		salesByWeek = new float[MAX_WEEK_DAYS];
		//Initialize instance variables
		totalSalesForWeek = 0;
		avgSalesForWeek = 0;
		totalSalesForAllWeeks = 0;
		averageWeeklySales = 0;
		weekWithHighestSaleAmt = 1;
		weekWithLowestSaleAmt = 1;
		debug = false;
	}
	/**
	 * For a given week, set the sale data for each weekday
	 * @param week, day, sale 
	 */
	public void setSaleData(int week, int day, float sale) {
		salesAllWeek[week][day] = sale;
	}
	
	/**
	 * 
	 * Fill the data of the values of all the stores 
	 * @param storeData
	 */
	public void fillStoreData(String storeData) throws IOException {
		StringTokenizer dayTokens = new StringTokenizer(storeData);
		
		String dayStrVal;
		float daySaleVal;
		int week = 1;
	    while (dayTokens.hasMoreTokens()) {
	         for(int day=1; day<=MAX_WEEK_DAYS; day++){
	        	 dayStrVal = dayTokens.nextToken();
	        	 daySaleVal = Float.parseFloat(dayStrVal);
	        	 salesAllWeek[week -1][day -1] =daySaleVal;
	        	 if (debug)
	        		 System.out.printf("[week=%d][day=%d]=%f ", week, day, daySaleVal);
	         }
	         week++;
	    }	    
	}
	/**
	 * 
	 * Print the data of the values of all the stores 
	 * @param storeData
	 */
	public void printStoreData() {
		for (int i = 0; i < MAX_SUPPORTED_WEEKS; i++){			
			for (int j = 0; j < MAX_WEEK_DAYS; j++){				
				System.out.print(salesAllWeek[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * 
	 * float [] getsalesforentireweek(int week)
	 * For a given week, return the array of sales for each day of that week 
	 * @param week
	 */
	private float [] getSalesForEntireWeek(int week) {
		if (debug)
			System.out.println("getSalesByWeek " + Arrays.toString(salesAllWeek[week-1]));
		return salesAllWeek[week-1];
	}

	
	/**
	 * 
	 * float getSaleForWeekday(int week, int day)
	 * @param week
	 * @param day
	 */
	public float getSaleForWeekday(int week, int day) {
		float sale = salesAllWeek[week -1][day -1];
		return sale;
	}
	
	/**
	 * 
	 * a.totalSalesForWeek
	 * For a given week, return the total of each day sale
	 * @param week
	 */
	private float totalWeeklySales(int week) {
		float totalWeeklySales =0;
		for (int day=1; day <=7; day++) {
			totalWeeklySales += salesAllWeek[week-1][day-1];
			if (debug)
				System.out.println("totalWeeklySales " + totalWeeklySales + " for " + salesAllWeek[week-1][day-1]);
		}
		if (debug)
			System.out.println("totalWeeklySales " + totalWeeklySales);
		return totalWeeklySales;
	}

	/**
	 * 
	 * b. avgsalesforweek
	 * @param week
	 */
	private float avgWeeklySales(int week) {
		float totalWeeklySales =0;
		for (int day=1; day <=7; day++) {
			totalWeeklySales += salesAllWeek[week-1][day-1];
		}
		float averageWeeklySales = totalWeeklySales /7;
		if (debug)
			System.out.println("averageWeeklySales=" + averageWeeklySales);
		return averageWeeklySales;
	}
	
	/**
	 * 
	 * c. totalsalesforallweeks
	 * @return total sales for all weeks
	 */
	private float totalSalesAllWeek() {
		float totalSales =0;
		for (int week=1; week <=MAX_SUPPORTED_WEEKS; week++) {
			totalSales += totalWeeklySales(week);
		}
		if (debug)
			System.out.println("totalSalesAllWeek " + totalSales);
		return totalSales;
	}
	

	/**
	 * 
	 * d. averageweeklysales
	 * @return the average sales for all weeks
	 */
	private float avgSalesAllWeek() {
		float totalSales = totalSalesAllWeek();
		float avgSalesForAllWeeks = totalSales /MAX_SUPPORTED_WEEKS;
		if (debug)
			System.out.println(" avgSalesForAllWeeks=" + avgSalesForAllWeeks);
		return totalSales;
	}

	/**
	 * 
	 * e. weekwithhighestsaleamt
	 * @param week
	 * @return Return the week for which highest sales happened
	 */
	private int weekWithHighestSalesAmount() {
		float  maxWeeklySales=totalWeeklySales(1);
		float  weeklySales=1;
		int maxWeek =1;
		for (int week=1; week <=MAX_SUPPORTED_WEEKS; week++) {
			weeklySales = totalWeeklySales(week);
			if (weeklySales > maxWeeklySales) {
				maxWeeklySales = weeklySales;
				maxWeek = week;
			}
		}
		if (debug)
			System.out.println(" maxWeek=" + maxWeek);
		return maxWeek;
	}
	
	
	/**
	 * 
	 * f. weekwithlowestsaleamt
	 * @param week
	 * @return Return the week for which lowest sales happened
	 */
	private int weekWithLowestSalesAmount() {
		float  lowestWeeklySales=totalWeeklySales(1);
		float  weeklySales=1;
		int lowestWeek =1;
		for (int week=1; week <=MAX_SUPPORTED_WEEKS; week++) {
			weeklySales = totalWeeklySales(week);
			if (weeklySales < lowestWeeklySales) {
				lowestWeeklySales = weeklySales;
				lowestWeek = week;
			}
		}
		if (debug)
			System.out.println("lowestWeek=" + lowestWeek);
		return lowestWeek;
	}
	
	public void analyzeResults(int week) {		
		salesByWeek = getSalesForEntireWeek(week);
		totalSalesForWeek = totalWeeklySales(week);		
		avgSalesForWeek = avgWeeklySales(week);
		totalSalesForAllWeeks = totalSalesAllWeek();
		averageWeeklySales = avgSalesAllWeek();
		weekWithHighestSaleAmt = weekWithHighestSalesAmount();
		weekWithLowestSaleAmt = weekWithLowestSalesAmount();		
	}	
	
	/**
	 * 
	 * printResults
	 * @param week
	 * @return Print the results for all the values of the store 
	 */
	public void printResults() {
		System.out.println("********* printResults for store *********");
		System.out.println("Sales For Week =" + Arrays.toString(salesByWeek));
		System.out.println("Total Sales For Week = " + totalSalesForWeek);
		System.out.println("Avg Sales For Week =" + avgSalesForWeek);
		System.out.println("Total Sales for All Weeks=" + totalSalesForAllWeeks);
		System.out.println("Average weekly sales =" + averageWeeklySales);
		System.out.println("Week With Highest Sale Amt =" + weekWithHighestSaleAmt);
		System.out.println("Week With Lowest Sale Amt =" + weekWithLowestSaleAmt);
		
	}
}


