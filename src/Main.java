
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

public class Main {

	public static void main(String[] args) {
		System.out.println("Reading file real quick0");
		try {
			File myobj = new File("D:\\workstation\\avaj_launchar\\txt/data.txt");
			Scanner myReader = new Scanner(myobj);
			int i = 0;
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String str[] = data.split(" ");
				if (i!=0)
					System.out.println("Tower says: "+str[0]+ "#" + str[1]+"("+i+") registered to weather tower.");					
				i++;
			}
			myReader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("something broken cuz");
		}
	}

}
