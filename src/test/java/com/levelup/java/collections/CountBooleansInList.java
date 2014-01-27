package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;

/**
 * This java example will demonstrate counting the occurrences of 
 * booleans in a arraylist.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-boolean-true-values-in-arraylist/'>Count booleans in list</a>
 */
public class CountBooleansInList {

	@Test
	public void count_booleans_arraylist_java () {
		
		List<Boolean> values = Lists.newArrayList(true, true, false, true, false);

		int count = 0;
		for (Boolean value : values) {
			if (value.booleanValue()) {
				count ++;
			}
		}
		
		assertEquals(3, count);
	}
	
	@Test
	public void count_booleans_arraylist_java8 () {

		List<Boolean> values = Lists.newArrayList(true, true, false, true, false);
		
		long count = values.stream().filter(p -> p == true).count();

		assertEquals(3, count);
	}
	
	@Test
	public void count_booleans_arraylist_guava () {
		
		List<Boolean> values = Lists.newArrayList(true, true, false, true, false);
		
		int count = Booleans.countTrue(Booleans.toArray(values));
		
		assertEquals(3, count);
	}

	@Test
	public void count_booleans_arraylist_apachecommons () {

		List<Boolean> values = Lists.newArrayList(true, true, false, true, false);

		int count = CollectionUtils.countMatches(values, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Boolean val = (Boolean) object;
				return val.booleanValue();
			}
		});
		
		assertEquals(3, count);
	}
}
