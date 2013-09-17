package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import org.apache.commons.math3.stat.StatUtils;
import org.junit.Test;

/**
 * This java snippet will demonstrate summing values in array.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class SumValuesInArray {

	double[] numbers = {1, 24, 45, 62, 85, 8, 91, 3, 5, 56, 9};
	
	@Test
	public void sum_values_in_array_with_java () {
	
		double total = 0;
		for (double element : numbers) {
			total += element;
		}
		
		assertEquals(389, total, 0);
	}

	//TODO
//	@Test
//	@Ignore
//	public void sum_values_in_array_with_java_8 () {
//		int total = IntStream.of(numbers).sum();
//		assertEquals(389, total);
//	}

	@Test
	public void sum_values_in_array_with_apache_commons () {
		
		double total = StatUtils.sum(numbers);
		assertEquals(389, total, 0);
		
	}
	
	

	
	
	
}
