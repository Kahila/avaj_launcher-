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
		
		String observer = "Baloon#"+ this.name +"("+ this.id+"): ";
		String weather = this.weatherTower.getWeather(this.coordinates); 
		if (weather == "RAIN") {
			System.out.printf("%sThe heavens are crying", observer);
			if ((this.coordinates.getHeight() - 5) <= 0) {
				System.out.printf("%slanding", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-5);
		}else if (weather == "SNOW") {
			System.out.printf("%sI wasn't made for winter!!", observer);
			if ((this.coordinates.getHeight() - 15) <= 0) {
				System.out.printf("%slanding", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-15);
		}else if (weather == "FOG") {
			System.out.printf("%sSomnebody help I cant see my face!!", observer);
			if ((this.coordinates.getHeight() - 3) <= 0) {
				System.out.printf("%slanding", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-3);
		}else if (weather == "SUN") {
			System.out.printf("%sI think we're getting to close to the sun", observer);
			if ((this.coordinates.getHeight()) <= 0) {
				System.out.printf("%slanding", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}
	}
	
	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
	
	public long getId() {
		return (this.id);
	}
	
	public String getName() {
		return (this.name);
	}
}
