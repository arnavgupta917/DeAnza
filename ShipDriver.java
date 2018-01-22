/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 4
 * Due date : 07/24/17
 * Date Submitted : 07/24/17
 */
public class ShipDriver {

	public static void main(String[] args) {
		Ship ship = new Ship();
		CargoShip cargoShip = new CargoShip();
		CruiseShip cruiseShip = new CruiseShip();
		
		Ship[] arrayShip = new Ship[3];

		arrayShip[0] = ship;
		arrayShip[1] = cargoShip;
		arrayShip[2] = cruiseShip;
		
		for( int i=0; i<3; i++ ) {
			arrayShip[i].move();
		}
	}

}
