/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 6
 * Due date : 08/03/17
 * Date Submitted : 08/03/17
 */
package lab7;
/**
 * 
 * This FileIO class provides api to implement the StreamIO interface
 *
 */

public abstract class FileIO implements StreamIO {
	int lineCount;

	public int getLineCount() {
		return lineCount;
	}
	
	public boolean canRead() {
		return false;
	}

	public boolean canWrite() {
		return false;
	}


}
