package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.util.function.IntPredicate;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate finding all consonants in a string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-consonants-in-string/'>Count consonants in string</a>
 */
public class CountConsonantsInString {

	boolean isVowel(char t) {
		return t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u'
				|| t == 'A' || t == 'E' || t == 'I' || t == 'O' || t == 'U';
	}

	@Test
	public void count_vowels_in_string_java() {

		String phrase = "Whack for my daddy-o. There's whiskey in the jar-o";

		long consonantCount = 0;
		for (int x = 0; x < phrase.length(); x++) {
			if (!isVowel(phrase.charAt(x))) {
				consonantCount++;
			}
		}

		assertEquals(38, consonantCount);
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

		String phrase = "Whack for my daddy-o. There's whiskey in the jar-o";

		long consonantCount = phrase.chars().filter(vowel.negate()).count();

		assertEquals(38, consonantCount);
	}

	@Test
	public void count_vowels_in_string_guava() {

		String phrase = "Whack for my daddy-o. There's whiskey in the jar-o";

		int consonantCount = CharMatcher.anyOf("aeiou").negate()
				.countIn(phrase);

		assertEquals(38, consonantCount);
	}

}
