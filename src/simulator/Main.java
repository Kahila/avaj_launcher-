package simulator;

/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Main
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import simulator.vehicles.*;
import simulator.WeatherTower;
import simulator.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
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
