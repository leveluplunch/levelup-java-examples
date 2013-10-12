package com.levelup.java.string;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate right padding a string
 * of size 10 with spaces and 0
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/right-pad-string/'>Right pad string</a>
 * 
 */
public class RightPadString {

	@Test
	public void right_pad_string_with_zeros_java () {

		String rightPaddedString = String.format("%-10s", "levelup").replace(' ', '0');

		assertEquals("levelup000", rightPaddedString);
		assertEquals(10, rightPaddedString.length());
		assertThat(rightPaddedString, endsWith("0"));
	}
	
	@Test
	public void right_pad_string_with_spaces_java () {

		String rightPaddedString = String.format("%-10s", "levelup").replace(' ', ' ');
		
		assertEquals("levelup   ", rightPaddedString);
		assertEquals(10, rightPaddedString.length());
		assertThat(rightPaddedString, endsWith(" "));
	}

	@Test
	public void right_pad_string_with_zeros_guava () {
		
		String rightPaddedString = Strings.padEnd("levelup", 10, '0');
		
		assertEquals("levelup000", rightPaddedString);
		assertEquals(10, rightPaddedString.length());
		assertThat(rightPaddedString, endsWith("0"));
	}

	@Test
	public void right_pad_string_with_spaces_guava () {

		String rightPaddedString = Strings.padEnd("levelup", 10, ' ');
		
		assertEquals("levelup   ", rightPaddedString);
		assertEquals(10, rightPaddedString.length());
		assertThat(rightPaddedString, endsWith(" "));
	}
	
	@Test
	public void right_pad_string_with_zeros_apache_commons () {
		
		String rightPaddedString = StringUtils.rightPad("levelup", 10, "0");
		
		assertEquals("levelup000", rightPaddedString);
		assertEquals(10, rightPaddedString.length());
		assertThat(rightPaddedString, endsWith("0"));
	}

	@Test
	public void right_pad_string_with_spaces_apache_commons () {
		
		String rightPaddedString = StringUtils.rightPad("levelup", 10, " ");
		
		assertEquals("levelup   ", rightPaddedString);
		assertEquals(10, rightPaddedString.length());
		assertThat(rightPaddedString, endsWith(" "));
	}

	
	
}
