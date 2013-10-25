package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import com.google.common.io.Files;

/**
 * This java example will demonstrate get file
 * name without extension.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-file-name-without-extension/'>Get file name without extension</a>
 * 
 */
public class GetFileNameWithoutExtension {

	private String FILE_PATH = "com/levelup/java/io/sample.md";
	
	@Test
	public void get_file_name_with_out_extension_java () {
		
		String separator = System.getProperty("file.separator");
		
		int indexOfLastSeparator = FILE_PATH.lastIndexOf(separator);
		String filename = FILE_PATH.substring(indexOfLastSeparator + 1);
		
	    int extensionIndex = filename.lastIndexOf(".");
	    String fileExtension = filename.substring(0, extensionIndex);
	    
		assertEquals("sample", fileExtension);
	}
	
	@Test
	public void get_file_name_with_out_extension_guava () {
		
		String fileName = Files.getNameWithoutExtension(FILE_PATH);
		assertEquals("sample", fileName);
	}

	@Test
	public void get_file_name_with_out_extension_apache () {

		String fileName = FilenameUtils.getBaseName(FILE_PATH);
		assertEquals("sample", fileName);
	}
	
}
