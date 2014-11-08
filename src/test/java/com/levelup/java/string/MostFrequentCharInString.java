package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

/**
 * This java example will calculate the most frequent char in a string.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/group-count-repeating-characters-in-string/'
 *      > M o s t frequent char in string</a>
 */

public class MostFrequentCharInString {

	static String sentence = "What is the most frequent chars within this sentencee";

	@Test
	public void most_frequent_char_java() {
		
		Map<String, Long> charCount = new HashMap<>();
		for (char charachter : sentence.toLowerCase().toCharArray()) {
			
			String charAsString = Character.toString(charachter);
			if (charCount.containsKey(charAsString)) {
				long val = charCount.get(charAsString) + 1;
				charCount.put(charAsString, val);
			} else {
				charCount.put(charAsString, 1l);
			}

		}
		
		System.out.println(charCount);
		
		assertEquals(7, charCount.get("e"), 0);
	}

	@Test
	public void most_frequent_char_java8() throws IOException {

		Map<String, Long> frequentChars = Arrays.stream(
				sentence.toLowerCase().split("")).collect(
				Collectors.groupingBy(c -> c, Collectors.counting()));

		frequentChars.forEach((k, v) -> System.out.println(k + ":" + v));

		assertEquals(7, frequentChars.get("e"), 0);
	}

	@Test
	public void most_frequent_char_guava() throws IOException {

		Multiset<String> frequentCharacters = HashMultiset.create(Splitter
				.fixedLength(1).split(sentence.toLowerCase()));

		for (Entry<String> item : frequentCharacters.entrySet()) {
			System.out.println(item.getElement() + ":" + item.getCount());
		}

		assertEquals(7, frequentCharacters.count("e"), 0);
	}

}
