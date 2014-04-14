package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * This java example will demonstrate counting the number of occurrences of
 * characters in a string
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/count-occurrences-of-char-in-string/'>Count
 *      number of occurrences in string</a>
 * 
 */
public class CountCharsInString {

	@Test
	public void number_of_cccurrences_of_char_in_string_java() {

		String stringToSearch = "she saw a fish on the seashore and "
				+ "I'm sure The fish she saw on the seashore was a saw-fish.";

		String letter = "s";

		int i = 0, count = 0;
		while ((i = stringToSearch.indexOf(letter, i++)) != -1) {
			count++;
			i += letter.length();
		}

		assertEquals(14, count);
	}

	@Test
	public void number_of_occcurrences_of_char_in_string_java8() {

		String stringToSearch = "she saw a fish on the seashore and "
				+ "I'm sure The fish she saw on the seashore was a saw-fish.";

		long count = stringToSearch.toLowerCase().chars().filter(e -> e == 's')
				.count();

		assertEquals(14, count);
	}

	// While this is one approach using guava, there is an open issue
	// https://code.google.com/p/guava-libraries/issues/detail?id=877
	@Test
	public void number_of_cccurrences_of_char_in_string_guava() {

		String stringToSearch = "she saw a fish on the seashore and "
				+ "I'm sure The fish she saw on the seashore was a saw-fish.";

		String letter = "s";

		int count = Iterables.size(Splitter.on(letter).split(stringToSearch)) - 1;
		
		assertEquals(14, count);
	}

	@Test
	public void number_of_cccurrences_of_char_in_string_apache_commons() {

		String stringToSearch = "she saw a fish on the seashore and "
				+ "I'm sure The fish she saw on the seashore was a saw-fish.";

		String letter = "s";

		int count = StringUtils.countMatches(stringToSearch, letter);
		assertEquals(14, count);
	}

	@Test
	public void number_of_cccurrences_of_char_in_string_springframework() {

		String stringToSearch = "she saw a fish on the seashore and "
				+ "I'm sure The fish she saw on the seashore was a saw-fish.";

		String letter = "s";

		int count = org.springframework.util.StringUtils.countOccurrencesOf(
				stringToSearch, letter);

		assertEquals(14, count);
	}

}
