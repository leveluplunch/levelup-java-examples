package com.levelup.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * This java example will demonstrate writing text to a file
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/write-to-file/'>Write to file</a>
 * 
 */
public class WriteToFile {

	private static final String FILE_PATH = "com/levelup/java/io/write-to-file.txt";
	private URI fileLocation;

	@Before
	public void setUp() throws URISyntaxException {
		fileLocation = this.getClass().getClassLoader().getResource(FILE_PATH).toURI();
	}
	
	
	@Test
	public void write_to_file_java () throws IOException {

		File file = new File(fileLocation);

        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("writing to a file");
        out.close();
	}
	
	@Test
	public void write_to_file_nio () throws IOException {
		
		Path path = Paths.get(fileLocation);
		
		java.nio.file.Files.write(path, "writing to a file".getBytes(), StandardOpenOption.WRITE);
	}
	
	
	@Test
	public void write_to_file_guava () throws IOException {
		
		File file = new File(fileLocation);

		Files.write("writing to a file", file, Charsets.UTF_8);

	}
	
	@Test
	public void write_to_file_apache () throws IOException {

		File file = new File(fileLocation);

		FileUtils.write(file, "writing to file");

	}
	
}
