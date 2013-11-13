package com.levelup.java.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate how to iterate or loop
 * over a map.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/iterate-loop-over-each-entry-in-map/'>Iterate or loop over each entry in map</a>
 * 
 */
public class IterateLoopAMap {

	private static final Logger logger = Logger.getLogger(IterateLoopAMap.class);
	
	@Test
	public void iterate_or_loop_over_a_map_entryset () {
		
		Map<Integer, String> numbers = new HashMap<Integer, String>();
		numbers.put(new Integer(1), "one");
		numbers.put(new Integer(2), "two");

		for (Map.Entry<Integer, String> entry : numbers.entrySet()) {
			logger.info("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}

	}
	
	@Test
	public void iterate_or_loop_over_a_map_iterator () {
		
		Map<Integer, String> numbers = new HashMap<Integer, String>();
		numbers.put(new Integer(1), "one");
		numbers.put(new Integer(2), "two");

	    Iterator<Map.Entry<Integer, String>> it = numbers.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<Integer, String> mapping = it.next();
	        
	        Integer key = mapping.getKey();
	        String value = mapping.getValue();
	        
			logger.info("Key : " + key + " Value : " + value);
	    }
	}
	
}
