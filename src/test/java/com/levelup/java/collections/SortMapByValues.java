package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * This example will demonstrate how to sort or 
 * order a map by its value.  The demonstration 
 * will use a map keyed by calories and value is 
 * the type of candy bar.   
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/sort-order-map-by-values/'>Sort map by value</a>
 * 
 */
public class SortMapByValues {

	private static final Logger logger = Logger.getLogger(SortMapByValues.class);
	
	Map<Integer, String> CANDY_BARS;
	
	@Before
	public void setUp () {
		
		CANDY_BARS = new HashMap<Integer, String>();
		CANDY_BARS.put(233, "REESE'S P-BUTTER CUPS");
		CANDY_BARS.put(222, "REESE'S P-BUTTER CUPS");
		CANDY_BARS.put(284, "TWIX, CARAMEL");
		CANDY_BARS.put(232, "ALMOND JOY");
		CANDY_BARS.put(149, "YORK PEPPERMINT PATTIE");
	}
	
	
	@Test
	public void sort_map_by_values_java () {
		
		Comparator<Map.Entry<Integer, String>> byMapValues = new Comparator<Map.Entry<Integer, String>>() {
			@Override
			public int compare(Map.Entry<Integer, String> left, Map.Entry<Integer, String> right) {
				return left.getValue().compareTo(right.getValue());
			}
		};
		
		// create a list of map entries
		List<Map.Entry<Integer, String>> candyBars = new ArrayList<Map.Entry<Integer, String>>();
		
		// add all candy bars
		candyBars.addAll(CANDY_BARS.entrySet());
		
		// sort the collection
		Collections.sort(candyBars, byMapValues);
		
		logger.info(candyBars);
		
		assertEquals("ALMOND JOY", candyBars.get(0).getValue());
	}
	
	Ordering<Map.Entry<Integer, String>> byMapValues = new Ordering<Map.Entry<Integer, String>>() {
       @Override
       public int compare(Map.Entry<Integer, String> left, Map.Entry<Integer, String> right) {
			return left.getValue().compareTo(right.getValue());
       }
    };
	
	@Test
	public void sort_map_by_values_guava () {
		 
		// create a list of map entries
		List<Map.Entry<Integer, String>> candyBars = Lists.newArrayList(CANDY_BARS.entrySet());

		Collections.sort(candyBars, byMapValues);
		
		logger.info(candyBars);
	    
		assertEquals("ALMOND JOY", candyBars.get(0).getValue());
	}
	
	@Test
	public void sort_map_by_values_guava_reverse () {
		 
		// create a list of map entries
		List<Map.Entry<Integer, String>> candyBars = Lists.newArrayList(CANDY_BARS.entrySet());

		Collections.sort(candyBars, byMapValues.reverse());
		
		logger.info(candyBars);
	    
		assertEquals("YORK PEPPERMINT PATTIE", candyBars.get(0).getValue());
	}
}
