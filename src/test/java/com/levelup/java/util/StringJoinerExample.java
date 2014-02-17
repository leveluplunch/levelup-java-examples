package com.levelup.java.util;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * This java example will demonstrate how to join 
 * strings in java 8.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/stringjoiner-example/'>StringJoiner example</a>
 */
public class StringJoinerExample {

	@Test
	public void join_strings() {

		StringJoiner sj = new StringJoiner(",");

		String joinedStrings = sj.add("test").add("whatever").toString();

		assertEquals("test,whatever", joinedStrings);
	}
	
	@Test
	public void join_strings_prefix_suffix () {
		
		StringJoiner sj = new StringJoiner(",", "[", "]");

		String joinedStrings = sj.add("test").add("whatever").toString();

		assertEquals("[test,whatever]", joinedStrings);
	}

	@Test
	public void join_a_list_of_strings() {

		List<String> cloudGroups = new ArrayList<>();
		cloudGroups.add("Cirrus");
		cloudGroups.add("Alto");
		cloudGroups.add("Stratus");
		cloudGroups.add("Vertical Growth");
		cloudGroups.add("Special Clouds");

		String cloudGroupsJoined = String.join(",", cloudGroups);

		assertEquals("Cirrus,Alto,Stratus,Vertical Growth,Special Clouds",
				cloudGroupsJoined);
	}

	@Test
	public void join_a_list_of_strings_skipping_null() {

		List<String> cloudGroups = new ArrayList<>();
		cloudGroups.add("Cirrus");
		cloudGroups.add("Alto");
		cloudGroups.add(null);
		cloudGroups.add(null);
		cloudGroups.add("Stratus");
		cloudGroups.add("Vertical Growth");
		cloudGroups.add("Special Clouds");
		cloudGroups.add(null);

		String cloudGroupsJoined = cloudGroups.stream()
				.filter(Objects::nonNull).collect(Collectors.joining(","));

		assertEquals("Cirrus,Alto,Stratus," + "Vertical Growth,Special Clouds",
				cloudGroupsJoined);
	}

	@Test
	public void join_a_list_of_strings_replacing_null() {

		List<String> cloudGroups = new ArrayList<>();
		cloudGroups.add("Cirrus");
		cloudGroups.add("Alto");
		cloudGroups.add(null);
		cloudGroups.add(null);
		cloudGroups.add("Stratus");
		cloudGroups.add("Vertical Growth");
		cloudGroups.add("Special Clouds");
		cloudGroups.add(null);

		Function<String, String> replaceNull = new Function<String, String>() {
			@Override
			public String apply(String t) {
				if (t == null) {
					return "[unknown]";
				} else {
					return t;
				}
			}
		};
		
		String cloudGroupsJoined = cloudGroups.stream()
//				.map(s -> { if (s == null) return "[unknown]"; else return s;})
//				TODO determine why cast isn't working quite right
				.map(replaceNull)
				.collect(Collectors.joining(" and "));

		assertEquals("Cirrus and Alto and [unknown] and [unknown] "
				+ "and Stratus and Vertical Growth "
				+ "and Special Clouds and [unknown]", cloudGroupsJoined);
	}

}
