package com.levelup.java.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.ObjectArrays;

/**
 * This java example will demonstrate declaring, allocate, 
 * and initializing array.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/initialize-array/'>Initialize array</a>
 * 
 */
public class InitializeArray {

	@Test
	public void initalize_int_array_java () {
		
		// declares an array of integers
        int[] nflNorthStadiumsCapacity;

        // allocates memory for 4 integers
        nflNorthStadiumsCapacity = new int[4];
        
        // initialize elements
        nflNorthStadiumsCapacity[0] = 80750;
        nflNorthStadiumsCapacity[1] = 61500;
        nflNorthStadiumsCapacity[2] = 64121;	
        nflNorthStadiumsCapacity[3] = 65000;
        
        assertTrue(nflNorthStadiumsCapacity.length == 4);
	}

	@Test
	public void initalize_int_array_java_shortcut () {
		
        int[] nflNorthStadiumsCapacity = {
        		80750, 61500, 
        		64121, 65000};

        assertTrue(nflNorthStadiumsCapacity.length == 4);
	}

	
	@Test
	public void initialize_string_array_java () {
		
		// declares an array of strings
        String[] nflNorthStadiums;

        // allocates memory for 4 strings
        nflNorthStadiums = new String[4];
        
        // initialize elements
        nflNorthStadiums[0] = "Lambeau Field";
        nflNorthStadiums[1] = "Soldier Field";
        nflNorthStadiums[2] = "Mall of America Fielddagger";
        nflNorthStadiums[3] = "Ford Fielddagger";
        
        assertTrue(nflNorthStadiums.length == 4);
	}

	@Test
	public void initialize_string_array_java_shortcut () {
		
		// declares an array of strings
        String[] nflNorthStadiums = {
        		"Lambeau Field", 
        		"Soldier Field", 
        		"Mall of America Fielddagger",
        		"Ford Fielddagger"};

        assertTrue(nflNorthStadiums.length == 4);
	}

	
	@Test
	public void initialize_string_array_java_with_guava () {
		
		String[] nflNorthStadiums = ObjectArrays.newArray(String.class, 4);

		nflNorthStadiums[0] = "Lambeau Field";
        nflNorthStadiums[1] = "Soldier Field";
        nflNorthStadiums[2] = "Mall of America Fielddagger";
        nflNorthStadiums[3] = "Ford Fielddagger";
        
        assertTrue(nflNorthStadiums.length == 4);
	}

	@Test
	public void initialize_string_array_java_with_guava_reference_type () {

		String[] nflStadiums = {""};

		String[] nflNorthStadiums = ObjectArrays.newArray(nflStadiums, 4);
		
		nflNorthStadiums[0] = "Lambeau Field";
        nflNorthStadiums[1] = "Soldier Field";
        nflNorthStadiums[2] = "Mall of America Fielddagger";
        nflNorthStadiums[3] = "Ford Fielddagger";
        
        assertEquals(4, nflNorthStadiums.length);
	}
	
}
