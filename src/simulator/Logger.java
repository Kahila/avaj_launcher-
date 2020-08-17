package simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	private static FileWriter fw = null;
	
	public static void writer(String str)
	{
		try {
			if (fw == null)
				fw = new FileWriter("simulation.txt");
			fw.write(str+"\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeFile() throws IOException {
		if (fw != null)
			fw.close();
	}
	
}
