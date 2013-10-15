package com.levelup.java.guava;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * This java example will demonstrate multimap example.
 * 
 * If you haven't already you will face working with Map<K, List<V>>, basically the need 
 * to have 1 key to many elements.  Guava's Multimap to the rescue!  It does just that by 
 * making it easy to handle mapping keys to multiple values.  Before picking the default 
 * ArrayListMulimap, be sure to check out  ArrayListMultimap, HashMultimap, LinkedListMultimap, 
 * LinkedHashMultimap, TreeMultimap, ImmutableListMultimap and associated behaviors
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-multimap-example/'>MultiMap Example</a>
 * 
 */
public class MultiMapExample {
	
	private static final Logger logger = Logger.getLogger(MultiMapExample.class);
	
	@Test
	public void multipleMapExample_with_guava () {
		
		Multimap<String, String> outdoorElements = ArrayListMultimap.create();
		outdoorElements.put("fish", "walleye");
		outdoorElements.put("fish", "muskellunge");
		outdoorElements.put("fish", "bass");
		outdoorElements.put("insect", "ants");
		outdoorElements.put("insect", "water boatman");
		outdoorElements.put("insect", "Lord Howe Island stick insect");
		outdoorElements.put("tree", "oak");
		outdoorElements.put("tree", "birch");
		
		Collection<String> fishies = outdoorElements.get("fish");
		
		logger.info(fishies);

		assertTrue(fishies.size() == 3);
	}
	
	@Test
	public void multiMap_example_straight_up_java () {
		
		Map<String, List<String>> outdoorElements = new HashMap<String, List<String>>();
		putObjects (outdoorElements, "fish", "walleye");
		putObjects (outdoorElements, "fish", "muskellunge");
		putObjects (outdoorElements, "fish", "bass");
		putObjects (outdoorElements, "insect", "ants");
		putObjects (outdoorElements, "insect", "water boatman");
		putObjects (outdoorElements, "insect", "Lord Howe Island stick insect");
		putObjects (outdoorElements, "tree", "oak");
		putObjects (outdoorElements, "tree", "birch");
		
		Collection<String> fishies = outdoorElements.get("fish");

		logger.info(fishies);

		assertTrue(fishies.size() == 3);
	}

	private void putObjects (Map<String, List<String>> outdoorElements, String key, String value) {
		List<String> myClassList = outdoorElements.get(key);
	    if(myClassList == null) {
	        myClassList = new ArrayList<String>();
	        outdoorElements.put(key, myClassList);
	    }
	    myClassList.add(value);
		
	}
	
}
