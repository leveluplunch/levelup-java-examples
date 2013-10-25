package com.levelup.java.array;

import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate removing 
 * an element from array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/remove-element-from-array/'>Remove element from array</a>
 * 
 */
public class RemoveElementFromArray {

	private static final Logger logger = Logger.getLogger(RemoveElementFromArray.class);

	@Test
	public void remove_element_from_array_apache_commons () {
		
		String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", 
				"Thursday", "Friday", "Saturday"};
		
		String[] favoriteDaysOfTheWeek = ArrayUtils.removeElement(daysOfWeek, "Monday");
		
		logger.info(Arrays.toString(daysOfWeek));
		
		assertTrue(favoriteDaysOfTheWeek.length == 6);
		assertThat(favoriteDaysOfTheWeek, arrayContaining(
				"Sunday", "Tuesday", "Wednesday", 
				"Thursday", "Friday", "Saturday"));

	}
	
}
