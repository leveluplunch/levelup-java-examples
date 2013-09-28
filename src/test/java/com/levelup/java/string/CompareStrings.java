package com.levelup.java.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate comparing
 * strings.  Check out http://en.wikipedia.org/wiki/String_intern_pool
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CompareStrings {
	
	private static final Logger logger = Logger.getLogger(CompareStrings.class);
	
	@Test
	public void compare_strings_in_java () {
		
		boolean stringEquals = "test".equals("test");
		
		assertTrue(stringEquals);
	}

	@Test
	public void compare_strings_compiler_interned_in_java () {

		String leftString = "test";
		String rightString = "test";
		
		if (leftString == rightString) {
			logger.info("yes these are true b/c literals are interned by compiler");
		}
		
		assertEquals(leftString, rightString);
	}
	
	@Test
	public void compare_strings_concatenation_in_java () {
		
		String leftString = "test";
		String rightString = "te" + "st";

		if (leftString == rightString) {
			logger.info("yes these are true b/c concatenation of string literals happens at compile time resulting in same objects");
		}
		assertEquals(leftString, rightString);
		
	}
	
	@Test
	public void compare_strings_ignoring_case_in_java () {
		
		boolean stringEquals = "test".equalsIgnoreCase("TEST");
		
		assertTrue(stringEquals);
	}
	
	@Test
	public void compare_strings_with_nulls_in_java () {
		String leftString = null;
		String rightString = null;
		
		if (leftString == rightString) {
			logger.info("yes");
		}
		
		assertEquals(leftString, rightString);
		
	}

	@SuppressWarnings("null")
	@Test(expected=NullPointerException.class)
	public void compare_strings_with_nulls_with_exception_in_java () {
		String leftString = null;
		String rightString = null;
		
		logger.info("strings are objects so if access a method on a null object, null pointer exception");
		
		leftString.equals(rightString);
	}
	
	
	
}
