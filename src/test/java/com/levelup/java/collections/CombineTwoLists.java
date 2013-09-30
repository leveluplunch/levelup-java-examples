package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate combining or joining two lists.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CombineTwoLists {
	
	private List<String> firstHalfStates = Lists.newArrayList(
			"Alabama",
			"Alaska",
			"Arizona",
			"Arkansas",
			"California",
			"Colorado",
			"Connecticut",
			"Delaware", 
			"Florida",
			"Georgia",
			"Hawaii",
			"Idaho", 
			"Illinois",
			"Indiana",
			"Iowa",
			"Kansas", 
			"Kentucky",
			"Louisiana",
			"Maine",
			"Maryland", 
			"Massachusetts",
			"Michigan",
			"Minnesota");
	
	private List<String> secondHalfStates = Lists.newArrayList(
			"Mississippi",
			"Missouri",
			"Montana",
			"Nebraska",
			"Nevada",
			"New Hampshire",
			"New Jersey",
			"New Mexico",
			"New York",
			"North Carolina",
			"North Dakota",
			"Ohio",
			"Oklahoma",
			"Oregon",
			"Pennsylvania",
			"Rhode Island",
			"South Carolina",
			"South Dakota",
			"Tennessee",
			"Texas",
			"Utah",
			"Vermont",
			"Virginia",
			"Washington",
			"West Virginia",
			"Wisconsin",
			"Wyoming");
	
	
	@Test
	public void join_two_lists_in_java () {

		List<String> allStates = new ArrayList<String>(firstHalfStates);
		allStates.addAll(secondHalfStates);
		
		assertTrue(allStates.size() == 50);
		
	}
	
	@Test
	public void combine_two_lists_in_java_with_guava () {

		List<String> allStates = Lists.newArrayList(Iterables.concat(firstHalfStates, secondHalfStates));
		
		assertTrue(allStates.size() == 50);

	}

	@Test
	public void combine_two_lists_in_java_with_apache_commons () {
		
		@SuppressWarnings("unchecked")
		List<String> allStates = ListUtils.union(firstHalfStates, secondHalfStates);
		
		assertTrue(allStates.size() == 50);
	}
	

}
