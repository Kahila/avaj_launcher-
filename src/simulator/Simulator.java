package simulator;

import java.util.regex.Matcher;//rm
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;//rem

import simulator.vehicles.Aircraft;

public class Simulator {

//	private int countFlyables() {
//		int i = 0;
//		
//		return (++i);
//	}
//	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Baloon B1 2 3 20";
		Aircraft aircraft;

		Pattern pattern = Pattern.compile("[BHJ][a-z]+\\s+[BHJ][0-9]+\\s+[0-9]+\\s[0-9]+\\s[0-9]+");
		Matcher match;
//		if (match.matches())
//			System.out.printf("who Am I, not to be .\n");

		File file = new File("E:\\workstation\\avaj_launcher\\avaj.txt");
		Scanner txtin = null;
		try {
			txtin = new Scanner(file);
			int i = 0;
			while (txtin.hasNext()) {
				String line = txtin.nextLine();
				match = pattern.matcher(line);
				if (match.matches())
					System.out.printf("line %d == %s\n", i++, line);
			}
		} catch (IOException ex) {

		}
	}

}
