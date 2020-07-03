package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

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
		weatherTower = new WeatherTower();
		this.name = weatherTower.getWeatherCoordinates(coordinates);
		
		System.out.printf("Tower says: Baloon#B1(1) registered to weather tower.");
	}
}
