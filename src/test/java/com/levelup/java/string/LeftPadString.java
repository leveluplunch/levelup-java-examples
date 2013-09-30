package com.levelup.java.string;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate left padding a string
 * of size 10 with spaces and zeros.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class LeftPadString {

	@Test
	public void left_pad_string_with_zeros_java () {

		String leftPaddedString = String.format("%10s", "levelup").replace(' ', '0');

		assertEquals(10, leftPaddedString.length());
		assertThat(leftPaddedString, startsWith("0"));
	}
	
	@Test
	public void left_pad_string_with_spaces_java () {

		String leftPaddedString = String.format("%10s", "levelup").replace(' ', ' ');

		assertEquals(10, leftPaddedString.length());
		assertThat(leftPaddedString, startsWith(" "));
	}

	@Test
	public void left_pad_string_with_zeros_guava () {
		
		String leftPaddedString = Strings.padStart("levelup", 10, '0');
		
		assertEquals(10, leftPaddedString.length());
		assertThat(leftPaddedString, startsWith("0"));
	}

	@Test
	public void left_pad_string_with_spaces_guava () {

		String leftPaddedString = Strings.padStart("levelup", 10, ' ');
		
		assertEquals(10, leftPaddedString.length());
		assertThat(leftPaddedString, startsWith(" "));
	}
	
	@Test
	public void left_pad_string_with_zeros_apache_commons () {
		String leftPaddedString = StringUtils.leftPad("levelup", 10, "0");
		
		assertEquals(10, leftPaddedString.length());
		assertThat(leftPaddedString, startsWith("0"));
	}

	@Test
	public void left_pad_string_with_spaces_apache_commons () {
		String leftPaddedString = StringUtils.leftPad("levelup", 10, " ");
		
		assertEquals(10, leftPaddedString.length());
		assertThat(leftPaddedString, startsWith(" "));
	}
	
}
