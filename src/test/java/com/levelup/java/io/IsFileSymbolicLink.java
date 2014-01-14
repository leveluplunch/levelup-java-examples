package com.levelup.java.io;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to 
 * determines whether the specified file is a 
 * symbolic Link rather than an actual file.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/determine-if-file-is-symbolic-link/'>Is file a symbolic link</a>
 */
public class IsFileSymbolicLink {

	private static final String SOURCE = "com/levelup/java/io/is-symbolic-link.txt";
	
	Path source;
	
	@Before
	public void setUp() throws IOException, URISyntaxException {

		source = Paths.get(this.getClass().getClassLoader().getResource(SOURCE)
				.toURI());
	}

	@Test
	public void file_is_symbolic_link_nio() throws IOException {

		BasicFileAttributes attr = Files.readAttributes(source,
				BasicFileAttributes.class);

		boolean isSymbolicLink = attr.isSymbolicLink();

		assertFalse(isSymbolicLink);
	}

	@Test
	public void file_is_symbolic_link_nio_files () throws IOException {
	
		boolean isSymbolicLink = Files.isSymbolicLink(source);

		assertFalse(isSymbolicLink);
	}
	
	@Test
	public void file_is_symbolic_link_apache_commons() throws IOException {

		boolean isSymbolicLink = FileUtils.isSymlink(source.toFile());

		assertFalse(isSymbolicLink);
	}
	
}
