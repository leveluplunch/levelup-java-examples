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
 * This java example will demonstrate how to get
 * the files last access time.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-file-last-accessed-time/'>Get file last accessed time</a>
 */
public class GetFileLastAccessTime {

	private static final String SOURCE = "com/levelup/java/io/get-last-accessed-time.txt";
	
	Path source;
	
	@Before
	public void setUp() throws IOException, URISyntaxException {

		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE)
				.toURI());
	}
	
	@Test
	public void file_last_accessed_time_nio () throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source, BasicFileAttributes.class);

		FileTime lastAccessed = attr.lastAccessTime();
		
		assertEquals(1390446166000l, lastAccessed.toMillis());
	}
	
}
