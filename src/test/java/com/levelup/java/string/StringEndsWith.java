package com.levelup.java.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * This java example will demonstrate checking if a
 * string ends with character. 
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class StringEndsWith {

	
	@Test
	public void string_ends_with_java () {
		
		boolean isAnchor = "http://www.leveluplunch.com/#".endsWith("#");
		
		assertTrue(isAnchor);
	}
	
	@Test
	public void string_ends_with_apache_commons () {
		
		boolean isAnchor = StringUtils.endsWith("http://www.leveluplunch.com/#", "#");
		assertTrue(isAnchor);
	}
	
	@Test
	public void string_ends_with_any_apache_commons () {
		
		boolean endsWithAnchorOrQ = StringUtils.endsWithAny("http://www.leveluplunch.com", new String[] {"#", "?"});
		assertFalse(endsWithAnchorOrQ);

	}
	
}
