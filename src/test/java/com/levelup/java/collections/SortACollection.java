package com.levelup.java.collections;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public class SortACollection {

//	In this exercise we are going to sort a list of transaction by
//	transactions amount with 0 armount firsthave a list of transactions
//  that will be sorted.  While a collection maintains order
//	it may be important sort on a web page or process nulls first.
//	
	
	
	
	@Test
	public void sort_collection_with_java () {
//		Collections.sort(l);
	}
	
	
	
	@Test
	public void sortget_last_element_in_list_with_guava () {
		
		Ordering<String> byLengthOrdering = new Ordering<String>() {
		  public int compare(String left, String right) {
		    return Ints.compare(left.length(), right.length());
		  }
		};

		List<String> something = Lists.newArrayList("a", "ab", "abc", "abcd", "abcde", null, null);
		
		System.out.println(byLengthOrdering.nullsFirst().reverse());;
		
//		byLengthOrdering.
		Collections.sort(something, byLengthOrdering.nullsFirst().reverse() );
		
		System.out.println(something);
		
		
	}
		
	
}
