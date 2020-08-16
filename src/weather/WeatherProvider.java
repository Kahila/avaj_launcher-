/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename WeatherProvider
 * */

package weather;

import simulator.vehicles.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherprovider;
	private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
	
	private WeatherProvider() {
		weatherprovider = this;
	}
	
	public static WeatherProvider getProvider() {
		if (weatherprovider == null) {
			weatherprovider = new WeatherProvider();
		}
		return (weatherprovider);
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		int rand = (int)(Math.random()*(((coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude())-1)+1) + 1);
			
		if (rand%4 == 0)
			return (weather[3]);
		else if (rand%2 == 0)
			return (weather[2]);
		else if (rand%3 == 0)
			return (weather[1]);
			
		return (weather[0]);
	}
}
