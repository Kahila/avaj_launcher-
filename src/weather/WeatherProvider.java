package weather;

public class WeatherProvider {
	WeatherProvider weatherprovider;
	String weather[];
	
	public WeatherProvider getProvider() {
		return (this.weatherprovider);
	}
	
	public String[] getCurrentWeather(Coordinates coordinates) {
		return (this.weather);
	}
}
