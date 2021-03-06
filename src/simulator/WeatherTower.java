/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename WeatherTower
 * */

package simulator;

import weather.WeatherProvider;
import simulator.Tower;
import simulator.vehicles.Coordinates;
import simulator.vehicles.Flyable;

public class WeatherTower extends Tower{
	
	public String getWeather(Coordinates coordinates) {
		WeatherProvider provider = WeatherProvider.getProvider();
		return (provider.getCurrentWeather(coordinates));
	}
	
	public void changeWeather() {
		this.conditionsChanged();
	}
	
	public void reg(Flyable flyable) {
		this.register(flyable);
		flyable.registerTower(this);
	}
}
