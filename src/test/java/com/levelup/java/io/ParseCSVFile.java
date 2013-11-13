package com.levelup.java.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

/**
 * This java example will demonstrate how to read a csv file.
 * 
 * There are a few util libs for reading in csv files, a more popular 
 * one is <a href="http://opencsv.sourceforge.net/">OpenCSV</a>.   
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/read-csv-file/'>Read CSV file</a>
 * 
 */
public class ParseCSVFile {

	private static final Logger logger = Logger.getLogger(ParseCSVFile.class);
	
	@Test
	public void read_CSV_File_With_OpenCSV () {
		
		// If you are using spring, you could use a bit cleaner way Resource resource = new ClassPathResource
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("planets.csv");
		
	    try {
	    	
	    	CSVReader reader = new CSVReader(new InputStreamReader(in), '\t');
			
			List<String[]> rows = reader.readAll();
			for (int x=0; x < rows.size(); x ++) {
				
				String[] columns = rows.get(x);
				for (int y=0; y < columns.length; y++) {
					logger.info(columns[y]);
				}
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		
	}
	
}
