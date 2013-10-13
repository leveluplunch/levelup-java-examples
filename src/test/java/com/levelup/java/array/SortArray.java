package com.levelup.java.array;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate sorting numeric 
 * and string array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/sort-array/'>Sort Array</a>
 * 
 */
public class SortArray {

	private static final Logger logger = Logger.getLogger(SortArray.class);

	@Test
	public void sort_numeric_array_in_java () {
		
		int[] uwConferenceTitles = {
				1896, 2011, 1901, 1912, 1952, 
				1959, 1962, 1999, 1897, 1906, 
				1993, 1998,  2010,  2012};
		
		Arrays.sort(uwConferenceTitles);
		
		logger.info(Arrays.toString(uwConferenceTitles));
		
		assertArrayEquals(new int[] {
				1896, 1897, 1901, 1906, 1912, 
				1952, 1959, 1962, 1993, 1998, 
				1999, 2010, 2011, 2012}, 
				uwConferenceTitles);
	}
	
	@Test
	public void sort_numeric_array_decending_in_java () {

		Integer[] uwConferenceTitles = {
				1896, 2011, 1901, 1912, 1952, 
				1959, 1962, 1999, 1897, 1906, 
				1993, 1998,  2010,  2012};
		
		Arrays.sort(uwConferenceTitles, Collections.reverseOrder());
		
		logger.info(Arrays.toString(uwConferenceTitles));
		
		assertArrayEquals(new Integer[] {
				2012, 2011, 2010, 1999, 1998, 
				1993, 1962, 1959, 1952, 1912, 
				1906, 1901, 1897, 1896}, 
				uwConferenceTitles);
		
	}
	
	@Test
	public void sort_string_array_in_java () {

		String[] wiStateParks = {
				"Mill Bluff State Park",
				"Amnicon Falls State Park",
				"Wyalusing State Park",
				"Big Foot Beach State Park",
				"Willow River State Park",
				"Roche-A-Cri State Park"
			};
		
		Arrays.sort(wiStateParks);
		
		logger.info(Arrays.toString(wiStateParks));
		
		assertArrayEquals(new String[] {
				"Amnicon Falls State Park",
				"Big Foot Beach State Park",
				"Mill Bluff State Park",
				"Roche-A-Cri State Park",
				"Willow River State Park",
				"Wyalusing State Park"}, 
				wiStateParks);
	
	}

	@Test
	public void sort_numeric_array_decending_in_java_with_guava () {
		
		Integer[] uwConferenceTitles = {
				1896, 2011, 1901, 1912, 1952, 
				1959, 1962, 1999, 1897, 1906, 
				1993, 1998,  2010,  2012};
		
		Arrays.sort(uwConferenceTitles, Ordering.natural().reverse());
		
		logger.info(Arrays.toString(uwConferenceTitles));

		assertArrayEquals(new Integer[] {
				2012, 2011, 2010, 1999, 1998, 
				1993, 1962, 1959, 1952, 1912, 
				1906, 1901, 1897, 1896}, 
				uwConferenceTitles);
		
	}
	
	@Test
	public void sort_string_array_in_java_with_guava_by_length () {
		
		
		Ordering<String> byLengthOrdering = new Ordering<String>() {
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};

		String[] wiStateParks = { "Mill Bluff State Park",
				"Amnicon Falls State Park", "Wyalusing State Park",
				"Big Foot Beach State Park", "Willow River State Park",
				"Roche-A-Cri State Park" };

		Arrays.sort(wiStateParks, byLengthOrdering);

		logger.info(Arrays.toString(wiStateParks));

		assertArrayEquals(new String[] { "Wyalusing State Park",
				"Mill Bluff State Park", "Roche-A-Cri State Park",
				"Willow River State Park", "Amnicon Falls State Park",
				"Big Foot Beach State Park" }, wiStateParks);
		
	}

}
