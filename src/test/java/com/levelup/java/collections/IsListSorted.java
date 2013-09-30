package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * This java example will demonstrate checking if 
 * a list is sorted.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/check-if-list-is-sorted'>Check if list is sorted</a>
 * 
 */
public class IsListSorted {
	
	@Test
	public void is_list_of_numbers_sorted_in_java_with_guava () {

		List<Integer> uwConferenceTitles = Lists.newArrayList(
				1896, 1897, 1901, 1906, 1912, 
				1952, 1959, 1962, 1993, 1998, 
				1999, 2010, 2011, 2012);
		
		boolean isSorted = Ordering.natural().isOrdered(uwConferenceTitles);
		
		assertTrue(isSorted);

	}

	@Test
	public void is_list_of_strings_sorted_in_java_with_guava () {

		List<String> secConferenceEast = Lists.newArrayList(
				"Florida",
				"Georgia",
				"Missouri",
				"South Carolina",
				"Tennessee",
				"Vanderbilt");
		
		boolean isSorted = Ordering.natural().isOrdered(secConferenceEast);
		
		assertTrue(isSorted);

	}
	
	@Test
	public void is_list_of_strings_sorted_decending_in_java_with_guava () {

		List<String> secConferenceEastDecending = Lists.newArrayList(
				"Vanderbilt",
				"Tennessee",
				"South Carolina",
				"Missouri",
				"Georgia",
				"Florida");
		
		boolean isSorted = Ordering.natural().reverse().isOrdered(secConferenceEastDecending);
		
		assertTrue(isSorted);

	}

	
	
	@Test
	public void is_list_of_strings_sorted_case_insensitive_in_java_with_guava () {

		List<String> secConferenceEast = Lists.newArrayList(
				"alabama",
				"Alabama",
				"ALABAMA");
		
		boolean isSorted = Ordering.from(String.CASE_INSENSITIVE_ORDER).isOrdered(secConferenceEast);
		
		assertTrue(isSorted);
	}

}
