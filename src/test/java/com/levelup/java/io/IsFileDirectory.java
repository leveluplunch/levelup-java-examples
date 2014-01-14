package com.levelup.java.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to check 
 * if a file is a directory.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/determine-if-file-is-directory/'>Is file a directory</a>
 */
public class IsFileDirectory {

	private static final String SOURCE = "com/levelup/java/io";
	
	Path source;
	
	@Before
	public void setUp() throws IOException, URISyntaxException {

		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE)
				.toURI());
	}
	
	@Test
	public void file_is_directory_java () {
		
		File file = source.toFile();
		
		boolean isFileADirectory = file.isDirectory();
		
		assertTrue(isFileADirectory);	
	}
	
	@Test
	public void file_is_directory_nio() throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source,
				BasicFileAttributes.class);

		boolean isFileADirectory = attr.isDirectory();

		assertTrue(isFileADirectory);
	}
	
	@Test
	public void file_is_directory_nio_files () {
		
		boolean isFileADirectory = Files.isDirectory(source);

		assertTrue(isFileADirectory);
	}
	
}
