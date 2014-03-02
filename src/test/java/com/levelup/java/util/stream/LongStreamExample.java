package com.levelup.java.util.stream;

import static java.lang.Long.parseLong;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.junit.Test;

/**
 * This java example will demonstrate .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-stream-longstream-example/'>LongStream example</a>
 */
public class LongStreamExample {
	
	@Test
	public void longstream_builder() {

		long sum = LongStream.builder().add(10).add(10).build().sum();

		assertEquals(20, sum, 0);
	}

	@Test
	public void longstream_concat() {

		LongStream first = LongStream.builder().add(10).build();
		LongStream second = LongStream.builder().add(10).build();

		LongStream third = LongStream.concat(first, second);

		assertEquals(20, third.sum(), 0);
	}

	@Test
	public void longstream_empty() {

		LongStream emptyStream = LongStream.empty();

		assertEquals(0, emptyStream.count());
	}

	@Test
	public void longstream_generate() {

		OptionalLong one = LongStream.generate(() -> 1).limit(10)
				.distinct().findFirst();

		assertEquals(1, one.getAsLong(), 0);
	}

	@Test
	public void longstream_iterate() {

		List<Long> numbers = LongStream.iterate(0, n -> n + 3).limit(3)
				.boxed().collect(Collectors.toList());

		assertThat(numbers,
				contains(new Long(0), new Long(3), new Long(6)));
	}

	@Test
	public void longstream_of() {

		OptionalLong max = LongStream.of(5, 10).max();

		assertEquals(10, max.getAsLong(), 0);
	}

	@Test
	public void map_to_longstream() {

		List<String> longs = new ArrayList<String>();
		longs.add("1");
		longs.add("2");
		longs.add("3");

		OptionalLong longStream = longs.stream()
				.mapToLong(Long::parseLong).max();

		assertEquals(3, longStream.getAsLong(), 0);
	}

	@Test
	public void convert_to_stream_of_objects() {

		long[] numbers = { 1, 2, 3, 4, 5, 6 };

		List<Long> listOfLongs = Arrays.stream(numbers).boxed()
				.collect(Collectors.toList());

		assertThat(
				listOfLongs,
				contains(new Long(1), new Long(2), new Long(3),
						new Long(4), new Long(5), new Long(6)));

	}

	@Test
	public void provide_default() {

		List<String> longs = new ArrayList<String>();

		long optionalLong = longs.stream()
				.mapToLong(Long::parseLong).max().orElse(5);

		assertEquals(5, optionalLong, 0);
	}


}
