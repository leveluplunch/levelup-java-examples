package com.levelup.java.util.stream;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate operations on a stream that are considered
 * terminal.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/stream-terminal-operations-example/'>Strea
 *      m terminal operations</a>
 */
public class StreamTerminalExample {

	@Test
	public void terminal_operation_foreach() {

		Stream.of("Hello", "World").forEach(p -> System.out.println(p));
	}

	@Test
	public void terminal_operation_toArray() {

		Object[] objects = Stream.of(1, 2).toArray();

		assertTrue(objects.length == 2);
	}

	@Test
	public void terminal_operation_reduce() {

		int sum = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);

		assertEquals(10, sum);
	}

	@Test
	public void terminal_operation_collect() {

		Set<String> stringSet = Stream.of("some", "one", "some", "one")
				.collect(Collectors.toSet());

		assertThat(stringSet, contains("some", "one"));

		assertTrue(stringSet.size() == 2);
	}

	@Test
	public void terminal_operation_min() {

		OptionalInt minimum = IntStream.of(1, 2, 3).min();

		assertEquals(1, minimum.getAsInt());
	}

	@Test
	public void terminal_operation_max() {

		OptionalDouble max = Stream.of(1d, 2d, 3d)
				.mapToDouble(Double::doubleValue).max();

		assertEquals(3, max.getAsDouble(), 0);
	}

	@Test
	public void terminal_operation_count() {

		long count = Stream.of("one").count();

		assertEquals(1, count);
	}

	@Test
	public void terminal_operation_anymatch() {

		boolean lengthOver5 = Stream.of("two", "three", "eighteen").anyMatch(
				s -> s.length() > 5);

		assertTrue(lengthOver5);
	}

	@Test
	public void terminal_operation_allmatch() {

		List<String> cookies = Lists.newArrayList("Peanut Butter Cookies",
				"Oatmeal-Raisin Cookies", "Basic Chocolate Chip Cookies");

		boolean containCookies = cookies.stream().allMatch(
				p -> p.contains("Cookies"));

		assertTrue(containCookies);
	}

	@Test
	public void terminal_operation_nonematch() {

		boolean noElementEqualTo5 = IntStream.of(1, 2, 3)
				.noneMatch(p -> p == 5);

		assertTrue(noElementEqualTo5);
	}

	@Test
	public void terminal_operation_findfirst() {

		Optional<String> val = Stream.of("one", "two").findFirst();

		assertEquals("one", val.get());
	}

	@Test
	public void terminal_operation_findany() {

		Optional<String> val = Stream.of("one", "two").findAny();

		assertEquals("one", val.get());
	}
}
