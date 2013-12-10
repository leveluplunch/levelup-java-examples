package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate capitalizing the first 
 * word or letter in a sentence.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/capitalize-first-word/'>Capitalize first word</a>
 */
public class CapitalizeFirstWord {

	@Test
	public void capitalize_first_letter_of_sentence () { 
		
		String superWhyLyrics = "who’s got the power? The power to read.";
		String sentenceStartsWithCapital = Character
				.toUpperCase(superWhyLyrics.charAt(0)) + superWhyLyrics.substring(1);
		
		assertEquals("Who’s got the power? The power to read.", sentenceStartsWithCapital);	
	}
	
}
