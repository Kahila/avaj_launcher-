/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Main
 * */
package simulator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import simulator.vehicles.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends AircraftFactory{

	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height); 
		JetPlane jetPlane = null;
		Baloon baloon = null;
		Helicopter helicopter = null;
		
		if (type.equals("JetPlane"))
		{
			jetPlane = new JetPlane(name, coordinates);
			return (jetPlane);
		}
		else if (type.equals("Helicopter")) {
			helicopter = new Helicopter(name, coordinates);
			return (helicopter);
		}
		else if	(type.equals("Baloon")) {
			baloon = new Baloon(name, coordinates);
			return (baloon);
		}
		System.out.println("Error found in file");
		System.exit(-1);
		return (null);
	}
	
	public static void main(String[] args) throws IOException{
		
		  if (args.length == 0 || args.length > 1)
	       {
	            System.out.println("no file parsed");
	            System.exit(-1);
	       }
		
		try {
			File myobj = new File(args[0]);
			File newFile = new File("../simulation.txt");
			int repetition = 0;
			
			if (newFile.createNewFile()) {
				System.out.printf("File has been created\n");
			}else {
				System.out.println("file exists");
			}
			
			WeatherTower tower = new WeatherTower();
			Scanner myReader = new Scanner(myobj);
			int i = 0;
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String str[] = data.split("\t+| ");
				int height = 0, longitude = 0, latitude = 0;
				String name = "";
				if (str.length != 5 && i != 0) {
					System.out.printf("amount of value passed are incorrect\n", i+1);
					System.exit(-1);
				}
				if (i!=0)
				{
					try
					{
						if (Integer.parseInt(str[2]) < 0 || Integer.parseInt(str[3]) < 0 || Integer.parseInt(str[4]) < 0) {
							System.out.printf("Invalid coordinates: below 0\n");
							System.exit(-1);
						}
					}catch(IllegalArgumentException pe) {
						System.out.printf("invalid input found");
						System.exit(-1);
					}
					
					name = str[1];
					longitude = Integer.parseInt(str[2]);
					latitude = Integer.parseInt(str[3]);
					height = Integer.parseInt(str[4]);
					tower.reg(new Main().newAircraft(str[0], name, longitude, latitude, height));					
				}else {
					Pattern pattern = Pattern.compile("[0-9]+");
					Matcher matcher = pattern.matcher(data);
					if (matcher.matches()) {;
						repetition = Integer.parseInt(data);
					}else {
						System.out.printf("invalid line found");
						System.exit(-1);
					}
				}
				i++;
			}
			i = 0;
			while (i < repetition)
			{
				tower.changeWeather();
				i++;
			}
			myReader.close();
			Logger.closeFile();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}	
	}

}
