/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 5
 * Due date : 07/27/17
 * Date Submitted : 07/28/17
 */
package lab7;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * This Student class provides api to display the side of the coin facing up at a random order
 * Limitations : Number of students should not exceed 40
 *
 */
public class Student {
	static final int MAX_QUIZ = 10;
	static final int MAX_QUIZ_PER_SUB = 5;
	static final int MAX_SUBJ = 2;
	private int SID;
	private int scores[][];

	Student() {
		scores = new int[MAX_SUBJ][MAX_QUIZ];
	}

	void writeData(String fileName, String statsSubj1, String statsSubj2) throws IOException {
		StreamWriter streamWriter = new StreamWriter(fileName);
		streamWriter.initialize();
		String subject = "CHEM"; 
		streamWriter.writeLine(getScoreLine(subject));
		streamWriter.writeLine("\n");
		streamWriter.writeLine(statsSubj1);
		//second subject
		subject = "COMP"; 
		streamWriter.writeLine(getScoreLine(subject));
		streamWriter.writeLine("\n");
		streamWriter.writeLine(statsSubj2);

		streamWriter.unInitialize();
		printData(fileName);
	}

	void printData(String fileName) throws IOException {
		if (Globals.debug) {
			StreamReader streamReader = new StreamReader(fileName);
			streamReader.initialize();								
			String line;
			System.out.printf("Data from stream file for Student[id=%s] :  \n\n", SID);
			do {				   	 		
				line = streamReader.readLine();
				if (line != null)
					System.out.println(line);
			} while (line != null);		
		}
	}

	String getScoreLine (String subId) {
		String line = "";
		int subIdx = 0;
		if (subId.equals("CHEM")) {
			line = "CHEM Scores =\t\t";			
		} else if (subId.equals("COMP")) {
			line = "\n\nCOMP Scores =\t\t";
			subIdx = 1;
		}					
		for (int i =0; i < MAX_QUIZ_PER_SUB; i++) 
			line = line + scores[subIdx][i] + "\t";

		return line;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public int[][] getScores() {
		return scores;
	}

	public void setScores(int scores[][]) {
		this.scores = scores;
	}

	public void fillStudentData(String storeData) {
		StringTokenizer tokens = new StringTokenizer(storeData);
		String qScore;
		int qScoreVal;		 
		int[][] qScoreArray = new int[MAX_SUBJ][MAX_QUIZ_PER_SUB];

		int subjIdx = 0;
		int quizIndex = 0;
		while (tokens.hasMoreTokens()) {
			SID = Integer.parseInt(tokens.nextToken());
			for(int q=1; q<=MAX_QUIZ; q++){
				quizIndex = q;
				if (q > 5) {
					subjIdx = 1;
					quizIndex = quizIndex -5;
				}
				qScore = tokens.nextToken();
				qScoreVal = Integer.parseInt(qScore) ;
				qScoreArray[subjIdx][quizIndex-1] = qScoreVal;
				setScores(qScoreArray);
			}
		}
		if (Globals.debug) {
			System.out.printf("Student[id=%s][CHEM]Data=%s \n", SID, Arrays.toString(qScoreArray[0]));
			System.out.printf("Student[id=%s][COMP]Data=%s \n", SID, Arrays.toString(qScoreArray[1]));
		}
	}
}

