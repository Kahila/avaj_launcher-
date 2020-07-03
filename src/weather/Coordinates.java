package weather;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	
	Coordinates(int longitude, int latitude, int height){
		this.longitude = longitude;
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
