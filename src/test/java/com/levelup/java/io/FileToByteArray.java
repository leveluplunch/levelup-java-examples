package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

/**
 * This java example will demonstrate reading a file
 * into a byte array with Java, Guava and Apache Commons.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/file-to-byte-array/'>File to byte array</a>
 * 
 */
public class FileToByteArray {

	private static final String FILE_PATH = "com/levelup/java/io/file-to-byte-array.txt";
	private URI fileLocation;

	@Before
	public void setUp() throws URISyntaxException {
		fileLocation = this.getClass().getClassLoader().getResource(FILE_PATH).toURI();
	}
	
	@Test
	public void file_to_byte_array_java () throws IOException  {
		
        File file = new File(fileLocation);
 
        byte[] fileInBytes = new byte[(int) file.length()];
        
        InputStream inputStream = null;
		try {
		
			inputStream = new FileInputStream(file);
			
			inputStream.read(fileInBytes);
			
		} finally {
			inputStream.close();
		}

		assertEquals(18, fileInBytes.length);
	}
	
	@Test
	public void file_to_byte_array_java_nio () throws IOException {
		
		Path path = Paths.get(fileLocation);
		
		byte[] fileInBytes = java.nio.file.Files.readAllBytes(path);
	
		assertEquals(18, fileInBytes.length);
	}
	
	@Test
	public void file_to_byte_array_guava () throws IOException, URISyntaxException {
		
		File file = new File(fileLocation);
		
		byte[] fileInBytes = Files.toByteArray(file);
		
		assertEquals(18, fileInBytes.length);
	}
	
	@Test
	public void file_to_byte_array_guava_byteStreams () throws IOException {
		
		File file = new File(fileLocation);

		InputStream filestream = new FileInputStream(file);

		byte[] fileInBytes = ByteStreams.toByteArray(filestream);
		
		assertEquals(18, fileInBytes.length);
	}
	
	
	@Test
	public void file_to_byte_array_apache () throws IOException {
		
		File file = new File(fileLocation);
		
		byte[] fileInBytes = FileUtils.readFileToByteArray(file);
		
		assertEquals(18, fileInBytes.length);
	}
	
	@Test
	public void file_to_byte_array_apache_ioutils () throws IOException { 
		
		byte[] fileInBytes = IOUtils.toByteArray(fileLocation);

		assertEquals(18, fileInBytes.length);
	}
	
}
