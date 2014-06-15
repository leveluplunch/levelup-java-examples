package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * This java example will demonstrate how to remove the first character in a
 * string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/remove-first-character-from-string/'>Remove first character from string</a>
 */
public class RemoveFirstCharFromString {

	@Test
	public void delete_first_char_java() {

		String phrase = "TRON: Legacy";

		String rephrase = null;
		if (phrase != null && phrase.length() > 1) {
			rephrase = phrase.substring(1, phrase.length());
		}

		assertEquals("RON: Legacy", rephrase);
	}

	@Test
	public void delete_last_char_apache() {

		String phrase = "TRON: Legacy";

		String rephrase = StringUtils.right(phrase, phrase.length() - 1);

		assertEquals("RON: Legacy", rephrase);
	}

}
