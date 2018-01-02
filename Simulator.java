/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 2
 * Due date : 07/14/17
 * Date Submitted : 07/14/17
 */
public class Simulator {
	public void toss() {
		int headCount = 0;
		int tailCount = 0;
		Coin coinToPlay = new Coin();
		for (int tossCount = 1 ; tossCount <= 20; tossCount++) {
			coinToPlay.toss();
			if (coinToPlay.getSideup() == "heads")
				headCount++;
			else if (coinToPlay.getSideup() == "tails")
				tailCount++;
			System.out.println("tossCount=" + tossCount + " sideup=" + coinToPlay.getSideup());
		}
		System.out.println("*****************************************");
		System.out.println("Toss result headCount=" + headCount + " tailCount=" + tailCount);
		System.out.println("*****************************************");
	}
	
	public static void main(String[] args) {
		Simulator simTest = new Simulator();
		simTest.toss(); 
	}	
}
