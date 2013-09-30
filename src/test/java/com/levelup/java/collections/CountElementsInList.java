package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

/**
 * This java example will demonstrate counting the number
 * of elements in a list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CountElementsInList {

	@Test
	public void number_of_occurences_in_list_java () {
		
		@SuppressWarnings("serial")
		ArrayList<String> seussCountActivities = new ArrayList<String>() {{
		    add("findow");
		    add("Balloons");
		    add("Elephants");
		    add("Boom Bands");
		    add("findow");
		    add("Hakken-Kraks");
		    add("Hakken-Kraks");
		    add("Hakken-Kraks");
		    add("Elephants");
		}};
		
		// make generic for common use but wouldn't suggest it
		Map<String, Integer> seussCount = new HashMap<String,Integer>();
		for(String t: seussCountActivities) {
		   Integer i = seussCount.get(t);
		   if (i ==  null) {
			   i = 0;
		   }
		   seussCount.put(t, i + 1);
		}
		
		int numberOfElephants = seussCount.get("Elephants");
		assertEquals(2, numberOfElephants);
		
		// print out all elements with count
		StringBuffer sb = new StringBuffer();
		for (Entry<String, Integer> entry : seussCount.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + "\r");
		}
		assertEquals("Boom Bands: 1\rHakken-Kraks: 3\rfindow: 2\rElephants: 2\rBalloons: 1\r", sb.toString());
	}
	
	@Test
	public void number_of_occurences_in_list_guava () {
		
		List<String> seussCountActivities = Lists.newArrayList(
				"findow", "Balloons", "Elephants", "Boom Bands", "findow", "Hakken-Kraks", "Hakken-Kraks", "Hakken-Kraks", "Elephants");
		
		
		Multiset<String> seussCount = HashMultiset.create(seussCountActivities);
		int numberOfElephants = seussCount.count("Elephants");
		assertEquals(2, numberOfElephants);
		
		// iterate over all elements in multiset highest to lowest
		StringBuffer sb = new StringBuffer();
		for (String countActivity : Multisets.copyHighestCountFirst(seussCount).elementSet()) {
			sb.append(countActivity + ": " + seussCount.count(countActivity) + "\r");
		}

		assertEquals("Hakken-Kraks: 3\rfindow: 2\rElephants: 2\rBoom Bands: 1\rBalloons: 1\r", sb.toString());
	}

	@Test
	public void number_of_occurence_in_list_apache_commons () {

		List<String> seussCountActivities = Lists.newArrayList(
				"findow", "Balloons", "Elephants", "Boom Bands", "findow", "Hakken-Kraks", "Hakken-Kraks", "Hakken-Kraks", "Elephants");
		
		int numberOfElephants = CollectionUtils.countMatches(seussCountActivities, new Predicate() {
			public boolean evaluate(Object arg0) {
				String compare = (String) arg0;
				return compare.equalsIgnoreCase("Elephants");
			}
		});

		assertEquals(2, numberOfElephants);
	}
	
}
