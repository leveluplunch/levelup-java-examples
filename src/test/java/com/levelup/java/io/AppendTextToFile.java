package com.levelup.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * This java example will demonstrate appending
 * text to a file.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/append-text-to-file/'>Append text to file</a>
 * 
 */
public class AppendTextToFile {
	
	private static final Logger logger = Logger.getLogger(AppendTextToFile.class);
	
	private static final String OUTPUT_FILE_NAME = "output/AppendTextToFile.txt";

	@Test
	public void append_to_file_java () throws IOException {
		
		File file = new File(OUTPUT_FILE_NAME);
		
		FileWriter fileWriter = new FileWriter(file, true);
		fileWriter.append("Append text to file w/ java");
		fileWriter.close();
	}

	@Test
	public void append_to_file_java_7 () {
		
		try(PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new FileWriter(OUTPUT_FILE_NAME, true)
						)
				)) {
			
			out.println("Append to file w/ Java 7");
		} catch (IOException e) {
		    logger.error(e);
		}
	}
	
	@Test
	public void append_to_file_guava () throws IOException {
		
		File file = new File(OUTPUT_FILE_NAME);

		Files.append("Append text to file w/ guava", 
				file, 
				Charsets.UTF_8);
	}
	
	@Test
	public void append_to_file_apache () throws IOException {
	
		File file = new File(OUTPUT_FILE_NAME);
		
		FileUtils.writeStringToFile(
				file, 
				"Append text to file w/ apache", 
				true);
		
	}

}
