package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.File;
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
 * a files last modified time.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-file-last-modified-date-time/'>Get file last modified time</a>
 */
public class GetFileLastModifiedTime {

	private static final String SOURCE = "com/levelup/java/io/get-last-modified-time.txt";
	
	Path source;
	
	@Before
	public void setUp() throws IOException, URISyntaxException {

		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE)
				.toURI());
	}
	
	@Test
	public void file_last_modified_java () {
		
		File file = source.toFile();
		
		long lastModified = file.lastModified();
		
		assertEquals(1389664624000l, lastModified);

	}
	
	@Test
	public void file_last_modified_nio() throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source,
				BasicFileAttributes.class);

		FileTime lastModified = attr.lastModifiedTime();

		assertEquals(1389664624000l, lastModified.toMillis());
	}

}
