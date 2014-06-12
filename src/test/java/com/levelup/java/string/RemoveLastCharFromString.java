package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * This java example will demonstrate how to remove
 * the last char in a string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/remove-last-character-from-string/'>Remove last character from string</a>
 */
public class RemoveLastCharFromString {

	@Test
	public void delete_last_char_java() {

		String phrase = "level up lunch";

		String rephrase = null;
		if (phrase != null && phrase.length() > 1) {
			rephrase = phrase.substring(0, phrase.length() - 1);
		}

		assertEquals("level up lunc", rephrase);
	}
	
	@Test
	public void delete_last_char_apache() {
		
		String phrase = "level up lunch";
		
		String rephrase = StringUtils.chop(phrase);
		
		assertEquals("level up lunc", rephrase);
	}
	

}
