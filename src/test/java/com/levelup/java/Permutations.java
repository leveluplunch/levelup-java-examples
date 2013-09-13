package com.levelup.java;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Permutations {

//	https://www.khanacademy.org/math/probability/probability-and-combinatorics-topic/permutations_and_combinations/v/permutations	
	
//"My fruit salad is a combination of apples, grapes and bananas" We don't care what order the fruits are in, they could also be "bananas, grapes and apples" or "grapes, apples and bananas", its the same fruit salad.
//	 
//"The combination to the safe was 472". Now we do care about the order. "724" would not work, nor would "247". It has to be exactly 4-7-2.
//So, in Mathematics we use more precise language:
//
//If the order doesn't matter, it is a Combination.
//If the order does matter it is a Permutation.	
	
	
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
