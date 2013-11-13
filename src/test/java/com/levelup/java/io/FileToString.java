package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * This java example will demonstrate reading a file into
 * a String. 
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/read-file-into-string/'>Read file into string</a>
 * 
 */
public class FileToString {

	private static final String FILE_PATH = "com/levelup/java/io/file-to-string.txt";
	private URI fileLocation;

	@Before
	public void setUp() throws URISyntaxException {
		fileLocation = this.getClass().getClassLoader().getResource(FILE_PATH).toURI();
	}
	
	@Test
	public void convert_file_to_string_java_bufferedreader () throws IOException {
		 
		File file = new File(fileLocation);

		BufferedReader br = new BufferedReader(new FileReader(file));
	    StringBuffer fileContents = new StringBuffer();
	    String line = br.readLine();
	    while (line != null)
	    {
	    	fileContents.append(line);
	        line = br.readLine();
	    }
	    
	    br.close();
	    
		assertEquals("File to string example", fileContents.toString());
	}
	
	@Test
	public void convert_file_to_string_java_scanner () throws FileNotFoundException {
		
		File file = new File(fileLocation);
		
		Scanner scanner = new Scanner(file);
		
		String fileContents = scanner.nextLine(); // only reads line
		
		scanner.close();
		
		assertEquals("File to string example", fileContents);
	}
	
	@Test
	public void convert_file_to_string_java_nio () throws IOException {
		
		Path path = Paths.get(fileLocation);
		
		List<String> file = java.nio.file.Files.readAllLines(path, Charsets.UTF_8);
		
		String fileContents = file.get(0);
		
		assertEquals("File to string example", fileContents);
	}
	
	
	@Test
	public void convert_file_to_string_guava () throws IOException {
		
		File file = new File(fileLocation);
		
		String fileContents = Files.toString(file, Charsets.UTF_8);
	
		assertEquals("File to string example", fileContents);
	}

	@Test
	public void convert_file_to_string_apache_commons () throws IOException {
		
		File file = new File(fileLocation);
		
		String fileContents = FileUtils.readFileToString(file);
		
		assertEquals("File to string example", fileContents);
	}
	
}
