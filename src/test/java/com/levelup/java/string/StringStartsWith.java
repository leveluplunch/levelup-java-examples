package com.levelup.java.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * This java example will demonstrate checking if a
 * string starts with character. 
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/string-starts-with/'>String starts with</a>
 * 
 */
public class StringStartsWith {

	
	@Test
	public void string_starts_with_java () {
		
		boolean startsWithHttp = "http://www.leveluplunch.com".startsWith("http");
		
		assertTrue(startsWithHttp);
	}
	
	@Test
	public void string_starts_with_regular_expression_with_java () {
		
		boolean startsWithHttpsOrFTP = "http://www.leveluplunch.com"
				.startsWith("^(https?|ftp)://.*$");
		
		assertFalse(startsWithHttpsOrFTP);		
	}

	
	@Test
	public void string_starts_with_apache_commons () {
		
		boolean startsWithHttp = StringUtils
				.startsWith("http://www.leveluplunch.com", "http");
		
		assertTrue(startsWithHttp);
	}
	
	@Test
	public void string_starts_with_any_apache_commons () {
		
		boolean startsWithHttpProtocol = StringUtils
				.startsWithAny("http://www.leveluplunch.com", new String[] {"http", "https"});
		
		assertTrue(startsWithHttpProtocol);

	}

	@Test
	public void string_starts_with_spring () {
		
		boolean startsWithHttp = org.springframework.util.StringUtils
				.startsWithIgnoreCase("http://www.leveluplunch.com", "http");
		
		assertTrue(startsWithHttp);
	}
	
}
