package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * This java example will demonstrate how to join
 * strings.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/join-strings/'>Join Strings</a>
 */
public class JoinStrings {

	@Test
	public void join_strings_java8_string_joiner() {

		StringJoiner joiner = new StringJoiner("-");

		String goPackGo = joiner.add("Go").add("pack").add("Go!").toString();

		assertEquals("Go-pack-Go!", goPackGo);
	}

	@Test
	public void join_strings_java8_string_join() {

		String goPackGo = String.join("-", "Go", "pack", "Go!");

		assertEquals("Go-pack-Go!", goPackGo);
	}

	@Test
	public void join_strings_guava() {

		String goPackGo = Joiner.on("-").join("Go", "pack", "Go!");

		assertEquals("Go-pack-Go!", goPackGo);
	}

	@Test
	public void join_strings_apache() {

		String goPackGo = StringUtils.join(Arrays.asList("Go", "pack", "Go!"),
				"-");

		assertEquals("Go-pack-Go!", goPackGo);
	}
}
