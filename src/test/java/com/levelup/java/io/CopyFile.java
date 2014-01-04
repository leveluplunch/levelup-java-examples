package com.levelup.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import com.google.common.io.Files;

/**
 * This java example will demonstrate copying a 
 * file with Straight up Java, Guava and Apache.
 * 
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/copy-file/'>Copy file</a>
 * 
 */
public class CopyFile {

	private static final String SOURCE = "com/levelup/java/io/copy-file.txt";
	private static final String DEST = "output/copy-file-2.txt";
	
	private URI sourceFileURI;

	@Before
	public void setUp() throws URISyntaxException, IOException {
		
		sourceFileURI = this.getClass().getClassLoader().getResource(SOURCE).toURI();
		
		// create new empty file as 
		// examples may or may not create the file
		File file = new File(DEST);
		file.createNewFile();	
	}
	
	@Test
	public void copy_file_java () throws IOException {

		File sourceFile = new File(sourceFileURI);
		File destinationFile = new File(DEST);
		
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(sourceFile);
			output = new FileOutputStream(destinationFile);

			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
			
		} finally {
			input.close();
			output.close();
		}
	}
	
	@Test
	public void copy_file_java_nio () throws IOException {
		
		Path sourcePath = Paths.get(sourceFileURI);
		Path destPath = Paths.get(DEST);
		
		java.nio.file.Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
	}
	
	@Test
	public void copy_file_guava () throws IOException {
		
		File sourceFile = new File(sourceFileURI);
		File destinationFile = new File(DEST);
		
		Files.copy(sourceFile, destinationFile);
	}

	@Test
	public void copy_file_apache_fileutils () throws IOException {
		
		File sourceFile = new File(sourceFileURI);
		File destinationFile = new File(DEST);

		FileUtils.copyFile(sourceFile, destinationFile, false);
	}
	
	@Test
	public void copy_file_apache_ioutils () throws FileNotFoundException, IOException {

		File sourceFile = new File(sourceFileURI);
		File destinationFile = new File(DEST);
		
		IOUtils.copy(new FileInputStream(sourceFile), 
				new FileOutputStream(destinationFile));

	}

	@Test
	public void copy_file_spring_framework () throws IOException {

		File sourceFile = new File(sourceFileURI);
		File destinationFile = new File(DEST);
		
		FileCopyUtils.copy(sourceFile, destinationFile);
	}
	
}
