/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Helicopter
 * */

package simulator.vehicles;

import simulator.Logger;
import simulator.WeatherTower;
import simulator.vehicles.Flyable;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;
	
	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	@Override
	public void updateCondition() {
		String observer = "Helicopter#"+ this.name +"("+ this.id+"): ";
		String weather = this.weatherTower.getWeather(this.coordinates); 
		if (weather == "RAIN") {
			Logger.writer(observer + "The heavens are crying.");
			if ((this.coordinates.getHeight()) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude()+5, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}else if (weather == "SNOW") {
			Logger.writer(observer + "I wasn't made for winter!!.");
			if ((this.coordinates.getHeight() - 12) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-12);
		}else if (weather == "FOG") {
			Logger.writer(observer + "Can't see anything.");
			if ((this.coordinates.getHeight()) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude()+1, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}else if (weather == "SUN") {
			Logger.writer(observer + "The sun is killing my eyes.");
			if ((this.coordinates.getHeight()+2) <= 0) {
				Logger.writer(observer + "landing");
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
