package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate trimming all
 * leading and trailing spaces in a string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/trim-string/'>Trim string</a>
 * 
 */
public class TrimString {

	@Test
	public void trim_string_java () {
		
		String trimmedString = "      Runnin' Down A Dream       ".trim();
		assertEquals("Runnin' Down A Dream", trimmedString);
		
	}
	
	@Test
	public void trim_string_guava () {
		
		String trimmedSong = CharMatcher.WHITESPACE.trimFrom("       American Girl       ");
		assertEquals("American Girl", trimmedSong);
	}
	
	
	@Test
	public void trim_string_apache_commons () {
		
		String trimmedSong = StringUtils.trim("       I Need to Know   ");
		assertEquals("I Need to Know", trimmedSong);
	}

	@Test
	public void trim_string_spring () {
		
		String trimmedSong = org.springframework.util
				.StringUtils.trimWhitespace("       You Got Lucky   ");
		
		assertEquals("You Got Lucky", trimmedSong);
	}

	
	
}
