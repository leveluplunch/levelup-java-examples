package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate junit 
 * test while using hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-test-numbers-hamcrest/'>Unit test numbers</a>
 * 
 */
public class NumberMatchers {

	@Test
	public void item_close_to () {
		assertThat(200.24, is(closeTo(200, 1)));
	}
	
	@Test
	public void item_greaterthan () {
		assertThat(20, greaterThan(18));
	}
	
	@Test
	public void everyitem_in_list_greaterthan () {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30);
		assertThat(ages, everyItem(greaterThan(18)));
	}
	
	@Test
	public void everyitem_in_list_greaterthan_or_equal_to () {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30, 18);
		assertThat(ages, everyItem(greaterThanOrEqualTo(18)));
	}

	@Test
	public void everyitem_in_list_lessthan () {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30);
		assertThat(ages, everyItem(lessThan(31)));
	}

	
	@Test
	public void everyitem_in_list_lessthan_or_equal_to () {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30, 18);
		assertThat(ages, everyItem(lessThanOrEqualTo(30)));
	}

	
}
