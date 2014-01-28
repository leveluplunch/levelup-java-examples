package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate removing an element from list
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/remove-element-from-list/'>Remove element from list</a>
 * 
 */
public class RemoveElementFromList {
	
	private static final Logger logger = Logger.getLogger(RemoveElementFromList.class);
	
	@Test
	public void remove_element_from_array_to_arraylist () {
		
		String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", 
				"Thursday", "Friday", "Saturday"};
		
		List<String> daysOfWeekAsList = Lists.newArrayList(daysOfWeek);
		daysOfWeekAsList.remove("Monday");
		
		logger.info(daysOfWeekAsList);
		
		assertTrue(daysOfWeekAsList.size() == 6);
	}
	
	@Test
	public void remove_element_from_array_to_arraylist_java8 () {
		
		String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", 
				"Thursday", "Friday", "Saturday"};
	
		
		List<String> daysOfWeekAsList = Lists.newArrayList(daysOfWeek);

		boolean removed = daysOfWeekAsList.removeIf(p -> p.equalsIgnoreCase("Monday"));
		
		logger.info(daysOfWeekAsList);

		assertTrue(removed);
		assertTrue(daysOfWeekAsList.size() == 6);
	}	
	
}
