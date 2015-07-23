package com.levelup.java.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate how to remove all chars from string.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/remove-char-from-string-regex/'>Reg
 *      e x to remove everything but numbers</a>
 */
public class RemoveAllCharsFromString {

	@Test
	public void remove_chars_string() {

		String digits = "1a2b3c".replaceAll("[^\\d]", "");

		assertEquals(123, Integer.parseInt(digits));
	}

}
