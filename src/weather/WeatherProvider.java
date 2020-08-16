package weather;

public class WeatherProvider {
	private static WeatherProvider weatherprovider=null;
	private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
	
	private WeatherProvider() {}
	
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
