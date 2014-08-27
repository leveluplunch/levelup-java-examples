package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * This java example will demonstrate how to convert a java array to set.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-array-to-hashset/'>Convert
 *      array to set in java</a>
 */
public class ConvertArrayToSet {

	@Test
	public void convert_array_to_set_java() {

		String[] abcs = { "a", "b", "c", "d" };

		Set<String> abcSet = new HashSet<>(Arrays.asList(abcs));

		assertTrue(abcSet.size() == 4);
	}

	@Test
	public void convert_array_to_set_guava() {

		String[] abcs = { "a", "b", "c", "d" };

		Set<String> abcSet = Sets.newConcurrentHashSet(Arrays.asList(abcs));

		assertTrue(abcSet.size() == 4);
	}

}
