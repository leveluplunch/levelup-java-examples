package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate reversing the elements in an array.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class ReverseElementsInArray {
	
	String[] MONTHS_OF_YEAR_BACKWARDS;
	
	@Before
	public void setUp () {
		MONTHS_OF_YEAR_BACKWARDS = new String[] {
				"December", 
				"November",
				"October",
				"September",
				"August",
				"July",
				"June",
				"May",
				"April",
				"March",
				"February",
				"January"
		};
	}
	
	@Test
	public void reverse_elements_in_array_with_java () {
		
		for (int i=0; i < MONTHS_OF_YEAR_BACKWARDS.length / 2; i++) {
			
			// set a temp variable for current element
			String temp = MONTHS_OF_YEAR_BACKWARDS[i];
			
			// find the last element - 1
			int j = MONTHS_OF_YEAR_BACKWARDS.length - i - 1;
			
			// set the first element to last
			MONTHS_OF_YEAR_BACKWARDS[i] = MONTHS_OF_YEAR_BACKWARDS[j];
			
			// set last to the first
			MONTHS_OF_YEAR_BACKWARDS[j] = temp;
		}
		assertEquals("May", MONTHS_OF_YEAR_BACKWARDS[4]);
		
	}

	@Test
	public void reverse_elements_in_array_with_apache_commons () {
		ArrayUtils.reverse(MONTHS_OF_YEAR_BACKWARDS);
		assertEquals("May", MONTHS_OF_YEAR_BACKWARDS[4]);
	}
	
	

	
}
