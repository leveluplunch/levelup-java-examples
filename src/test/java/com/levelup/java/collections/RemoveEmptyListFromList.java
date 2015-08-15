package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate removing an empty list from list
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/remove-empty-arraylist-from-list/'>Remove
 *      empty list from list</a>
 * 
 */
public class RemoveEmptyListFromList {

	@Test
	public void remove_empty_lists_java() {

		List<List<String>> removeAllEmpty = Lists.newArrayList();
		removeAllEmpty.add(Arrays.asList("abc", "def"));
		removeAllEmpty.add(Arrays.asList("ghi"));
		removeAllEmpty.add(Arrays.asList());

		for (Iterator<List<String>> it = removeAllEmpty.iterator(); it
				.hasNext();) {
			List<String> elem = it.next();
			if (elem.isEmpty()) {
				it.remove();
			}
		}
		assertEquals(2, removeAllEmpty.size());
	}

	@Test
	public void remove_empty_lists_java8() {

		List<List<String>> removeEmpty = Lists.newArrayList();
		removeEmpty.add(Arrays.asList("abc", "def"));
		removeEmpty.add(Arrays.asList("ghi"));
		removeEmpty.add(Arrays.asList());

		removeEmpty.removeIf(e -> e.isEmpty());

		assertEquals(2, removeEmpty.size());
	}

}
