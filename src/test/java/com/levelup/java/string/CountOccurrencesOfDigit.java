package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will show how to count the number of digits in a string.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/count-occurrences-of-digits-in-string/'>Count occurrences of digit in string</a
 *      >
 */

public class CountOccurrencesOfDigit {

	@Test
	public void digits_in_string_guava_java() {

		String phrase = "Creating xml using java gives me heart burn, "
				+ "hopefully java 8, java 9, java 10 address this";

		int numberOfDigits = 0;
		char[] checkForNumbers = phrase.toCharArray();
		for (char val : checkForNumbers) {
			if (Character.isDigit(val)) {
				numberOfDigits++;
			}
		}
		assertEquals(4, numberOfDigits);
	}

	@Test
	public void digits_in_string_guava_java8() {

		String phrase = "Creating xml using java gives me heart burn, "
				+ "hopefully java 8, java 9, java 10 address this";

		assertEquals(4, phrase.chars().filter(Character::isDigit).count());
	}

	@Test
	public void digits_in_string_guava() {

		String phrase = "Creating xml using java gives me heart burn, "
				+ "hopefully java 8, java 9, java 10 address this";

		String numberOfDigits = CharMatcher.DIGIT.retainFrom(phrase);

		assertEquals(4, numberOfDigits.length());
	}

}
