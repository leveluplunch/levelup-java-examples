package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to 
 * get the file creation date time.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-file-creation-date/'>Get file creation date</a>
 */
public class GetFileCreationDate {
	
	private static final String SOURCE = "com/levelup/java/io/get-file-creation-time.txt";
	
	Path source;
	
	@Before
	public void setUp () throws IOException, URISyntaxException {
	
		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE).toURI());	
	}

	/**
	 * Read further documentation to determine if your file system supports creation time.
	 * 
	 * @throws IOException
	 */
	@Test
	public void file_creation_time () throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source, BasicFileAttributes.class);

		FileTime fileCreated = attr.creationTime();
		
		assertEquals(1389290887000l, fileCreated.toMillis());
	}
	
}
