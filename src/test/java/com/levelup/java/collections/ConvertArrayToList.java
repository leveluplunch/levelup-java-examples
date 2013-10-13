package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate converting an array
 * to list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-array-to-list/'>Convert array to list</a>
 * 
 */
public class ConvertArrayToList {

	@Test
	public void convert_string_array_to_list_with_java () {

		String[] planetsAsStringArray = { "The Sun", "Mercury", "Venus",
				"Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
		
		List<String> planetsAsArrayList = Arrays.asList(planetsAsStringArray);

		assertEquals(9, planetsAsArrayList.size());
	}

	@Test
	public void convert_string_array_to_list_with_java_using_collections () {

		String[] planetsAsStringArray = { "The Sun", "Mercury", "Venus",
				"Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
		
		List<String> planetsAsArrayList = new ArrayList<String>();
		Collections.addAll(planetsAsArrayList, planetsAsStringArray);
		
		assertEquals(9, planetsAsArrayList.size());
	}

	@Test
	public void convert_primitive_array_to_list_with_java () {

		int[] someNotSoRandomAscii = {98, 101, 101, 114, 66, 69, 69, 82};
		
		List<Integer> someNotSoRandomAsciiAsList = new ArrayList<Integer>(someNotSoRandomAscii.length);
		for (int x = 0; x < someNotSoRandomAscii.length; x++) {
			someNotSoRandomAsciiAsList.add(someNotSoRandomAscii[x]);
		}
		assertEquals(8, someNotSoRandomAsciiAsList.size());
	}
	
	@Test
	public void convert_string_array_to_list_with_guava () {
		
		String[] planetsAsStringArray = { "The Sun", "Mercury", "Venus",
				"Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };

		List<String> planetsAsArrayList = Lists
				.newArrayList(planetsAsStringArray);

		assertEquals(9, planetsAsArrayList.size());
	}

	@Test
	public void convert_primitive_array_to_list_with_guava () {
		int[] someNotSoRandomAscii = {98, 101, 101, 114, 66, 69, 69, 82};
		
		List<Integer> someNotSoRandomAsciiAsList = Ints.asList(someNotSoRandomAscii);

		assertEquals(8, someNotSoRandomAsciiAsList.size());
	}

	@Test
	public void convert_string_array_to_list_with_apachecommons () {

		String[] planetsAsStringArray = { "The Sun", "Mercury", "Venus",
				"Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };

		List<String> planetsAsArrayList = new ArrayList<String>();
		CollectionUtils.addAll(planetsAsArrayList, planetsAsStringArray);
		
		assertEquals(9, planetsAsArrayList.size());
	}

	@Test
	public void convert_primitive_array_to_list_with_apachecommons () {

		int[] someNotSoRandomAscii = {98, 101, 101, 114, 66, 69, 69, 82};

		List<Integer> someNotSoRandomAsciiAsList = 
				Arrays.asList(ArrayUtils.toObject(someNotSoRandomAscii));

		assertEquals(8, someNotSoRandomAsciiAsList.size());
	}
	
	@Test
	public void convert_string_array_to_list_with_spring () {

		String[] planetsAsStringArray = { "The Sun", "Mercury", "Venus",
				"Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };

		@SuppressWarnings("unchecked")
		List<String> planetsAsArrayList = org.springframework.util
				.CollectionUtils.arrayToList(planetsAsStringArray);
		
		assertEquals(9, planetsAsArrayList.size());	
	}

	@Test
	public void convert_primitive_array_to_list_with_spring () {

		int[] someNotSoRandomAscii = {98, 101, 101, 114, 66, 69, 69, 82};
		
		@SuppressWarnings("unchecked")
		List<Integer> someNotSoRandomAsciiAsList = org.springframework.util
				.CollectionUtils.arrayToList(someNotSoRandomAscii);

		assertEquals(8, someNotSoRandomAsciiAsList.size());
	}
	
}
