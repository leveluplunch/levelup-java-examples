package com.levelup.java.net;

import static org.junit.Assert.assertTrue;

import org.apache.commons.validator.routines.UrlValidator;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate validating 
 * a URL.
 *  
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/validate-url/'>Validate URL</a>
 */
public class ValidateURL {
	
	@Test
	public void validate_url_java () {
		
		String urlRegex = "\\b(https?|ftp|file|ldap)://"
				+ "[-A-Za-z0-9+&@#/%?=~_|!:,.;]"
				+ "*[-A-Za-z0-9+&@#/%=~_|]";
		
		assertTrue("http://www.leveluplunch.com".matches(urlRegex));
	}
	
	@Ignore("not yet implemented")
	@Test
	public void validate_url_guava () {
	}
	
	@Test
	public void validate_url_apache_commons () {
		
		UrlValidator urlValidator = new UrlValidator();
		
		assertTrue(urlValidator.isValid("http://www.leveluplunch.com"));
	}
}
