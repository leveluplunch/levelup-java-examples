package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * This java example will demonstrate reversing a string
 * 
 * @author Justin Musgrove
 * @see <a
 *      href='http://www.leveluplunch.com/java/examples/reverse-string/'>Reverse
 *      string</a>
 * 
 */
public class ReverseAString {

	private static final String PHRASE = "The dog barked at the mail man";
	private static final String PHRASE_REVERSE = "nam liam eht ta dekrab god ehT";

	@Test
	public void reverse_a_string_with_java() {

		StringBuffer buffer = new StringBuffer(PHRASE);

		String reversedString = buffer.reverse().toString();

		assertEquals(PHRASE_REVERSE, reversedString);
	}

	public String reverseString(String s) {
		if (s.length() == 0)
			return s;

		return reverseString(s.substring(1)) + s.charAt(0);
	}

	@Test
	public void reverse_a_string_with_recurrsion() {

		String reversedString = reverseString(PHRASE);

		assertEquals(PHRASE_REVERSE, reversedString);
	}

	@Test
	public void reverse_string_for_loop() {

		StringBuffer reverse = new StringBuffer();
		for (int i = PHRASE.length() - 1; i >= 0; i--) {
			reverse.append(PHRASE.charAt(i));
		}
		assertEquals(PHRASE_REVERSE, reverse.toString());
	}

	@Test
	public void reverse_a_string_with_apache_commons() {

		String reversedString = StringUtils.reverse(PHRASE);

		assertEquals(PHRASE_REVERSE, reversedString);
	}

}


