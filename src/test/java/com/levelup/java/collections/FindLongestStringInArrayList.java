package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate how to find the longest string in a list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/find-longest-length-string-in-arraylist/'>Find longest length string in list</a>
 */
public class FindLongestStringInArrayList {

	List<String> randomStrings = new ArrayList<>();

	@Before
	public void setUp() {
		randomStrings.add("XVxOPHS");
		randomStrings.add("ttnBGouocZ");
		randomStrings.add("yHYQbXq");
		randomStrings.add("fkanCo");
		randomStrings.add("cxBuL");
	}

	@Test
	public void longest_string_java() {

		String longestString = randomStrings.get(0);
		for (String element : randomStrings) {
			if (element.length() > longestString.length()) {
				longestString = element;
			}
		}
		
		assertEquals("ttnBGouocZ", longestString);
	}

	@Test
	public void longest_string_sort_java8() {

		Optional<String> longest = randomStrings.stream()
				.sorted((e1, e2) -> e1.length() > e2.length() ? -1 : 1)
				.findFirst();

		assertEquals("ttnBGouocZ", longest.get());
	}

	@Test
	public void longest_string_guava() {

		Ordering<String> byLength = new Ordering<String>() {
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};
		
		Collections.sort(randomStrings, byLength.reverse());
	
		assertEquals("ttnBGouocZ", Iterables.getFirst(randomStrings, ""));
	}

}
