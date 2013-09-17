package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import com.google.common.primitives.Ints;

/**
 * This java snippet will demonstrate finding the lowest value in array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class LowestValueInArray {

	int[] numbers = {1, 24, 45, 62, 85, 8, 91, 3, 5, 56, 9};
	
	@Test
	public void find_lowest_value_in_numeric_array_with_java () {

		int lowest = numbers[0];
		for (int index = 1; index < numbers.length; index ++) {
			if (numbers[index] < lowest) {
				lowest = numbers [index];
			}
		}
		assertEquals(1, lowest);
	}

	@Test
	public void find_lowest_value_in_numeric_array_with_guava () {
		int lowest = Ints.min(numbers);
		assertEquals(1, lowest);
	}
	
	@Test
	public void find_lowest_value_in_array_with_apache_commons () {
		int lowest = NumberUtils.min(numbers);
		assertEquals(1, lowest);
	}

	
}
