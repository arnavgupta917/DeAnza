/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 6
 * Due date : 08/03/17
 * Date Submitted : 08/03/17
 */
package lab7;

import java.util.Formatter;

/**
 * 
 * This Statistics class provides api to calculate the highest score, lowest score, and average for the Student Data
 * Limitations : Number of students should not exceed 40, and number of quarters should not exceed 5 
 *
 */
public class Statistics {
	static final int MAX_QUIZ = 5;
	static final int MAX_SUPPORTED_STUDENTS = 40;
	int [] lowScores; 
	int [] highScores;
	float [] avgScores; 
	int studentCount;
	int subjectId;
	Statistics(int numberOfStudents, int subject) {
		studentCount = numberOfStudents;
		lowScores = new int [MAX_QUIZ];
		highScores = new int [MAX_QUIZ];
		avgScores = new float [MAX_QUIZ];
		subjectId = subject; 
	}
	
	void findLow(Student [] studentArray) {

	/* This method will find the lowest score and store it in an array names lowScores. */
		int low1Val = 100;
		int low2Val = 100;
		int low3Val = 100;
		int low4Val = 100;
		int low5Val = 100;
		int studentScores[][];
		for (int i =0; i < studentCount; i++) {
			studentScores =studentArray[i].getScores();
			int q1Score = studentScores[subjectId][0];
			if (q1Score < low1Val)
				low1Val = q1Score;
			int q2Score = studentScores[subjectId][1];
			if (q2Score < low2Val)
				low2Val = q2Score;				

			int q3Score = studentScores[subjectId][2];
			if (q2Score < low3Val)
				low3Val = q3Score;				

			int q4Score = studentScores[subjectId][3];
			if (q4Score < low4Val)
				low4Val = q4Score;				

			int q5Score = studentScores[subjectId][4];
			if (q5Score < low5Val)
				low5Val = q5Score;				
		}
		lowScores[0] = low1Val;
		lowScores[1] = low2Val;
		lowScores[2] = low3Val;
		lowScores[3] = low4Val;
		lowScores[4] = low5Val;
	}

	void findHigh(Student [] studentArray) {

	/* This method will find the highest score and store it in an array names highScores. */
		int high1Val = 0;
		int high2Val = 0;
		int high3Val = 0;
		int high4Val = 0;
		int high5Val = 0;
		int studentScores[][];
		for (int i =0; i < studentCount; i++) {
			studentScores = studentArray[i].getScores();
			int q1Score = studentScores[subjectId][0];
			if (q1Score > high1Val)
				high1Val = q1Score;
			int q2Score = studentScores[subjectId][1];
			if (q2Score > high2Val)
				high2Val = q2Score;				

			int q3Score = studentScores[subjectId][2];
			if (q2Score > high3Val)
				high3Val = q3Score;				

			int q4Score = studentScores[subjectId][3];
			if (q4Score > high4Val)
				high4Val = q4Score;				

			int q5Score = studentScores[subjectId][4];
			if (q5Score > high5Val)
				high5Val = q5Score;				
		}
		highScores[0] = high1Val;
		highScores[1] = high2Val;
		highScores[2] = high3Val;
		highScores[3] = high4Val;
		highScores[4] = high5Val;
	}
	

	void findAvg(Student [] studentArray) {

	/* This method will find avg score for each quiz and store it in an array names avgScores. */
		int q1Sum = 0;
		int q2Sum = 0;
		int q3Sum = 0;
		int q4Sum = 0;
		int q5Sum = 0;
		int[][] studentScores;
		for (int i =0; i < studentCount; i++)  {
			studentScores =studentArray[i].getScores();
			q1Sum = q1Sum + studentScores[subjectId][0];
			q2Sum = q2Sum + studentScores[subjectId][1];
			q3Sum = q3Sum + studentScores[subjectId][2];
			q4Sum = q4Sum + studentScores[subjectId][3];
			q5Sum = q5Sum + studentScores[subjectId][4];
		}
		
		avgScores[0] = q1Sum /15;
		avgScores[1] = q2Sum /15;
		avgScores[2] = q3Sum /15;
		avgScores[3] = q4Sum /15;
		avgScores[4] = q5Sum /15;
		
	}

	public void findStats(Student [] a) {
		findLow(a);
		findHigh(a);
		findAvg(a);
	}
	
	public String getStats(Student [] a) {
		StringBuilder sbuf = new StringBuilder();
		Formatter fmt = new Formatter(sbuf);
		fmt.format("\nHigh Score :");
		for (int i =0; i < MAX_QUIZ; i++) {
			fmt.format("%d\t", highScores[i]);
		}
		
		fmt.format("\nLow Score : ");
		
		for (int i =0; i < MAX_QUIZ; i++) {
			fmt.format("%d\t", lowScores[i]);
		}
		
		fmt.format("\nAvg Score: \t");
		for (int i =0; i < MAX_QUIZ; i++) {
			fmt.format("%.0f\t", avgScores[i]);
		}
		String result = fmt.toString();
		fmt.close();
		return result;

	}
	
	public void printStats(Student [] a) {
		
		System.out.printf("\nHigh Score : \t");
		for (int i =0; i < MAX_QUIZ; i++) {
   	 		System.out.printf("%d\t", highScores[i]);
		}
		
		System.out.printf("\nLow Score : \t");
		for (int i =0; i < MAX_QUIZ; i++) {
   	 		System.out.printf("%d\t", lowScores[i]);
		}
		
		System.out.printf("\nAvg Score: \t");
		for (int i =0; i < MAX_QUIZ; i++) {
   	 		System.out.printf("%.2f\t", avgScores[i]);
		}
		

	}
}
