package com.levelup.java.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate finding, searching
 * or if element is contained within array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/find-element-in-array'>Find element in array</a>
 * 
 */
public class FindElementInArray {

	
	@Test
	public void search_array_java () {

		Integer[] vikQueensLosingSeasons = {
				1962, 1967, 1984, 2011, 1966,
				1963, 1982, 2001, 1990, 2002,
				2006, 2010, 1965, 1972, 1979,
				1981, 1985};
		
		boolean losingSeason = false;
		for (Integer number : vikQueensLosingSeasons) {
			if (number.equals(1962)) {
				losingSeason = true;
				break;
			}
		}

		assertTrue(losingSeason);
	}
		
	@Test
	public void search_array_java_with_list_contains_with_list_contains () {
		
		Integer[] vikQueensLosingSeasons = {
				1962, 1967, 1984, 2011, 1966,
				1963, 1982, 2001, 1990, 2002,
				2006, 2010, 1965, 1972, 1979,
				1981, 1985};
		
		boolean hadALosingSeason = Arrays
				.asList(vikQueensLosingSeasons)
				.contains(new Integer(1962));
		
		assertTrue(hadALosingSeason);
	}
	
	@Test
	public void array_contains_element_java_binary_search () {

		Integer[] vikQueensLosingSeasons = {
				1962, 1967, 1984, 2011, 1966,
				1963, 1982, 2001, 1990, 2002,
				2006, 2010, 1965, 1972, 1979,
				1981, 1985};
		
		Arrays.sort(vikQueensLosingSeasons);
		
		int elementPosition = Arrays.binarySearch(vikQueensLosingSeasons, 1962);
		
		assertTrue(elementPosition >= 0);
	}
	
	@Test
	public void array_contains_element_java_with_guava () {

		int[] vikQueensLosingSeasons = {
				1962, 1967, 1984, 2011, 1966,
				1963, 1982, 2001, 1990, 2002,
				2006, 2010, 1965, 1972, 1979,
				1981, 1985};
		
		boolean yearExists = Ints.contains(vikQueensLosingSeasons, 1972);
		
		assertTrue(yearExists);
	}
	
	@Test
	public void find__element_in_array_java_with_guava() {

		Integer[] vikQueensLosingSeasons = { 1962, 1967, 1984, 2011, 1966,
				1963, 1982, 2001, 1990, 2002, 2006, 2010, 1965, 1972, 1979,
				1981, 1985 };

		Optional<Integer> contains = Iterators.tryFind(
				Iterators.forArray(vikQueensLosingSeasons),
				new Predicate<Integer>() {

					public boolean apply(Integer input) {
						if (input == 1962) {
							return true;
						} else {
							return false;
						}
					}
				});
		
		assertTrue(contains.isPresent());
		assertEquals(new Integer(1962), contains.get());

	}
	
	
	@Test
	public void array_contains_element_java_with_apache_commons () {

		int[] vikQueensLosingSeasons = {
				1962, 1967, 1984, 2011, 1966,
				1963, 1982, 2001, 1990, 2002,
				2006, 2010, 1965, 1972, 1979,
				1981, 1985};

		boolean losingSeason = ArrayUtils.contains(vikQueensLosingSeasons, 1962);
		assertTrue(losingSeason);
	}
	
	
}
