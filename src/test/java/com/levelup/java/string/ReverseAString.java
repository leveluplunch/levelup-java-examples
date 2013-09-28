package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * This java example will demonstrate reversing a string
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class ReverseAString {

	private static final String PHRASE = "The dog barked at the mail man";
	private static final String PHRASE_REVERSE = "nam liam eht ta dekrab god ehT";
	
	@Test
	public void reverse_a_string_with_java () {
		
		StringBuffer buffer = new StringBuffer(PHRASE);
		
		String reversedString = buffer.reverse().toString();
	
		assertEquals(PHRASE_REVERSE, reversedString); 

	}
	
	@Test
	public void reverse_a_string_with_apache_commons () {
		
		String reversedString = StringUtils.reverse(PHRASE);
		
		assertEquals(PHRASE_REVERSE, reversedString);
		
	}
	
	
	
}
