package com.levelup.java.string;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This java example will demonstrate comparing
 * strings.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CompareStrings {
	
	@Test
	public void compare_strings_in_java () {
		
		boolean stringEquals = "test".equals("test");
		
		assertTrue(stringEquals);
	}

	@Test
	public void compare_strings_ignoring_case_in_java () {
		
		boolean stringEquals = "test".equalsIgnoreCase("TEST");
		
		assertTrue(stringEquals);
	}
	
}
