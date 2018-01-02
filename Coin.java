/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 2
 * Due date : 07/14/17
 * Date Submitted : 07/14/17
 */
import java.util.Random;
/**
 * 
 * This Coin class provides api to display the side of the coin facing up at a random order
 * Limitations : Number of tosses should not exceed 20
 *
 */
public class Coin {
	private String[] sideupOptions = {"heads", "tails"}; 
	private String sideup;

	/**
	 * Randomly determines the side of the coin
	 *
	 * @param no parameter
	 * @return void
	 */
	public Coin() {
		sideup = getRandomOptions(sideupOptions);
	}


	/**
	 * Uses loop to toss the coin 20 times and displays the side of the coin facing up
	 *
	 * @param no parameter
	 * @return void
	 */
	public void toss() {
		this.sideup = this.getRandomOptions(sideupOptions);
	}

	/**
	 * Returns the sideup field
	 *
	 * @param no parameter
	 * @return sideup String
	 */
	public String getSideup() {
		return this.sideup;
	}	

	/**
	 * Gets random value for sideup which should be randomly taken from the values stored in the array sideupVal
	 * 
	 * @param Array of String to provide input for random options
	 * @return random string value for sideup
	 */
	private String getRandomOptions(String []options) {
		Random random = new Random();
		int index = random.nextInt(options.length);
		return options[index];
	}	
}
