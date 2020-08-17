/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename JetPlane
 * */

package simulator.vehicles;

import simulator.Logger;
import simulator.WeatherTower;
import simulator.vehicles.Coordinates;

public class JetPlane extends Aircraft implements Flyable{

	WeatherTower weatherTower;
	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	@Override
	public void updateCondition() {
		String observer = "JetPlane#"+ this.name +"("+ this.id+"): ";
		String weather = this.weatherTower.getWeather(this.coordinates); 
		if (weather == "RAIN") {
			Logger.writer(observer + "Try catching all the rain drops.");
			if ((this.coordinates.getHeight()) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
		}else if (weather == "SNOW") {
			Logger.writer(observer + "we'll die from the flu :(.");
			if ((this.coordinates.getHeight() - 7) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-7);
		}else if (weather == "FOG") {
			Logger.writer(observer + "Can anyone find my face?");
			if ((this.coordinates.getHeight()) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude()+1, this.coordinates.getHeight());
		}else if (weather == "SUN") {
			Logger.writer(observer + "Such a sunny day :).");
			if ((this.coordinates.getHeight()+2) <= 0) {
				Logger.writer(observer + "landing");
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude()+10, this.coordinates.getHeight()+2);
		}
	}
	
	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}
