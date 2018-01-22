/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 5
 * Due date : 07/27/17
 * Date Submitted : 07/28/17
 */
package lab7;

import java.io.IOException;
/**
 * 
 * This StudentReaderUtil class provides api to read the data of the text file
 * Limitations : Number of students should not exceed 40
 *
 */

public class StudentReaderUtil {
	static final int MAX_SUPPORTED_STUDENTS = 40;
	private Student[] students;
	int studentCount;	

	public StudentReaderUtil() {
		students = new Student[MAX_SUPPORTED_STUDENTS]; 
		students = new Student[MAX_SUPPORTED_STUDENTS];
	}

	Student getStudent(int ID) {
		for (int i=0; i < students.length - 1; i++) {
			//System.out.printf("students[%d].getSID()=%d, ID=%d\n", i , students[i].getSID(), ID);
			if (students[i].getSID() == ID)
				return students[i];
	
		}
		return null;
	}

	public String getStudentStats(int subject) {
		Statistics stats = new Statistics(studentCount, subject);
		stats.findStats(students);
		//stats.printStats(students);
		return stats.getStats(students);
	}

	public void gatherStudentHeaderLine() {

	}
	/**
	 * 
	 * Fill the Student data using the StreamReader object
	 * String filename
	 */

	public void fillStudentData(String fileName) throws IOException {
		StreamReader fio = new StreamReader(fileName);
		fio.initialize();


		//Now read file for all the stores
		String studentData;
		boolean firstLine = true;
		while ((studentData = fio.readLine()) != null) {			
			//Student store = new Student();
			if (firstLine) {
				gatherStudentHeaderLine();
				studentData = fio.readLine();
				firstLine = false;
			}

			students[studentCount] = new Student();
			/*
			if (debug)
				System.out.println("studentData=" + studentData);
			 */
			students[studentCount].fillStudentData(studentData);
			studentCount++;

		}
		fio.unInitialize();
	}
}
