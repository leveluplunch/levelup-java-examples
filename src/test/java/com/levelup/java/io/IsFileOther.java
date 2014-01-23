package com.levelup.java.io;

import static org.junit.Assert.assertFalse;

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
 * check if the file is something other than a regular file
 * directory, or symbolic link.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/is-file-other-directory-file-symbolic-link/'>Is file other</a>
 */
public class IsFileOther {

	private static final String SOURCE = "com/levelup/java/io/get-last-accessed-time.txt";
	
	Path source;
	
	@Before
	public void setUp() throws IOException, URISyntaxException {

		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE)
				.toURI());
	}
	
	@Test
	public void file_is_other () throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source, BasicFileAttributes.class);

		boolean isOtherFileType = attr.isOther();
		
		assertFalse(isOtherFileType);
	}
}
