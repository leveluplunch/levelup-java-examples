package com.levelup.java.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileSystemUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to 
 * get free space on disk.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-available-space/'>Get available space</a>
 */
public class GetAvailableSpace {

	private static final String SOURCE = "com/levelup/java/io/get-free-space.txt";
	
	Path source;
	
	@Before
	public void setUp () throws IOException, URISyntaxException {
	
		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE).toURI());	
	}
	
	@Test
	public void get_available_space () {
		
		File file = source.toFile();
		
		long freeSpace = file.getFreeSpace();
		
		assertTrue(freeSpace > 0);
	}
	
	@Test
	public void get_available_space_nio () throws IOException {
	
		FileStore store = Files.getFileStore(source);

		long availableSpace = store.getUsableSpace() / 1024;
		
		assertTrue(availableSpace > 0);
	}

	@Test
	public void get_available_space_apache_commons () throws IOException {
		
		long freeSpace = FileSystemUtils.freeSpaceKb("/");
		
		assertTrue(freeSpace > 0);
	}
	
	
}
