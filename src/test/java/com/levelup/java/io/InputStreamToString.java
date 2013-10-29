package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;

/**
 * This java example will demonstrate converting
 * an {@link InputStream} to a string with Straight up 
 * Java, Guava and Apache Commons.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-inputstream-to-string/'>Inputstream to String</a>
 * 
 */
public class InputStreamToString {

	private static final String FILE_PATH = "com/levelup/java/io/inputstream-to-string.txt";
	private URI fileLocation;

	@Before
	public void setUp() throws URISyntaxException {
		fileLocation = this.getClass().getClassLoader().getResource(FILE_PATH).toURI();
	}
	
	@Test
	public void convert_inputstream_to_string_java () throws IOException {
		
		File file = new File(fileLocation);

		InputStream inputStream = new FileInputStream(file);
		
        StringBuilder fileContent = new StringBuilder();

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream, Charsets.UTF_8));
		
        String line = bufferedReader.readLine();
        while (line != null){
        	fileContent.append(line);
            line = bufferedReader.readLine();
        }
        
        bufferedReader.close();
        
		assertEquals("Inputstream to string", fileContent.toString());
	}
	
	@Test
	public void convert_inputstream_to_string_java_scanner () throws FileNotFoundException {

		File file = new File(fileLocation);

		InputStream inputStream = new FileInputStream(file);

		Scanner scanner = new Scanner(inputStream);

		//only read first line
        String fileContent = scanner.nextLine();
        
        scanner.close();
        
		assertEquals("Inputstream to string", fileContent);
	}
	
	@Test
	public void convert_inputstream_to_string_guava () throws IOException {

		File file = new File(fileLocation);
		
		InputStream inputStream = new FileInputStream(file);
		
		String fileContent = CharStreams.toString(
				new InputStreamReader(inputStream, Charsets.UTF_8));
		
		Closeables.close(inputStream, false);
		
		assertEquals("Inputstream to string", fileContent);
	}
	
	@Test
	public void convert_inputstream_to_string_apache () throws IOException {

		File file = new File(fileLocation);
		InputStream inputStream = new FileInputStream(file);
		
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, Charsets.UTF_8);
		String fileContent = writer.toString();
		
		assertEquals("Inputstream to string", fileContent);
	}
	
}

