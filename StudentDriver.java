/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 6
 * Due date : 08/03/17
 * Date Submitted : 08/03/17
 */
package lab7;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * This Student class provides api to display the side of the coin facing up at a random order
 * Limitations : Number of students should not exceed 40
 *
 */

public class StudentDriver {

	public static void main(String[] args) throws IOException {
		final String  DATA_FILE = "/Users/parul/Documents/workspace/DeAnzaNew/Assignment7/lab7/StudentData.txt";
		final String  STUDENT_FILE = "/Users/parul/Documents/workspace/DeAnzaNew/Assignment7/lab7/Student.txt";
		StudentReaderUtil studentUtil = new StudentReaderUtil();
		studentUtil.fillStudentData(DATA_FILE);
		
		String statsDataChem = studentUtil.getStudentStats(0); //0 : CHEM
		String statsDataComp = studentUtil.getStudentStats(1); //1 : COMP

		Scanner in = new Scanner(System.in);
		System.out.printf("Enter the student id :");
		int id = in.nextInt();
		Student student = studentUtil.getStudent(id);
		student.writeData(STUDENT_FILE, statsDataChem, statsDataComp);
		in.close();
	}

}
