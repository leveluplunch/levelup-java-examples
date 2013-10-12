package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate trimming trailing
 * spaces in a string.
 *  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/right-trim-string/'>Right trim string</a>
 * 
 */
public class RightTrimString {

	@Test
	public void trim_trailing_spaces_from_string_guava () {
		
		String rightTrimmedString = CharMatcher.WHITESPACE
				.trimTrailingFrom("       Something in the air       ");
		
		assertEquals("       Something in the air", rightTrimmedString);
	}

	@Test
	public void trim_trailing_spaces_from_string_apache_commons () {
		
		String rightTrimmedString = StringUtils
				.stripEnd("           Learning to fly          ", " ");
		
		assertEquals("           Learning to fly", rightTrimmedString);
	}

	@Test
	public void trim_trailing_spaces_from_string_spring_with_trimtrailingWhiteSpace () {
		
		String rightTrimmedString = org.springframework.util
				.StringUtils.trimTrailingWhitespace("      Don't come around here no more          ");
		
		assertEquals("      Don't come around here no more", rightTrimmedString);
	}
	
	@Test
	public void trim_trailing_spaces_from_string_spring_with_trim_trailing_character () {
		
		String rightTrimmedString = org.springframework.util
				.StringUtils.trimTrailingCharacter("      The waiting        ", ' ');
		
		assertEquals("      The waiting", rightTrimmedString);
	}
	
	
}
