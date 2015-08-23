package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate getting max value from a map.
 * 
 * @author Justin Musgrove
 * @see <a
 *      href='http://www.leveluplunch.com/java/examples/find-max-value-in-map/'>Max
 *      value in map</a>
 * 
 */
public class MaxValueHashMap {

	Map<Integer, Integer> mapValues;

	@Before
	public void setUp() {

		mapValues = new HashMap<Integer, Integer>();
		mapValues.put(1, 3);
		mapValues.put(2, 4);
		mapValues.put(3, 5);
		mapValues.put(4, 6);
		mapValues.put(5, 7);
	}

	@Test
	public void max_value_map_java() {

		Map.Entry<Integer, Integer> maxEntry = null;

		for (Map.Entry<Integer, Integer> entry : mapValues.entrySet()) {

			if (maxEntry == null
					|| entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}

		assertEquals(new Integer(7), maxEntry.getValue());
	}

	@Test
	public void max_value_hashmap_java8() {

		Comparator<? super Entry<Integer, Integer>> maxValueComparator = (
				entry1, entry2) -> entry1.getValue().compareTo(
				entry2.getValue());

		Optional<Entry<Integer, Integer>> maxValue = mapValues.entrySet()
				.stream().max(maxValueComparator);

		assertEquals(new Integer(7), maxValue.get().getValue());
	}

}
