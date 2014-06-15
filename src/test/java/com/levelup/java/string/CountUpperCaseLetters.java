package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate how to count upper case letters .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-uppercase-letters/'>Count upper case letters</a>
 */
public class CountUpperCaseLetters {

	@Test
	public void count_upper_case_letters_java8() {

		String danielTigerLyrics = "It’s a beautiful day in the neighborhood, a beautiful day for a neighbor."
				+ "Would you be Mine, could you be mine, would you be my neighbor.";

		long count = danielTigerLyrics.chars().filter(Character::isUpperCase)
				.count();

		assertEquals(3, count);
	}

	@Test
	public void count_upper_case_letters_guava() {

		String danielTigerLyrics = "It’s a beautiful day in the neighborhood, a beautiful day for a neighbor."
				+ "Would you be Mine, could you be mine, would you be my neighbor.";

		long count = CharMatcher.JAVA_UPPER_CASE.retainFrom(danielTigerLyrics)
				.length();

		assertEquals(3, count);
	}

}
