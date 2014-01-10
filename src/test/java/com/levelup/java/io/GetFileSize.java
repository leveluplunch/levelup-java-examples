package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how 
 * to get file size.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-file-size/'>Get file size</a>
 */
public class GetFileSize {

	private static final String SOURCE = "com/levelup/java/io/get-file-size.txt";
	
	Path source;
	
	@Before
	public void setUp () throws IOException, URISyntaxException {
	
		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE).toURI());	
	}
	
	@Test
	public void file_size () {

		File file = source.toFile();
		
		assertEquals(29, file.length());
	}

	@Test
	public void file_size_nio () throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source, BasicFileAttributes.class);

		long fileSize = attr.size();
		
		assertEquals(29, fileSize);
	}

	@Test
	public void file_size_apache_commons () {
		
		long fileSize = FileUtils.sizeOf(source.toFile());
		
		assertEquals(29, fileSize);
	}
	
}
