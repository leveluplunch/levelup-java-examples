package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.util.function.IntPredicate;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate finding the total number of vowels in a
 * string.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/count-vowels-in-string/'>Vowels
 *      in string</a>
 */
public class CountVowelsInString {

	boolean isVowel(char t) {
		return t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u'
				|| t == 'A' || t == 'E' || t == 'I' || t == 'O' || t == 'U';
	}

	@Test
	public void count_vowels_in_string_java() {

		String phrase = "whIskey tango fox";

		long vowelCount = 0;
		for (int x = 0; x < phrase.length(); x++) {
			if (isVowel(phrase.charAt(x))) {
				vowelCount++;
			}
		}

		assertEquals(5, vowelCount);
	}

	@Test
	public void count_vowels_in_string_java8() {

		IntPredicate vowel = new IntPredicate() {
			@Override
			public boolean test(int t) {
				return t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u'
						|| t == 'A' || t == 'E' || t == 'I' || t == 'O'
						|| t == 'U';
			}
		};

		String phrase = "whIskey tango fox";

		long vowelCount = phrase.chars().filter(vowel).count();

		assertEquals(5, vowelCount);

	}

	@Test
	public void count_vowels_in_string_guava() {

		String phrase = "whiskey tango fox";

		int vowelCount = CharMatcher.anyOf("aeiou").countIn(phrase);

		assertEquals(5, vowelCount);
	}

}
