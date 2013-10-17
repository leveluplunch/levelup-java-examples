package com.levelup.java.io;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * This java example will demonstrate how to read a text file.
 * 
 * Effective Java Item 47: Know and use the libraries recommends using
 * library such as Google Guava or Apache Commons.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/read-text-file/'>Read text file</a>
 * 
 */
public class ReadTextFile {

	private static final Logger logger = Logger.getLogger(ReadTextFile.class);
	
	private static final String FILE_PATH = "youaremysunshine.txt";
	
	
	@Test
	public void read_file_with_bufferedreader() {

		InputStream in = this.getClass().getClassLoader().getResourceAsStream(FILE_PATH);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		List<String> lines = new ArrayList<String>();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
		
		assertTrue(lines.size() == 28);
	}
	
	@Test
	public void read_text_file_with_scanner () {
		
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(FILE_PATH);
		
		ArrayList<String> lines = new ArrayList<String>();    
		Scanner fileScanner = new Scanner(new InputStreamReader(in));

		while (fileScanner.hasNextLine()){
			lines.add(fileScanner.nextLine());
		}

		assertTrue(lines.size() == 28);
	}
	
	@Test
	public void read_text_file_with_google_guava () {

		String filePath = this.getClass().getClassLoader().getResource(FILE_PATH).getFile();

		List<String> lines = null;
		try {
			lines = Files.readLines(new File(filePath), Charsets.UTF_8);
		} catch (IOException e) {
			logger.error(e);
		}
		assertTrue(lines.size() == 28);
	}
	
	@Test
	public void read_file_with_apache_commons () {

		String filePath = this.getClass().getClassLoader().getResource(FILE_PATH).getFile();

		List<String> lines = null;
		try {
			 lines = FileUtils.readLines(new File(filePath));
		} catch (IOException e) {
			logger.error(e);
		}
		
		assertTrue(lines.size() == 28);
	}
	
	
}
