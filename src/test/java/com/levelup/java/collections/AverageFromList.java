package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.junit.Before;
import org.junit.Test;

import com.google.common.math.DoubleMath;

/**
 * This java example will demonstrate calculating the average
 * from a list of numbers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples'>Average From List Of Numbers</a>
 * 
 */
public class AverageFromList {

	private static List<Double> NUMBERS_FOR_AVERAGE = new ArrayList<Double>();
	
	@Before
	public void setup () {
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
		NUMBERS_FOR_AVERAGE.add(new Double(10));
	}

	@Test
	public void calculate_average_from_list_with_java () {
		
		Double sum = 0d;
		for (Double vals : NUMBERS_FOR_AVERAGE) {
			sum += vals;
		}
			
		sum =  sum / NUMBERS_FOR_AVERAGE.size();
		
		// sum = 10
		assertEquals(new Double(10), sum);
		
	}
	
	@Test
	public void average_from_list_of_numbers_with_google_guava () {
		double average = DoubleMath.mean(NUMBERS_FOR_AVERAGE);
		assertEquals(10, average, 0);
	}
	
	@Test
	public void average_from_list_of_numbers_with_apache_commons () {

		double[] elements = ArrayUtils.toPrimitive(NUMBERS_FOR_AVERAGE.toArray(new Double[NUMBERS_FOR_AVERAGE.size()]));
		Mean mean = new Mean();
		double average = mean.evaluate(elements);
		assertEquals(10, average, 0);
	}
	
}
