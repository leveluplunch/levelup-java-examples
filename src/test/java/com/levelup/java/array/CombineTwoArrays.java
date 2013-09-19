package com.levelup.java.array;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.collect.ObjectArrays;


/**
 * This java snippet will demonstrate combining or joining two arrays.
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

	@Test
	public void join_two_arrays_in_java () {

		String[] allStateCapitals = new String[firstHalfStateCapital.length + secondHalfStateCapital.length];
		
		// copy first half
		System.arraycopy(firstHalfStateCapital, 0, allStateCapitals, 0, firstHalfStateCapital.length);
		
		// copy second half
		System.arraycopy(secondHalfStateCapital, 0, allStateCapitals, firstHalfStateCapital.length, secondHalfStateCapital.length);
		
		System.out.println(Arrays.toString(allStateCapitals));;
		
		assertTrue(allStateCapitals.length == 50);
	}
	
	@Test
	public void join_two_arrays_in_java_with_guava () {
		String[] allStateCapitals = ObjectArrays.concat(firstHalfStateCapital, secondHalfStateCapital, String.class);
		
		assertTrue(allStateCapitals.length == 50);
	}
	
	
	
	@Test
	public void join_two_arrays_in_java_with_apache_commons () {
		
		String[] allStateCapitals = ArrayUtils.addAll(firstHalfStateCapital, secondHalfStateCapital);
		
		assertTrue(allStateCapitals.length == 50);
		
	}
	
}
