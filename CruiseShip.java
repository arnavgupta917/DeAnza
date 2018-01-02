/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 4
 * Due date : 07/239/17
 * Date Submitted : 07/24/17
 */
public class CruiseShip extends Ship {
	/**
	 * Polymorphic method to move a ship depending on the type of ship
	 * @return void
	 */
	public void move() {
		System.out.println("Move: " + getClass().getName());
	}
	
}
