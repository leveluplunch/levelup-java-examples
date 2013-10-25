package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import com.google.common.io.Files;

/**
 * This java example will demonstrate getting the 
 * file extension.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-file-extension/'>Get file extension</a>
 * 
 */
public class GetFileExtension {
	
	private String FILE_PATH = "com/levelup/java/io/sample.log";

	@Test
	public void get_file_extension_with_java () {

		String separator = System.getProperty("file.separator");
		
		int indexOfLastSeparator = FILE_PATH.lastIndexOf(separator);
		String filename = FILE_PATH.substring(indexOfLastSeparator + 1);
		
	    int extensionIndex = filename.lastIndexOf(".");
	    String fileExtension = filename.substring(extensionIndex + 1);
	    
		assertEquals("log", fileExtension);
	}
	
	@Test
	public void get_file_extension_with_guava () {
		
		String fileExtension = Files.getFileExtension(FILE_PATH);
		assertEquals("log", fileExtension);
	}

	@Test
	public void get_file_extension_with_apache_commons () {
		
		String fileExtension = FilenameUtils.getExtension(FILE_PATH);
		assertEquals("log", fileExtension);
	}

}
