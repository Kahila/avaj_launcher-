/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Baloon
 * */

package simulator.vehicles;

import simulator.WeatherTower;
import simulator.vehicles.Coordinates;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates) {
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
