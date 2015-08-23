package com.levelup.java.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Splitter;

/**
 * This java example will demonstrate how to split a string by a colon.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/split-string-by-colon/'
 *      > Split string by colon</a>
 */
public class SplitStringByColon {

	private static final Logger logger = Logger
			.getLogger(SplitStringByColon.class);

	@Test
	public void split_string_colon_java() {

		String[] colonArray = "This:is:a:sentence:by:colon".split(":");

		logger.info(Arrays.toString(colonArray));

		assertTrue(colonArray.length == 6);
	}

	@Test
	public void split_string_colon_java8() {

		List<String> splitByColon = Stream.of("This:is:a:sentence:by:colon")
				.map(w -> w.split(":")).flatMap(Arrays::stream)
				.collect(Collectors.toList());

		logger.info(splitByColon);

		assertTrue(splitByColon.size() == 6);
	}

	@Test
	public void split_string_colon_guava() {

		List<String> elementsInString = Splitter.on(":").splitToList(
				"This:is:a:sentence:by:colon");

		logger.info(elementsInString);

		assertEquals(6, elementsInString.size());

	}

	@Test
	public void split_string_colon_using_apache_commons() {

		String[] elementsInString = StringUtils.split(
				"This:is:a:sentence:by:colon", ":");

		logger.info(Arrays.toString(elementsInString));

		assertTrue(elementsInString.length == 6);
	}

}
