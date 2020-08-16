/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Tower
 * */

package simulator;

import simulator.vehicles.Flyable;
import simulator.vehicles.JetPlane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import 

public class Tower{
	private Flyable observers[];
	
	public void register(Flyable flyable) {//register all the observers that need to know of changes
		try {
			File myobj = new File("D:\\workstation\\avaj_launchar\\txt/data.txt");
			Scanner myReader = new Scanner(myobj);
			int i = 0;
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String str[] = data.split(" ");
				if (i!=0)
				{
					observers[i] = flyable;
					System.out.println("Tower says: "+str[0]+ "#" + str[1]+"("+i+") registered to weather tower.");
				}
				i++;
			}
			myReader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("something broken cuz");
		}
	}

	public void unregister(Flyable flyable) {//remove all the observers that don't want to know changes
		flyable = null;
	}
	
	protected void conditionsChanged() {//notify all observers of changes made
		
	}
}
