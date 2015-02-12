package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.StatUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to 
 * sum values in a list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/sum-values-in-arraylist/'>Sum values in list</a>
 */
public class SumValueInList {

	private static List<Double> NUMBERS_FOR_SUM;
	
	@Before
	public void setup () {
		NUMBERS_FOR_SUM = new ArrayList<Double>();
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
		NUMBERS_FOR_SUM.add(new Double(10));
	}

	
	@Test
	public void sum_values_in_list_java () {
		
	     Double sum = new Double(0); 
	     for (Double i : NUMBERS_FOR_SUM) {
	    	 sum = sum + i;
	     }
	         
		assertEquals(100, sum, 0);
	}
	
	@Test
	public void sum_values_in_list_java_8() {

		double sum = NUMBERS_FOR_SUM.stream().reduce(0d, (a, b) -> a + b);

		assertEquals(100, sum, 0);

		// or

		double sum2 = NUMBERS_FOR_SUM
				.stream()
				.mapToDouble(Double::doubleValue)
				.sum();

		assertEquals(100, sum2, 0);
	}

	@Test
	public void sum_values_in_list_apache() {

		double[] arrayToSume = ArrayUtils.toPrimitive(NUMBERS_FOR_SUM
				.toArray(new Double[NUMBERS_FOR_SUM.size()]));

		double sum = StatUtils.sum(arrayToSume);

		assertEquals(100, sum, 0);
	}
	
}
