package com.levelup.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Files;

/**
 * This java example will demonstrate writing 
 * a byte array to a file using java, google guava, apache commons.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/write-byte-array-to-file/'>Write byte array to file</a>
 * 
 */
public class ByteArrayToFile {
	
	private byte[] fileAsByteArray = {
			70, 105, 108, 101, 32, 
			116, 111, 32, 98, 121, 
			116, 101, 32, 97, 114, 
			114, 97, 121};
	
	private static final String OUTPUT_FILE_NAME = "output/ByteArrayToFile.txt";

	@Before
	public void setUp () throws IOException {
		
		// create new empty file
		File file = new File(OUTPUT_FILE_NAME);
		
		Files.createParentDirs(file);
		
		file.createNewFile();
	}
	
	@Test
	public void convert_byte_array_to_file_java () throws IOException {
		
		FileOutputStream fos = new FileOutputStream(OUTPUT_FILE_NAME);
		fos.write(fileAsByteArray);
		fos.close();
	}

	@Test
	public void convert_byte_array_to_file_java_nio () throws URISyntaxException, IOException {
	
		Path path = Paths.get(OUTPUT_FILE_NAME);
		
		java.nio.file.Files.write(path, fileAsByteArray);
	}

	
	@Test
	public void convert_byte_array_to_file_guava () throws IOException {
		
		File fileToWriteTo = new File(OUTPUT_FILE_NAME);
		
		Files.write(fileAsByteArray, fileToWriteTo);
	}

	@Test
	public void convert_byte_array_to_file_apache_ioutils () throws IOException {
		
		File fileToWriteTo = new File(OUTPUT_FILE_NAME);
		
		FileUtils.writeByteArrayToFile(fileToWriteTo, fileAsByteArray);
	}	

}
