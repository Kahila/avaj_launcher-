/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename JetPlane
 * */

package simulator.vehicles;

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
			System.out.printf("%sTry catching all the rain drops.\n", observer);
			if ((this.coordinates.getHeight()) <= 0) {
				System.out.printf("%slanding", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
		}else if (weather == "SNOW") {
			System.out.printf("%swe'll die from the flu :(\n", observer);
			if ((this.coordinates.getHeight() - 7) <= 0) {
				System.out.printf("%slanding", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight()-7);
		}else if (weather == "FOG") {
			System.out.printf("%sCan anyone find my face?\n", observer);
			if ((this.coordinates.getHeight()) <= 0) {
				System.out.printf("%slanding", observer);
				this.weatherTower.unregister(this);
			}else
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude()+1, this.coordinates.getHeight());
		}else if (weather == "SUN") {
			System.out.printf("%sSuch a sunny day :)\n", observer);
			if ((this.coordinates.getHeight()+2) <= 0) {
				System.out.printf("%slanding\n", observer);
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
