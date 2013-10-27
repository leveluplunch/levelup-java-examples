package com.levelup.java.io;

import java.io.File;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This example will demonstrate how to
 * check if a file exists in java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/check-if-file-exists/'>Check if file exists</a>
 * 
 */
public class CheckIfFileExists {
	
	private static final Logger logger = Logger.getLogger(CheckIfFileExists.class);

	@Test
	public void check_if_file_exists_java () {
		
		File file = new File("/readme.md");

		if (file.exists()) {
			logger.info("File existed");
		} else {
			logger.info("File not found");
		}
	}

}
