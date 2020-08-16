
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Main
 * */

import java.util.Scanner;
import simulator.vehicles.*;
import simulator.WeatherTower;
//import simulator.vehicles.Aircraft;
//import simulator.vehicles.Helicopter;

public class Main {

	public static void main(String[] args) {
		try {
			File myobj = new File("D:\\workstation\\avaj_launchar\\txt/data.txt");
			
			WeatherTower tower = new WeatherTower();
			AircraftFactory factory = new AircraftFactory();
			
			Scanner myReader = new Scanner(myobj);
			int i = 0;
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String str[] = data.split("\t+| ");
				int height = 0, longitude = 0, latitude = 0;
				String name = "";
				if (i!=0)
				{
					name = str[1];
					longitude = Integer.parseInt(str[2]);
					latitude = Integer.parseInt(str[3]);
					height = Integer.parseInt(str[4]);
					
					tower.reg(factory.newAircraft(str[0], name, longitude, latitude, height));
					
					//System.out.println(longitude);					
				}
				i++;
			}
			while (i > 0)
			{
				tower.changeWeather();
				i--;
			}
			myReader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("something broken cuz");
		}
		
	}

}
