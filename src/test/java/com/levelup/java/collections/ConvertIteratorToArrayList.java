package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.collections.IteratorUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate how to convert an Iterator to List.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-iterator-arraylist/'>Convert Iterator to ArrayList</a>
 */
public class ConvertIteratorToArrayList {

	static LinkedList<String> collection = new LinkedList<String>();

	static {
		collection.push("One");
		collection.push("Two");
		collection.push("Three");
		collection.push("Four");
	}

	@Test
	public void convert_iterator_to_list_java() {

		Iterator<String> iteratorToList = collection.iterator();

		List<String> listOfStrings = new ArrayList<String>(4);
		while (iteratorToList.hasNext()) {
			listOfStrings.add(iteratorToList.next());
		}

		assertTrue(listOfStrings.size() == 4);
	}

	@Test
	public void convert_iterator_to_list_java8() {

		Iterator<String> iteratorToCollection = collection.iterator();

		List<String> convertedIterator = StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iteratorToCollection,
						Spliterator.ORDERED), false).collect(
				Collectors.<String> toList());

		assertTrue(convertedIterator.size() == 4);

	}

	@Test
	public void convert_iterator_to_list_guava() {

		Iterator<String> iteratorToArray = collection.iterator();

		List<String> convertedIterator = Lists.newArrayList(iteratorToArray);

		assertTrue(convertedIterator.size() == 4);
	}

	@Test
	public void convert_iterator_to_list_apache() {

		Iterator<String> iteratorToArrayList = collection.iterator();

		@SuppressWarnings("unchecked")
		List<String> convertedIteratorToList = IteratorUtils
				.toList(iteratorToArrayList);

		assertTrue(convertedIteratorToList.size() == 4);
	}
}
