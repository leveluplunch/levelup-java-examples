package com.levelup.java.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to get 
 * total space on disk.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-total-space/'>Get total space</a>
 */
public class GetTotalSpace {
	
	private static final String SOURCE = "com/levelup/java/io/get-total-space.txt";
	
	Path source;
	
	@Before
	public void setUp () throws IOException, URISyntaxException {
	
		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE).toURI());	
	}

	@Test
	public void get_total_space () {
		
		File file = source.toFile();
		
		long totalSpace = file.getTotalSpace();
		
		assertTrue(totalSpace > 0);
	}

	@Test
	public void get_file_store_total_space () throws IOException {

		FileStore store = Files.getFileStore(source);

		long totalSpace = store.getTotalSpace();
		
		assertTrue(totalSpace > 0);
	}
}
