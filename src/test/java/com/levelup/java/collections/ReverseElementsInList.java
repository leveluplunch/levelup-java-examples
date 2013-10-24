package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.iterators.ReverseListIterator;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate reversing the order
 * of the elements in a specified list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/reverse-elements-in-list/'>Reverse elements in list</a>
 * 
 */
public class ReverseElementsInList {
	
	private static final Logger logger = Logger.getLogger(RemoveElementFromList.class);

	private List<String> precipitation = Lists.newArrayList(
			"Snow", 
			"Snow grains",
			"Ice pellets",
			"Hail", 
			"Ice crystals", 
			"Freezing drizzle", 
			"Freezing rain",
			"Rain", 
			"Drizzle");
	
	
	@Test
	public void reverse_elements_in_list_java () {
		
		Collections.reverse(precipitation);
		
		logger.info(precipitation);
		
		 assertThat(precipitation, contains(
				 "Drizzle", "Rain", "Freezing rain", 
				 "Freezing drizzle", "Ice crystals", 
				 "Hail", "Ice pellets", 
				 "Snow grains", "Snow"));
	}
	
	@Test
	public void reverse_elements_in_list_guava () {
		
		List<String> reversePrecipitation = Lists.reverse(precipitation);
		
		assertThat(reversePrecipitation, contains(
				 "Drizzle", "Rain", "Freezing rain", 
				 "Freezing drizzle", "Ice crystals", 
				 "Hail", "Ice pellets", 
				 "Snow grains", "Snow"));
	}
	
	@Test 
	public void reverse_elements_in_list_apache () {
		
		ReverseListIterator reverseListIterator = new ReverseListIterator(precipitation);
		
		List<String> reversePrecipitation = new ArrayList<String>();
		while (reverseListIterator.hasNext()) {
			reversePrecipitation.add( (String) reverseListIterator.next());
		}
		
		assertThat(reversePrecipitation, contains(
				 "Drizzle", "Rain", "Freezing rain", 
				 "Freezing drizzle", "Ice crystals", 
				 "Hail", "Ice pellets", 
				 "Snow grains", "Snow"));
	}
	
	
}
