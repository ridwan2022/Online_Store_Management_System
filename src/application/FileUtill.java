package application;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtill {
	 public static void saveToFile(String fileName, String data) {
	        try {
	            FileWriter writer = new FileWriter(fileName, true); // true = append mode
	            writer.write(data + System.lineSeparator());
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
