package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate removing the last element from array.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/remove-last-element-from-array/'>Remove
 *      last element from array</a>
 * 
 */
public class RemoveLastElementInArray {

	private static final Logger logger = Logger
			.getLogger(RemoveElementFromArray.class);

	@Test
	public void drop_last_element_java() {

		String[] lastElementRemoved = { "one", "two", "three" };

		String[] removedElement = Arrays.copyOf(lastElementRemoved, 2);

		logger.info(Arrays.toString(removedElement));

		assertEquals(2, removedElement.length);
	}
}
