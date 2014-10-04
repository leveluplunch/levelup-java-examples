package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate how to find the shortest strings in list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/groovy/examples/get-shortest-length-string-arraylist/'>Find shortest length string in list</a>
 */
public class FindShortestStringInArrayList {

	List<String> randomStrings = new ArrayList<>();

	@Before
	public void setUp() {
		randomStrings.add("George Washington");
		randomStrings.add("Zachary Taylor");
		randomStrings.add("Andrew Johnson");
		randomStrings.add("Warren G. Harding");
		randomStrings.add("Calvin Coolidge");
	}

	@Test
	public void shortest_string_java() {

		String shortest = randomStrings.get(0);

		for (String element : randomStrings) {
			if (element.length() < shortest.length()) {
				shortest = element;
			}
		}

		assertEquals("Zachary Taylor", shortest);
	}

	@Test
	public void longest_string_sort_java8() {

		Comparator<String> byLength = (e1, e2) -> e1.length() > e2.length() ? -1
				: 1;

		Optional<String> shortest = randomStrings.stream()
				.sorted(byLength.reversed()).findFirst();

		assertEquals("Zachary Taylor", shortest.get());
	}

	@Test
	public void longest_string_guava() {

		Ordering<String> byLength = new Ordering<String>() {
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};

		Collections.sort(randomStrings, byLength);

		assertEquals("Zachary Taylor", Iterables.getFirst(randomStrings, ""));
	}

}
