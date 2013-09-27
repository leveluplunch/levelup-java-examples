package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate removing chars
 * from string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class RemoveCharsFromString {

	@Test
	public void remove_chars_from_java () {
		
		String parsedTelePhoneNumber = "920-867-5309".replace("-", "");
		assertEquals("9208675309", parsedTelePhoneNumber);

	}

	@Test
	public void remove_all_special_chars_from_java () {

		String parsedTelePhoneNumber = "+920-867-5309".replaceAll("[\\D]", "");
		assertEquals("9208675309", parsedTelePhoneNumber);

	}
	
	@Test
	public void remove_char_from_string_guava () {
		
		String telephoneNumber = CharMatcher.inRange('0','9').retainFrom("920-867-5309");
		assertEquals("9208675309", telephoneNumber);
		
		// worried about performance
		CharMatcher digits = CharMatcher.inRange('0','9').precomputed();
		String teleNumber = digits.retainFrom("920-867-5309");
		assertEquals("9208675309", teleNumber);
		
	}
	
	@Test
	public void remove_char_from_string_apache_commons () {
		
		String parsedTelephoneNumber = StringUtils.remove("920-867-5309", '-');
		assertEquals("9208675309", parsedTelephoneNumber);

	}
	
	@Test
	public void remove_char_from_string_spring () {
		
		String parsedTelephoneNumber = org.springframework.util.
				StringUtils.replace("920-867-5309", "-", "");
		assertEquals("9208675309", parsedTelephoneNumber);

	}
	
}
