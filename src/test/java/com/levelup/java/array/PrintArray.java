package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * This java snippet will demonstrate printing an array and multidimensional array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class PrintArray {
	
	@Test
	public void print_array_in_java () {
		String[] legendsDivision = {"Michigan", "Michigan State", "Minnesota", "Northwestern", "Iowa", "Nebraska"};
		
		assertEquals("[Michigan, Michigan State, Minnesota, Northwestern, Iowa, Nebraska]", 
				Arrays.toString(legendsDivision));

	}
	
	@Test
	public void print_multidimensional_array_in_java () {
		String[][] big10Conference = {
				{"Michigan", "Michigan State", "Minnesota", "Northwestern", "Iowa", "Nebraska"},
				{"Ohio State", "Illinois", "Indiana", "Penn State", "Wisconsin", "Purdue"}
			   };
		
		assertEquals ("[[Michigan, Michigan State, Minnesota, Northwestern, Iowa, Nebraska], [Ohio State, Illinois, Indiana, Penn State, Wisconsin, Purdue]]", 
				Arrays.deepToString(big10Conference));
		
	}
}
