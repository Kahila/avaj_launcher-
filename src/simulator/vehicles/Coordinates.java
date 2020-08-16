/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Coordinates
 * */

package simulator.vehicles;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	
	Coordinates(int longitude, int latitude, int height){
		this.longitude = longitude;
		if (height > 100)
			this.height = 100;
		else
			this.height = height;
		this.latitude = latitude;
	}
	
	public int getLongitude() {
		return (longitude);
	}
	
	public int getLatitude() {
		return (latitude);
	}
	
	public int getHeight() {
		return (height);
	}
}
