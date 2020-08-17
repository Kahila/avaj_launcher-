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
		String observer = "Baloon#"+ this.name +"("+ this.id+"): ";
		String weather = this.weatherTower.getWeather(this.coordinates); 
		if (weather == "RAIN") {
			System.out.printf("%sThe heavens are crying\n", observer);
			if ((this.coordinates.getHeight()) <= 0) {
				System.out.printf("%slanding\n", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude()+5, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}else if (weather == "SNOW") {
			System.out.printf("%sI wasn't made for winter!!\n", observer);
			if ((this.coordinates.getHeight() - 12) <= 0) {
				System.out.printf("%slanding\n", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-12);
		}else if (weather == "FOG") {
			System.out.printf("%sCan't see anything\n", observer);
			if ((this.coordinates.getHeight()) <= 0) {
				System.out.printf("%slanding\n", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude()+1, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}else if (weather == "SUN") {
			System.out.printf("%sThe sun is killing my eyes\n", observer);
			if ((this.coordinates.getHeight()+2) <= 0) {
				System.out.printf("%slanding\n", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude()+10, this.coordinates.getLatitude(), this.coordinates.getHeight()+2);
		}
	}
	
	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
	
}
