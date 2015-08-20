package com.levelup.java.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * This java example will demonstrate getting the random element in a list.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/get-random-element-in-arraylist/'>Random
 *      value in list</a>
 * 
 */
public class GetRandomElementArrayList {

	@Test
	public void random_value_arraylist_java() {

		List<String> randomList = new ArrayList<String>();
		randomList.add("one");
		randomList.add("two");
		randomList.add("three");

		Random random = new Random();

		for (int x = 0; x < 5; x++) {
			System.out
					.println(randomList.get(random.nextInt(randomList.size())));
		}
	}

	@Test
	public void random_value_arraylist_java8() {

		List<String> randomValue = new ArrayList<String>();
		randomValue.add("one");
		randomValue.add("two");
		randomValue.add("three");

		Random random = new Random();

		IntStream.range(0, 5).forEach(
				a -> System.out.println(randomValue.get(random
						.nextInt(randomValue.size()))));
	}
}
