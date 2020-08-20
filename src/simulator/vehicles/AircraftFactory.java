/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename AircraftFactory
 * */

package simulator.vehicles;

public abstract class AircraftFactory {
	public abstract Flyable newAircraft(String type, String name, int longitude, int latitude, int height);
}
