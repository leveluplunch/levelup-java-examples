package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * This java example will demonstrate how to join strings separated by commas.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/join-strings-with-comma/'>Join strings with comma</a>
 */

public class JoinStringsComma {

	@Test
	public void join_strings_java8_string_joiner() {

		StringJoiner joiner = new StringJoiner(",");

		String stringsWithCommas = joiner.add("Design").add("a")
				.add("T-shirt!").toString();

		assertEquals("Design,a,T-shirt!", stringsWithCommas);
	}

	@Test
	public void join_strings_java8_string_join() {

		String commaSeperated = String.join(",", "Design", "a", "T-shirt!");

		assertEquals("Design,a,T-shirt!", commaSeperated);
	}

	@Test
	public void join_strings_guava() {

		String commaSeperatedString = Joiner.on(",").join("Design", "a",
				"T-shirt!");

		assertEquals("Design,a,T-shirt!", commaSeperatedString);
	}

	@Test
	public void join_strings_apache() {

		String separatedByCommas = StringUtils.join(
				Arrays.asList("Design", "a", "T-shirt!"), ",");

		assertEquals("Design,a,T-shirt!", separatedByCommas);
	}

}
