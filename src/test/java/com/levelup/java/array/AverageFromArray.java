package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.OptionalDouble;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.junit.Test;

import com.google.common.math.DoubleMath;

/**
 * This java example will demonstrate calculating the
 * average of elements in array.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/calculate-average-of-array/'>Calculate average of array</a>
 */
public class AverageFromArray {

	double[] NUMBERS = {1, 24, 45, 62, 85, 8, 91, 3, 5, 56, 9};

	@Test
	public void calculate_average_of_array_java () {
		
		double total = 0;
		for (double element : NUMBERS) {
			total += element;
		}
		
		double average = total / NUMBERS.length;
		
		assertEquals(35.36363636363637, average, 0);
	}
	

	@Test
	public void calculate_average_of_array_java8 () {
		
		OptionalDouble average = Arrays.stream(NUMBERS).average();
		
		assertEquals(35.36363636363637, average.getAsDouble(), 0);
		
	}
	
	@Test
	public void calculate_average_of_array_guava () {
		
		double average = DoubleMath.mean(NUMBERS);
		
		assertEquals(35.36363636363637, average, 0);
	}
	
	
	@Test
	public void calculate_average_of_array_apache () {
		
		Mean mean = new Mean();
		double average = mean.evaluate(NUMBERS);
		
		assertEquals(35.36363636363637, average, 0);
	}

}
