package com.levelup.java.io;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how 
 * to check if a file is hidden.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/check-if-file-is-hidden/'>Check if file is hidden</a>
 * 
 */
public class CheckIfFileIsHidden {

	private static final Logger logger = Logger.getLogger(CheckIfFileIsHidden.class);

	private static final String SOURCE = "com/levelup/java/io/file-is-hidden.txt";
	
	Path source;
	
	@Before
	public void setUp () throws IOException, URISyntaxException {
	
		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE).toURI());	
	}

	
	/**
	 * Tests whether the file named by this abstract pathname 
	 * is a hidden file. The exact definition of hidden 
	 * is system-dependent. On UNIX systems, a file is 
	 * considered to be hidden if its name begins 
	 * with a period character ('.'). On Microsoft 
	 * Windows systems, a file is considered to be 
	 * hidden if it has been marked as such in the filesystem.
	 */
	@Test
	public void check_if_file_is_hidden_java () {
		
		File file = source.toFile();

		if (file.isHidden()) {
			logger.info("File is hidden");
		} else {
			logger.info("File not hidden");
		}
	}
	
	@Test
	public void check_if_file_is_hidden_nio () throws IOException {
		
		boolean isHidden = Files.isHidden(source);
		
		assertFalse(isHidden);
	}
}
