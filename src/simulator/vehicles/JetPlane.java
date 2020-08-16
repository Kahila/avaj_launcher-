package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

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
