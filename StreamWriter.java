/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 6
 * Due date : 08/03/17
 * Date Submitted : 08/03/17
 */
package lab7;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * This StreamWriter class provides api to read the data from a seperate file
 *
 */

public class StreamWriter extends FileIO {
	private String fname = null;
	FileWriter writer; 

	public StreamWriter(String fname) {
		this.fname = fname;
		writer = null;
	}

	/**
	 * 
	 * Initialize the StreamWriter class by creating a new file
	 */

	public void initialize() throws IOException {
		File file = new File(this.fname);
		file.createNewFile();
		writer = new FileWriter(file);   //construct FileReader object to be used for creating buffer reader                                            
	}
	/**
	 * 
	 * Write lines of the Student Data
	 * String line
	 */
	public void writeLine(String line) throws IOException {
		writer.write(line);
		writer.flush();
	}

	public void unInitialize() throws IOException {
		writer.flush();
		writer.close();
	}

	public boolean canWrite() {
		return true;
	}

}
