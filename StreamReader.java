/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 6
 * Due date : 08/03/17
 * Date Submitted : 08/03/17
 */
package lab7;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * This StreamReader class provides api to display the data from a separate file
 *
 */
public class StreamReader extends FileIO {
	private String fname = null;

	//stores character-input stream for a file
	BufferedReader buffReader; 

	public StreamReader(String fname) {
		this.fname = fname;
		buffReader = null;
		lineCount = 0;
	}

	/**
	 * 
	 * Initialize file buffer reader to read text file
	 * @return buffReader
	 */
	public void initialize() throws FileNotFoundException {	//if invalid file then the FileNotFoundException is thrown	
		FileReader file = new FileReader(this.fname);   //construct FileReader object to be used for creating buffer reader                                            
		buffReader = new BufferedReader(file);		 //construct buffer reader to read lines from text file
	}


	/**
	 * 
	 * Read lines using buffer reader from a text file
	 * @return return a single line from a file, if it reaches the end of file then retun null
	 */
	public String readLine() throws IOException { //if file is corrupted or something IO related is wrong then IOException is thrown 
		String line = buffReader.readLine(); //read till the end of line from a text file
		lineCount++;
		return line;		//return null if it is end of file
	}

	/**
	 * 
	 * Close the file buffer reader
	 * @param week
	 */
	public void unInitialize() throws IOException {
		buffReader.close();
	}

	public boolean canRead() {
		return true;
	}
}


