package simulator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import simulator.Tower;
import weather.Coordinates;

public class WeatherTower extends Tower{
	
	public String getWeatherCoordinates(Coordinates coordinates) {
		File file = new File("file name");
		Scanner txtin = null;
		try {
			txtin = new Scanner(file);
//			while ()
		}catch(IOException ex){
			
		}
		//coordinates = new Coordinates();
		return("Adonis");
	}
	
	public void changeWeather() {
		
	}
}
