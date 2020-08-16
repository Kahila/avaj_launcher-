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

public class WeatherTower extends Tower{
	
	public String getWeather(Coordinates coordinates) { //this method will be used to generate weather
		WeatherProvider provider = null;
		
		provider.getProvider();
		return (provider.getCurrentWeather(coordinates));
	}
	
	public void changeWeather() {//update the state and call conditionChanged method to update the condition
		
	}
}
