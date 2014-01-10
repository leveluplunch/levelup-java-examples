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
 * This java example will demonstrate how 
 * to get used space on disk.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-used-space/'>Get used space</a>
 */
public class GetUsedSpace {

	private static final String SOURCE = "com/levelup/java/io/get-used-space.txt";
	
	Path source;
	
	@Before
	public void setUp () throws IOException, URISyntaxException {
	
		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE).toURI());	
	}

	@Test
	public void get_used_space () {
		
		File file = source.toFile();
		
		long usedSpace = (file.getTotalSpace() - file.getFreeSpace()) / 1024;
		
		assertTrue(usedSpace > 0);
	}
	
	@Test
	public void get_used_space_nio () throws IOException {

		FileStore store = Files.getFileStore(source);

		long usedSpace = (store.getTotalSpace() -
	             store.getUnallocatedSpace()) / 1024;
		
		assertTrue(usedSpace > 0);
	}

	
}
