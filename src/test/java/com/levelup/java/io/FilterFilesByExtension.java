package com.levelup.java.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.PatternFilenameFilter;

/**
 * This java example will demonstrate how to filter
 * files by extension.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/filter-files-by-extension/'>Filter files by extension</a>
 * 
 */
public class FilterFilesByExtension {

	private static final Logger logger = Logger.getLogger(FilterFilesByExtension.class);

	private URI sourceFileURI;

	@Before
	public void setUp() throws URISyntaxException {
		sourceFileURI = this.getClass().getClassLoader().getResource("com/levelup/java/io").toURI();
	}
	
	@Test
	public void find_files_by_extension_java () {

		File dir = new File(sourceFileURI);
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".txt");
		    }
		});
		
		logger.info(Arrays.toString(files));
		
		assertTrue(files.length >= 4);
	}
	
	@Test
	public void find_files_by_extension_guava () {

		Pattern pattern = Pattern.compile("^.*.txt");
		
		FilenameFilter filterByExtension = new PatternFilenameFilter(pattern);
		
		File dir = new File(sourceFileURI);
		File[] files = dir.listFiles(filterByExtension);

		logger.info(Arrays.toString(files));
		
		assertTrue(files.length >= 4);
	}
	
	@Test
	public void filter_files_by_extension () {

		File dir = new File(sourceFileURI);
		FileFilter fileFilter = new WildcardFileFilter("*.txt");
		File[] files = dir.listFiles(fileFilter);

		logger.info(Arrays.toString(files));

		assertTrue(files.length >= 4);
	}
	
	
}
