package com.levelup.java.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Ints;


/**
 * This java example will demonstrate combining or joining two arrays.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CombineTwoArrays {

	String[] firstHalfStateCapital = {
			"Montgomery",
			"Juneau",
			"Phoenix",
			"Little Rock",
			"Sacramento",
			"Denver",
			"Hartford",
			"Dover",
			"Tallahassee",
			"Atlanta",
			"Honolulu",
			"Boise",
			"Springfield",
			"Indianapolis",
			"Des Moines",
			"Topeka",
			"Frankfort",
			"Baton Rouge",
			"Augusta",
			"Annapolis",
			"Boston",
			"Lansing",
			"Saint Paul",
			"Jackson",
			"Jefferson City" };
	
	String[] secondHalfStateCapital = {
			"Helena",
			"Lincoln",
			"Carson City",
			"Concord",
			"Trenton",
			"Santa Fe",
			"Albany",
			"Raleigh",
			"Bismarck",
			"Columbus",
			"Oklahoma City",
			"Salem",
			"Harrisburg",
			"Providence",
			"Columbia",
			"Pierre",
			"Nashville",
			"Austin",
			"Salt Lake City",
			"Montpelier",
			"Richmond",
			"Olympia",
			"Charleston",
			"Madison",
			"Cheyenne" };
	
	int[] firstHalfStateCapitalByIndex = {
			1, 
			2,
			3,
			4,
			5, 
			6, 
			7, 
			8, 
			9, 
			10, 
			11, 
			12, 
			13, 
			14, 
			15, 
			16, 
			17, 
			18, 
			19, 
			20, 
			21, 
			22, 
			23, 
			24, 
			25	
	};
	
	int[] secondHalfStateCapitalByIndex = {
			26, 
			27, 
			28,
			29, 
			30,
			31, 
			32, 
			33, 
			34, 
			35, 
			36, 
			37, 
			38, 
			39, 
			40, 
			41, 
			42, 
			43, 
			44, 
			45, 
			46, 
			47, 
			48, 
			49, 
			50	
	};
	

	@Test
	public void join_two_object_arrays_in_java () {

		String[] allStateCapitals = new String[firstHalfStateCapital.length + secondHalfStateCapital.length];
		
		// copy first half
		System.arraycopy(firstHalfStateCapital, 0, allStateCapitals, 0, firstHalfStateCapital.length);
		
		// copy second half
		System.arraycopy(secondHalfStateCapital, 0, allStateCapitals, firstHalfStateCapital.length, secondHalfStateCapital.length);
		
		assertTrue(allStateCapitals.length == 50);
	}
	
	@Test
	public void join_two_object_arrays_in_java_with_guava () {
		
		String[] allStateCapitals = ObjectArrays.concat(firstHalfStateCapital, secondHalfStateCapital, String.class);
		
		assertTrue(allStateCapitals.length == 50);
	}

	@Test
	public void join_two_primitive_arrays_in_java_with_guava () {
		
		int[] allStateCapitalsByIndex = Ints.concat(firstHalfStateCapitalByIndex, secondHalfStateCapitalByIndex);
		
		Arrays.toString(allStateCapitalsByIndex);
		assertEquals(50, allStateCapitalsByIndex.length);
	}

	
	
	@Test
	public void join_two_object_arrays_in_java_with_apache_commons () {
		
		String[] allStateCapitals = ArrayUtils.addAll(firstHalfStateCapital, secondHalfStateCapital);
		
		assertEquals(50, allStateCapitals.length);
		
	}
	
	@Test
	public void join_two_primitive_arrays_in_java_with_apache_commons () {
		
		int[] allStateCapitalsByIndex = ArrayUtils.addAll(firstHalfStateCapitalByIndex, secondHalfStateCapitalByIndex);
		
		assertEquals(50, allStateCapitalsByIndex.length);
		
	}

	
	
}
