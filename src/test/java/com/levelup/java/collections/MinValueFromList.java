package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate getting the min value 
 * from list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/min-value-in-list/'>Min value in list</a>
 * 
 */
public class MinValueFromList {

	
	private static List<Integer> CENTERS_ROOKIE_YEAR = Lists.newArrayList(
			1946, 1988, 1970, 1931, 1940, 1920, 1980, 1953, 1960, 1974, 1987
			);
	
	@Test
	public void find_min_value_from_list_of_integers_java () {

		Integer maxElement = Collections.min(CENTERS_ROOKIE_YEAR);
		
		assertEquals(new Integer (1920), maxElement);
	}

	
	@Test
	public void find_min_value_from_list_of_integers_guava_ordering() {

		Ordering<Integer> byYear = new Ordering<Integer>() {
		    @Override
		    public int compare(Integer left, Integer right) {
		        return Ints.compare(left, right);
		    }
		};		
		
		assertEquals(new Integer (1920), byYear.min(CENTERS_ROOKIE_YEAR));
	}
	
	@Test
	public void find_min_value_from_list_of_integers_guava_ordering_shorthand () {

		Integer maxElement = Ordering.natural().min(CENTERS_ROOKIE_YEAR);
		
		assertEquals(new Integer (1920), maxElement);
	}

	
}
