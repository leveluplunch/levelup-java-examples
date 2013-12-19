package com.levelup.java.guava;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate common usages of
 * Google Guava Strings Utility.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-strings-utility-example/'>Strings utility example</a>
 */
public class StringsExample {
	
	
	/**
	 * Common prefix
	 */
	@Test
	public void common_prefix (){
		
		String phrase1 = "semicircle";
		String phrase2 = "semiconductor";
		
		String prefix = Strings.commonPrefix(phrase1, phrase2); 
		
		assertEquals("semic", prefix);
	}
	
	/**
	 * Common suffix
	 */
	@Test
	public void common_suffix (){
		
		String phrase1 = "fix";
		String phrase2 = "six";
		
		String suffix = Strings.commonSuffix(phrase1, phrase2); 
		
		assertEquals("ix", suffix);
	}
	
	/**
	 * Empty to null
	 */
	@Test
	public void empty_to_null () {
		
		String val = Strings.emptyToNull("");
		
		assertNull(val);
	}

	/**
	 * Is null or empty
	 */
	@Test
	public void is_null_or_empty () {
		
		String outputVal = null;
		String stringToCheck = "abc";

		if (!Strings.isNullOrEmpty(stringToCheck)) {
			outputVal = "do some work";
		};

		assertEquals("do some work", outputVal);
	}
	
	/**
	 * Null to empty
	 */
	@Test
	public void null_to_empty () {
		
		String val = Strings.nullToEmpty(null);
		
		assertEquals("", val);
	}
	
	/**
	 * Left pad string
	 */
	@Test
	public void left_pad_string () {

		String leftPaddedString = Strings.padStart("levelup", 10, ' ');
		
		assertEquals("   levelup", leftPaddedString);
		assertEquals(10, leftPaddedString.length());
		assertThat(leftPaddedString, startsWith(" "));
	}
	
	/**
	 * Right pad string
	 */
	@Test
	public void right_pad_string () {

		String rightPaddedString = Strings.padEnd("levelup", 10, ' ');
		
		assertEquals("levelup   ", rightPaddedString);
		assertEquals(10, rightPaddedString.length());
		assertThat(rightPaddedString, endsWith(" "));
	}

	
	/**
	 * Repeat string
	 */
	@Test
	public void repeat_String () {
		
		String uppityup = Strings.repeat("up", 3);
		assertEquals("upupup", uppityup);
	}
	
}
