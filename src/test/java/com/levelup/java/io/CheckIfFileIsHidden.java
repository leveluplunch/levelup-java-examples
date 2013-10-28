package com.levelup.java.io;

import java.io.File;

import org.apache.log4j.Logger;
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
	public void check_if_file_exists_java () {
		
		File file = new File("/readme.md");

		if (file.isHidden()) {
			logger.info("File existed");
		} else {
			logger.info("File not found");
		}
	}
}
