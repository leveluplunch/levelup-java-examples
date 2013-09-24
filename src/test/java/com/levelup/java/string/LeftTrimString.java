package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate trimming
 * all leading spaces in java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class LeftTrimString {
	
	@Test
	public void trim_leading_spaces_from_string_guava () {
		
		String leftTrimmedString = CharMatcher.WHITESPACE.trimLeadingFrom("       Refugee       ");
		assertEquals("Refugee       ", leftTrimmedString);
	}

	@Test
	public void trim_leading_spaces_from_string_apache_commons () {
		
		String leftTrimmedString = StringUtils.stripStart("           The Waiting          ", " ");
		assertEquals("The Waiting          ", leftTrimmedString);
	}

	@Test
	public void trim_leading_spaces_from_string_spring_with_trimLeadingWhiteSpace () {
		
		String leftTrimmedString = org.springframework.util.StringUtils.trimLeadingWhitespace("      Free Falling          ");
		assertEquals("Free Falling          ", leftTrimmedString);
	}
	
	@Test
	public void trim_leading_spaces_from_string_spring_with_trim_leading_character () {
		
		String leftTrimmedString = org.springframework.util.StringUtils.trimLeadingCharacter("      I won't back dowm          ", ' ');
		assertEquals("I won't back dowm          ", leftTrimmedString);
	}
	
	
	
}
