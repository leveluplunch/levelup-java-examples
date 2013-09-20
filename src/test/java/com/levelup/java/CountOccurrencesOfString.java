package com.levelup.java;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * This java snippet will demonstrate counting the number of occurrences of
 * characters in a string
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>Number of Occurrences of charchaters in string</a>
 * 
 */
public class CountOccurrencesOfString {

	@Test
	public void number_of_cccurrences_of_char_in_string_java() {

		String stringToSearch = "she saw a fish on the seashore and I'm sure The fish she saw on the seashore was a saw-fish.";
		String letter = "s";

		int i = 0, count = 0;
		while ((i = stringToSearch.indexOf(letter, i++)) != -1) {
			count++;
			i += letter.length();
		}

		assertEquals(14, count);

	}

	// While this is one approach using guava, there is an open issue
	//	https://code.google.com/p/guava-libraries/issues/detail?id=877
	@Test
	public void number_of_cccurrences_of_char_in_string_guava () {
		
		String stringToSearch = "she saw a fish on the seashore and I'm sure The fish she saw on the seashore was a saw-fish.";
		String letter = "s";

		int count = Iterables.size(Splitter.on(letter).split(stringToSearch)) - 1;
		
		assertEquals(14, count);
	}

	@Test
	public void number_of_cccurrences_of_char_in_string_apache_commons () {

		String stringToSearch = "she saw a fish on the seashore and I'm sure The fish she saw on the seashore was a saw-fish.";
		String letter = "s";

		int count = StringUtils.countMatches(stringToSearch, letter);
		assertEquals(14, count);
		
	}
}
