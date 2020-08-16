/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Helicopter
 * */

package simulator.vehicles;

import simulator.WeatherTower;
import simulator.vehicles.Flyable;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;
	
	public Helicopter(String name, Coordinates coordinates) {
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
