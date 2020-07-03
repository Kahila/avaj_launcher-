package simulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Logger {
	
	public void writeToFile(String path, String msg) {
		File file = new File(path);
		PrintWriter txtout = null;
		
		try {
			txtout = new PrintWriter(file);
			txtout.println(msg);
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			if (txtout != null) txtout.close();
		}
	}
}
