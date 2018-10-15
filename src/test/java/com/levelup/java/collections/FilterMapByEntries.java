package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate filtering
 * a map by entries. 
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/filter-map-by-entries/'>Filter map by entries</a>
 * 
 */
public class FilterMapByEntries {

	private static final Logger logger = Logger.getLogger(FilterMapByEntries.class);
	
	Map<Integer, String> MONTHS = new HashMap<Integer, String>();
	
	@Before
	public void setUp () {

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
	public void filter_map_by_entries_java () {
		
		Map<Integer, String> monthsWithLengthFour = new HashMap<Integer, String>();

		for (Entry<Integer, String> entry : MONTHS.entrySet()) {
			if (entry.getValue().length() == 4) {
				monthsWithLengthFour.put(entry.getKey(), entry.getValue());
			}
		}
		
		logger.info(monthsWithLengthFour);
		
		assertThat(monthsWithLengthFour.values(), contains("June", "July"));
	}

	@Test
	public void filter_map_by_entries_java8_lambda () {
		
		Map<Integer, String> monthsWithLengthFour = 
				MONTHS.entrySet()
				.stream()
				.filter(p -> p.getValue().length() == 4)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		
		assertThat(monthsWithLengthFour.values(), contains("June", "July"));
	}

	
	
	@Test
	public void filter_map_by_entries_guava() {

		Predicate<Map.Entry<Integer, String>> monthLenthFour =
				new Predicate<Map.Entry<Integer, String>>() {
			@Override
			public boolean apply(Entry<Integer, String> input) {
				return input.getValue().length() == 4;
			}
		};

//		Map<Integer, String> monthsWithLengthFour = Maps.filterEntries(MONTHS,
//				monthLenthFour);
//
//		logger.info(monthsWithLengthFour);
//
//		assertThat(monthsWithLengthFour.values(), contains("June", "July"));
	}
}
