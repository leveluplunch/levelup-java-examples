package com.levelup.java;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Permutations {

	@Test
	public void test() {

		List<String> elements = Lists.newArrayList("b", "c", "a");
		Collection<List<String>> permutation = Collections2
				.permutations(elements);
		
		for (List<String> perm :permutation) {
			System.out.println(perm);
		}

		List<String> elements3 = Lists.newArrayList("b", "c", "a");
		System.out.println(Iterables.concat(elements, elements3));

		
	}

}
