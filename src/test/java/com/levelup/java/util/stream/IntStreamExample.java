package com.levelup.java.util.stream;

import static java.lang.Integer.parseInt;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * This java example will demonstrate IntStream and .
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/java-util-stream-intstream-example/'>IntSt
 *      r e a m example</a>
 */
public class IntStreamExample {

	@Test
	public void intstream_builder() {

		int sum = IntStream.builder().add(10).add(10).build().sum();

		assertEquals(20, sum);
	}

	@Test
	public void intstream_concat() {

		IntStream first = IntStream.builder().add(10).build();
		IntStream second = IntStream.builder().add(10).build();

		IntStream third = IntStream.concat(first, second);

		assertEquals(20, third.sum());
	}

	@Test
	public void intstream_empty() {

		IntStream emptyStream = IntStream.empty();

		assertEquals(0, emptyStream.count());
	}

	@Test
	public void intstream_generate() {

		OptionalInt one = IntStream.generate(() -> 1).limit(10).distinct()
				.findFirst();

		assertEquals(1, one.getAsInt());
	}

	@Test
	public void intstream_iterate() {

		List<Integer> numbers = IntStream.iterate(0, n -> n + 3).limit(3)
				.boxed().collect(Collectors.toList());

		assertThat(numbers,
				contains(new Integer(0), new Integer(3), new Integer(6)));
	}

	@Test
	public void intstream_of() {

		OptionalInt max = IntStream.of(5, 10).max();

		assertEquals(10, max.getAsInt());
	}

	@Test
	public void intstream_range() {

		List<Integer> numbers = IntStream.range(1, 3).boxed()
				.collect(Collectors.toList());

		assertThat(numbers, contains(new Integer(1), new Integer(2)));
	}

	@Test
	public void intstream_rangeClosed() {

		List<Integer> numbers = IntStream.rangeClosed(1, 3).boxed()
				.collect(Collectors.toList());

		assertThat(numbers,
				contains(new Integer(1), new Integer(2), new Integer(3)));
	}

	@Test
	public void map_to_intstream() {

		List<String> integers = new ArrayList<String>();
		integers.add("1");
		integers.add("2");
		integers.add("3");

		OptionalInt intStream = integers.stream().mapToInt(Integer::parseInt)
				.max();

		assertEquals(3, intStream.getAsInt());
	}

	@Test
	public void convert_to_stream_of_objects() {

		int[] numbers = { 1, 2, 3, 4, 5, 6 };

		List<Integer> listOfInteger = Arrays.stream(numbers).boxed()
				.collect(Collectors.toList());

		assertThat(
				listOfInteger,
				contains(new Integer(1), new Integer(2), new Integer(3),
						new Integer(4), new Integer(5), new Integer(6)));

	}

	@Test
	public void provide_default() {

		List<String> integers = new ArrayList<String>();

		int optionalInt = integers.stream().mapToInt(Integer::parseInt)
				.max().orElse(5);

		assertEquals(5, optionalInt);
	}

}
