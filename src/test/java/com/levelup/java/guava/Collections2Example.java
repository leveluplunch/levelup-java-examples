package com.levelup.java.guava;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.levelup.java.array.ConvertCollectionToArray;

/**
 * This java example will demonstrate common usages of
 * Google Guava Collections2 Utility.
 *  
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-collections2-utility-example/'>Collections2 utility example</a>
 */
public class Collections2Example {
	
	private static final Logger logger = Logger.getLogger(ConvertCollectionToArray.class);

	@Test
	public void filter () {
		
		List<String> strings = Lists.newArrayList(
				null, "www", null, 
				"leveluplunch", "com", null);

		
		Collection<String> filterStrings = Collections2.filter(
				strings, new Predicate<String>() {
					@Override
					public boolean apply(String input) {
						return input != null && input.length() >= 3;
					}
				});

		logger.info(filterStrings);
		
		assertEquals(3, filterStrings.size());
	}
	
	@Test
	public void ordered_permutations () {
		
		List<Integer> vals = Lists.newArrayList(1, 2, 3);
		
		Collection<List<Integer>> orderPerm = 
				Collections2.orderedPermutations(vals);
		
		for (List<Integer> val : orderPerm) {
			logger.info(val);
		}

		assertEquals(6, orderPerm.size());
	}
	
	@Test
	public void permutations () {

		List<Integer> vals = Ints.asList(new int[] {1, 2, 3});
		
		Collection<List<Integer>> orderPerm = 
				Collections2.permutations(vals);
		
		for (List<Integer> val : orderPerm) {
			logger.info(val);
		}
		
		assertEquals(6, orderPerm.size());
	}

	@Test
	public void transform () {
		
		List<String> numbersAsStrings = Lists.newArrayList(
				"1", "2", "3");
		
		Collection<Double> doubles = Collections2.transform(
				numbersAsStrings, new Function<String, Double>() {
			@Override
			public Double apply(String input) {
				return new Double(input);
			}
		});
		
		assertThat(doubles, contains(
				 new Double(1), new Double(2), 
				 new Double(3)));	
	}
	
}
