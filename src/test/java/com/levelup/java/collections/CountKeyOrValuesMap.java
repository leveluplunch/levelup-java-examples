package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;


/**
 * This java example will demonstrate counting the number
 * of keys or values in a map.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-occurrences-key-or-value-in-map/'>Count number of keys or values in hashmap</a>
 * 
 */
public class CountKeyOrValuesMap {

	Map<Integer, String> MONTHS = new HashMap<Integer, String>();

	@Before
	public void setUp() {

		MONTHS.put(new Integer(1), "January");
		MONTHS.put(new Integer(2), "February");
		MONTHS.put(new Integer(3), "March");
		MONTHS.put(new Integer(4), "April");
		MONTHS.put(new Integer(5), "May");
		MONTHS.put(new Integer(6), "June");
		MONTHS.put(new Integer(7), "July");
		MONTHS.put(new Integer(8), "August");
		MONTHS.put(new Integer(9), "September");
		MONTHS.put(new Integer(10), "October");
		MONTHS.put(new Integer(11), "November");
		MONTHS.put(new Integer(12), "December");
	}

	@Test
	public void count_value_in_map_using_java8() {

		Map<Integer, String> monthsStartWith_M = MONTHS.entrySet().stream()
				.filter(p -> p.getValue().startsWith("M"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

		assertEquals(2, monthsStartWith_M.size());
	}

	@Test
	public void filter_map_by_value_entries_guava() {

		Predicate<Map.Entry<Integer, String>> monthLenthFour = new Predicate<Map.Entry<Integer, String>>() {
			@Override
			public boolean apply(Entry<Integer, String> input) {
				return input.getValue().length() == 4;
			}
		};

		Map<Integer, String> monthsWithLengthFour = Maps.filterEntries(MONTHS,
				monthLenthFour);

		int count = monthsWithLengthFour.size();

		assertEquals(2, count);
	}

}
