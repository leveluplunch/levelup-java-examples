package com.levelup.java.array;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * This java snippet will demonstrate shifting the values in array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class ShiftValuesInArray {

	String[] shoeTypes = {
			"Nike", 
			"Puma", 
			"Converse", 
			"Reebok", 
			"Asics"};
	
	@Test
	public void shift_values_in_array_with_java () {
		String[] shoeTypesMinusNike = new String[shoeTypes.length - 1];
		System.arraycopy(shoeTypes, 1, shoeTypesMinusNike, 0, shoeTypes.length - 1);
		
		assertTrue(Arrays.binarySearch(shoeTypesMinusNike, "Nike") < 0);
	}
	
}
