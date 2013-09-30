package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate removing an element from array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class RemoveElementFromCollection {

	@Test
	public void remove_element_from_array_to_arraylist () {
		String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		List<String> daysOfWeekAsList = Lists.newArrayList(daysOfWeek);
		daysOfWeekAsList.remove("Monday");
		
		assertTrue(daysOfWeekAsList.size() == 6);
	}
	

	@Test
	public void remove_element_from_array_apache_commons () {
		
		String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[] favoriteDaysOfTheWeek = null;
		for (String day : daysOfWeek) {
		
			if (day.equals("Monday")) {
				favoriteDaysOfTheWeek = ArrayUtils.removeElement(daysOfWeek, day);
			}
		}
		
//		favoriteDaysOfTheWeek = [Sunday, Tuesday, Wednesday, Thursday, Friday, Saturday]
		
		assertTrue(favoriteDaysOfTheWeek.length == 6);
	}
	
}
