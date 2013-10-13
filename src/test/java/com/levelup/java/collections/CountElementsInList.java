package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

/**
 * This java example will demonstrate counting the number
 * of elements in a list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-occurrences-in-list/'>Count occurrences in list</a>
 * 
 */
public class CountElementsInList {

	private static final Logger logger = Logger.getLogger(CountElementsInList.class);
	
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
		
		Map<String, Integer> seussCount = new HashMap<String,Integer>();
		for(String t: seussCountActivities) {
		   Integer i = seussCount.get(t);
		   if (i ==  null) {
			   i = 0;
		   }
		   seussCount.put(t, i + 1);
		}

		logger.info(seussCount);

		int numberOfElephants = seussCount.get("Elephants");
		assertEquals(2, numberOfElephants);
	}
	
	@Test
	public void number_of_occurences_in_list_guava () {
		
		List<String> seussCountActivities = Lists.newArrayList(
				"findow", "Balloons", "Elephants", "Boom Bands", 
				"findow", "Hakken-Kraks", "Hakken-Kraks", 
				"Hakken-Kraks", "Elephants");
		
		Multiset<String> seussCount = HashMultiset.create(seussCountActivities);
		int numberOfElephants = seussCount.count("Elephants");
		
		logger.info(seussCount);

		assertEquals(2, numberOfElephants);
	}

	@Test
	public void number_of_occurence_in_list_apache_commons () {

		List<String> seussCountActivities = Lists.newArrayList(
				"findow", "Balloons", "Elephants", 
				"Boom Bands", "findow", "Hakken-Kraks", 
				"Hakken-Kraks", "Hakken-Kraks", "Elephants");
		
		int numberOfElephants = CollectionUtils.countMatches(seussCountActivities, new Predicate() {
			public boolean evaluate(Object arg0) {
				String compare = (String) arg0;
				return compare.equalsIgnoreCase("Elephants");
			}
		});
		
		logger.info(numberOfElephants);

		assertEquals(2, numberOfElephants);
	}
	
}
