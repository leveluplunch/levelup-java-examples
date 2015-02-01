package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This java example will demonstrate removing last element from list
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/remove-last-element-arraylist/'>Remove
 *      last element from list</a>
 * 
 */
public class RemoveLastElementInList {

	@Test
	public void drop_last_element_java() {

		List<String> lastElementRemoved = new ArrayList<String>();
		lastElementRemoved.add("one");
		lastElementRemoved.add("two");
		lastElementRemoved.add("three");

		lastElementRemoved.remove(lastElementRemoved.size() - 1);

		assertEquals(2, lastElementRemoved.size());
	}

}
