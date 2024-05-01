package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class WriteDataOnCSVFile {
	
	public static void writeDataToCSV(String fileName, List<String[]> data) {
		String filePath = "TestOutputFiles\\" + fileName;
		System.out.println("Filepath : "+filePath);
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(filePath));
			writer.writeAll(data);
			writer.flush();
		}catch(IOException e) {
	        e.printStackTrace(); 
	    } 
	}
	
	
	
	
}

