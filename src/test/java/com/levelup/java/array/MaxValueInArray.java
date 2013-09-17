package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import com.google.common.primitives.Ints;

/**
 * This java snippet will demonstrate finding the highest value in array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class MaxValueInArray {

	int[] numbers = {1, 24, 45, 62, 85, 8, 91, 3, 5, 56, 9};
	
	@Test
	public void find_max_value_in_numeric_array_with_java () {

		int highest = numbers[0];
		for (int index = 1; index < numbers.length; index ++) {
			if (numbers[index] > highest) {
				highest = numbers [index];
			}
		}
		assertEquals(91, highest);
	}

	@Test
	public void find_max_value_in_numeric_array_with_guava () {
		int highest = Ints.max(numbers);
		assertEquals(91, highest);
	}
	
	@Test
	public void find_max_value_in_array_with_apache_commons () {
		int highest = NumberUtils.max(numbers);
		assertEquals(91, highest);
	}
	
}
