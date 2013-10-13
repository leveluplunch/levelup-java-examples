package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate finding
 * the index of an element in array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/find-element-index-in-array/'>Find element index in array</a>
 * 
 */
public class ElementIndexInArray {

	
	@Test
	public void element_index_in_array_java () {
		
		String[] lilyFlowers = {   
				  "Lily of the valley",
			      "Lily Elite",
			      "Lily Monte Negro",
			      "Lily Casa Blanca",
			      "Lily of the Nile – Alba",
			      "Lily Stargazer"};
		
		int indexOfFlower = Arrays.asList(lilyFlowers).indexOf("Lily Monte Negro");
		
		assertEquals(2, indexOfFlower);	
	}
	
	@Test 
	public void element_index_in_int_array_java () {

		int[] twoQuarters = {1, 2, 3, 4, 5, 6};
		
		int endOfFirstQuarter = Arrays.asList(twoQuarters).indexOf(3);
		
		assertEquals(2, endOfFirstQuarter);
	}
	
	
	@Test
	public void element_index_in_array_java_with_guava () {
		
		String[] lilyFlowers = {   
				  "Lily of the valley",
			      "Lily Elite",
			      "Lily Monte Negro",
			      "Lily Casa Blanca",
			      "Lily of the Nile – Alba",
			      "Lily Stargazer"};

		int indexOfFlower = Iterators.indexOf(Iterators.forArray(lilyFlowers), new Predicate<String>() {
			public boolean apply(String input) {
				return input.equals("Lily Elite");
			}
		});
		
		assertEquals(1, indexOfFlower);	
	}
	
	@Test
	public void element_index_of_ints_in_array_java_with_guava () {
		
		int [] twoQuarters = {1, 2, 3, 4, 5, 6};
		
		int lastMonthInFirstQuarter = Ints.indexOf(twoQuarters, 3);
		assertEquals(2, lastMonthInFirstQuarter);
	}

	@Test
	public void element_index_of_string_array_java_with_apache_commons() {

		String[] lilyFlowers = { "Lily of the valley", "Lily Elite",
				"Lily Monte Negro", "Lily Casa Blanca",
				"Lily of the Nile – Alba", "Lily Stargazer" };

		int indexOfFlower = ArrayUtils.indexOf(lilyFlowers, "Lily Elite");

		assertEquals(1, indexOfFlower);
	}
	
	@Test
	public void element_index_of_int_array_java_with_apache_commons() {

		int [] twoQuarters = {1, 2, 3, 4, 5, 6};
		
		int lastMonthInFirstQuarter = ArrayUtils.indexOf(twoQuarters, 3);
		assertEquals(2, lastMonthInFirstQuarter);
	}
	
}

