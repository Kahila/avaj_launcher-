/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename JetPlane
 * */

package simulator.vehicles;

import simulator.WeatherTower;
import simulator.vehicles.Coordinates;

public class JetPlane extends Aircraft implements Flyable{

	WeatherTower weatherTower;
	
	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	@Override
	public void updateCondition() {
		weatherTower.changeWeather();
	}
	
	@Override
	public void registerTower(WeatherTower weatherTower) {
	
	}
}
