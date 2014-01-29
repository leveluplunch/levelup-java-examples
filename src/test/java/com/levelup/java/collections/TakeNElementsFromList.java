package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate taking the 
 * first n elements from array list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/limit-or-take-first-elements-from-list/'></a>
 */
public class TakeNElementsFromList {
  
	@Test
	public void limit_array_list_size_java () {
		
		List<Integer> contestents = new ArrayList<Integer>(8);
		contestents.add(1);
		contestents.add(2);
		contestents.add(3);
		contestents.add(4);
		contestents.add(5);
		contestents.add(6);
		contestents.add(7);
		contestents.add(8);
		contestents.add(9);
		
		List<Integer> contestWinners = contestents.subList(0, 5);

		assertEquals(5, contestWinners.size());
	}
	
	@Test
	public void limit_array_list_size_java8 () {
		
		List<Integer> contestents = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
		
		List<Integer> contestWinners = contestents
				.stream()
				.limit(5)
				.collect(Collectors.toList());
		
		assertEquals(5, contestWinners.size());
	}
	
	@Test
	public void limit_array_list_size_guava() {

		List<Integer> contestents = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

		List<Integer> contestWinners = FluentIterable.from(contestents)
				.limit(5).toList();

		assertEquals(5, contestWinners.size());
	}
	
}
