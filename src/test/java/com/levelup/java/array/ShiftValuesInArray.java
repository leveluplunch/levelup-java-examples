package com.levelup.java.array;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate shifting the values in array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/shift-elements-in-array/'>Shift elements in array</a>
 * 
 */
public class ShiftValuesInArray {
	
	private static final Logger logger = Logger.getLogger(ShiftValuesInArray.class);

	@Test
	public void shift_values_in_array_with_java () {

		String[] shoeTypes = {
				"Nike", 
				"Puma", 
				"Converse", 
				"Reebok", 
				"Asics"};
		
		String[] shoeTypesMinusNike = new String[shoeTypes.length - 1];
		System.arraycopy(shoeTypes, 1, shoeTypesMinusNike, 0, shoeTypes.length - 1);
		
		logger.info(Arrays.toString(shoeTypesMinusNike));
		
		assertTrue(Arrays.binarySearch(shoeTypesMinusNike, "Nike") < 0);
	}
	
}
