package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate getting min value from a map.
 * 
 * @author Justin Musgrove
 * @see <a
 *      href='http://www.leveluplunch.com/java/examples/find-min-value-in-map/'>Min
 *      value in map</a>
 * 
 */
public class MinValueHashMap {

	Map<Integer, Integer> mapOfValues;

	@Before
	public void setUp() {

		mapOfValues = new HashMap<Integer, Integer>();
		mapOfValues.put(4, 11);
		mapOfValues.put(5, 2);
		mapOfValues.put(6, 24);
		mapOfValues.put(7, 33);
		mapOfValues.put(8, 1);
	}

	@Test
	public void min_value_map_java() {

		Map.Entry<Integer, Integer> minEntry = null;

		for (Map.Entry<Integer, Integer> entry : mapOfValues.entrySet()) {

			if (minEntry == null
					|| entry.getValue().compareTo(minEntry.getValue()) < 0) {
				minEntry = entry;
			}
		}

		assertEquals(new Integer(1), minEntry.getValue());
	}

	@Test
	public void min_value_hashmap_java8() {

		Comparator<? super Entry<Integer, Integer>> valueComparator = (entry1,
				entry2) -> entry1.getValue().compareTo(entry2.getValue());

		Optional<Entry<Integer, Integer>> minValue = mapOfValues.entrySet()
				.stream().min(valueComparator);

		assertEquals(new Integer(1), minValue.get().getValue());
	}

	
}
