/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename AircraftFactory
 * */

package simulator.vehicles;
import simulator.vehicles.Coordinates;

public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height); // setting coordinates using constructor 
		JetPlane jetPlane = null;
		Baloon baloon = null;
		Helicopter helicopter = null;
		
		if (type.equals("JetPlane"))
		{
			jetPlane = new JetPlane(name, coordinates);
			return (jetPlane);
		}
		else if (type.equals("Helicopter")) {
			helicopter = new Helicopter(name, coordinates);
			return (helicopter);
		}
		else if	(type.equals("Baloon")) {
			baloon = new Baloon(name, coordinates);
			return (baloon);
		}
		System.exit(-1);
		return (null);
	}
}
