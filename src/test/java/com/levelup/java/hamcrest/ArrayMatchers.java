package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArray.array;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * This java example will demonstrate testing
 * collections with junit hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/hamcrest-collection-matchers-junit-testing/'>Collection matchers</a>
 * 
 */
public class ArrayMatchers {

//	array
	@Test
	public void check_size_of_array () {
		
		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, arrayWithSize(3));
	}
	
	@Test
	public void array_contains_all_elements () {

		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, arrayContaining(10, 15, 20));
	}

	@Test
	public void array_contains_all_elements_in_any_order () {

		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, arrayContainingInAnyOrder(20, 10, 15));
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void check_array_elements_equal() {

		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, 
				is(array(equalTo(10), equalTo(15), equalTo(20)))); 
	}

}
