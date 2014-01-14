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
 * This java example will demonstrate how to 
 * check if a file is a normal file.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/determine-if-file-is-a-normal-file/'>Is file a directory</a>
 */
public class IsFile {

	private static final String SOURCE = "com/levelup/java/io/is-regular-file.txt";
	
	Path source;
	
	@Before
	public void setUp() throws IOException, URISyntaxException {

		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE)
				.toURI());
	}
	
	@Test
	public void file_is_regular_file_java () {
		
		File file = source.toFile();
		
		boolean isRegularFile = file.isFile();
		
		assertTrue(isRegularFile);
	}
	
	@Test
	public void file_is_regular_file_nio() throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source,
				BasicFileAttributes.class);

		boolean isRegularFileWithOpaqueContent = attr.isRegularFile();

		assertTrue(isRegularFileWithOpaqueContent);
	}

	@Test
	public void file_is_regular_file_nio_files () throws IOException {
		
		boolean isRegularFile = Files.isRegularFile(source);
		
		assertTrue(isRegularFile);
	}

}
