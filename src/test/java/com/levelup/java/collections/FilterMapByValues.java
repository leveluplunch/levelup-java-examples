package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate filtering
 * a map by values.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/filter-map-by-value/'>Filter map by value</a>
 * 
 */
public class FilterMapByValues {

	private static final Logger logger = Logger.getLogger(FilterMapByValues.class);
	
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
	public void filter_map_by_values_java () {
		
		Map<Integer, String> torskMeetings = new HashMap<Integer, String>();

		for (Entry<Integer, String> entry : MONTHS.entrySet()) {
			if (entry.getValue().endsWith("r")) {
				torskMeetings.put(entry.getKey(), entry.getValue());
			}
		}
		
		logger.info(torskMeetings);
		
	    assertThat(torskMeetings.values(), contains(
	    		"September", "October", "November", "December"));
	}

	@Test
	public void filter_map_by_values_guava () {
	
		Predicate<String> endsWithR = new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return input.endsWith("r");
			}
		};
		
		Map<Integer, String> torskMeetings = Maps.filterValues(MONTHS, endsWithR);
		
		logger.info(torskMeetings);
		
	    assertThat(torskMeetings.values(), contains(
	    		"September", "October", "November", "December"));
	}
	
}
