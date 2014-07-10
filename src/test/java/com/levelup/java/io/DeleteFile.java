package com.levelup.java.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to delete a file using
 * JDK 1.7 above and below along with apache commons FileUtils.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/delete-file/'>Delete a file</a>
 */
public class DeleteFile {

	private static final String SOURCE = "com/levelup/java/io/file-to-delete.txt";
										
	private static final String DEST = "output/FileToDelete.txt";
	
	@Before
	public void setUp () throws IOException, URISyntaxException {
	
		// copy file over to delete
		Path source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE).toURI());
		Path destination = Paths.get(DEST);
		
		// could of used Files.create
		java.nio.file.Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
	}
	
	@Test
	public void delete_file_java_legacy () {
		
		File fileToDelete = new File(DEST);
		
		boolean hasBeenDeleted = fileToDelete.delete();
		
		//check that files doesn't exists
		assertFalse(hasBeenDeleted);
	}

	@Test
	public void delete_file_java_nio () throws IOException {
		
		Path path = Paths.get(DEST);
		
		java.nio.file.Files.delete(path);
		
		assertTrue(Files.notExists(path));
	}

	@Test
	public void delete_file_java_apache () {

		Path path = Paths.get(DEST);

		FileUtils.deleteQuietly(path.toFile());
		
		assertTrue(Files.notExists(path));
	}
	
}
