package com.levelup.java.string;

import static java.lang.Character.isLowerCase;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate how to count lower case letters.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-lower-case-letters/'>Count lower case letters</a>
 */
public class CountLowerCaseLetters {

	@Test
	public void count_upper_case_letters_java8() {

		String catInTheHat = "The Cat in the Hat Knows a Lot About That!";

		long count = catInTheHat.chars().filter(Character::isLowerCase).count();

		assertEquals(25, count);
	}

	@Test
	public void count_upper_case_letters_guava() {

		String catInTheHat = "The Cat in the Hat Knows a Lot About That!";

		long count = CharMatcher.JAVA_LOWER_CASE.retainFrom(catInTheHat)
				.length();

		assertEquals(25, count);
	}
}
