/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Baloon
 * */

package simulator.vehicles;

import simulator.Logger;
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
			Logger.writer(observer + "The heavens are crying.");
			if ((this.coordinates.getHeight() - 5) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-5);
		}else if (weather == "SNOW") {
			Logger.writer(observer + "I wasn't made for winter!!.");
			if ((this.coordinates.getHeight() - 15) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-15);
		}else if (weather == "FOG") {
			Logger.writer(observer + "Somnebody help I cant see my face!!.");
			if ((this.coordinates.getHeight() - 3) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-3);
		}else if (weather == "SUN") {
			Logger.writer(observer + "I think we're getting to close to the sun.");
			if ((this.coordinates.getHeight()) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}
	}
	
	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
	
}
