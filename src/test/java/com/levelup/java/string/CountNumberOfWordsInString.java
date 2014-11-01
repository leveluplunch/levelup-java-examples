package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 * This java example will demonstrate how to count
 * the number of words in a string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-number-of-words-in-string/'>Count number of words in string</a>
 */
public class CountNumberOfWordsInString {

	static String phrase = "How many words are contained within this sentence.";

	@Test
	public void count_words_in_string_java() {
		StringTokenizer stringTokenizer = new StringTokenizer(phrase);
		assertEquals(8, stringTokenizer.countTokens());
	}

	@Test
	public void count_words_in_string_java8() throws IOException {
		assertEquals(8, Arrays.stream(phrase.split(" ")).count());
	}

	@Test
	public void count_words_in_string_guava() throws IOException {

		List<String> splitWords = Splitter.on(CharMatcher.WHITESPACE)
				.splitToList(phrase);
		assertEquals(8, splitWords.size());
	}
}
