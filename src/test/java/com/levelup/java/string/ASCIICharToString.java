package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert a char to string.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-ascii-char-to-string/'>Convert
 *      ASCII char to string</a>
 */
public class ASCIICharToString {

	@Test
	public void convert_ascii_to_string() {

		char letterA = 97;

		String lowerAAsString = Character.toString(letterA);

		assertEquals("a", lowerAAsString);
	}

}
