package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.*;
import static org.hamcrest.number.OrderingComparison.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.BigDecimalCloseTo.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate testing
 * numbers with junit hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-number-testing-hamcrest/'>Unit test numbers</a>
 * 
 */
public class NumberMatchers {

	@Test
	public void number_close_to_number () {
		assertThat(200.24, is(closeTo(200, 1)));
	}
	
	@Test
	public void number_greaterthan () {
		assertThat(20, greaterThan(18));
	}
	
	@Test
	public void everyitem_in_list_greaterthan_number () {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30);
		assertThat(ages, everyItem(greaterThan(18)));
	}
	
	@Test
	public void everyitem_in_list_greaterthan_or_equal_to_number () {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30, 18);
		assertThat(ages, everyItem(greaterThanOrEqualTo(18)));
	}

	@Test
	public void everyitem_in_list_lessthan_number() {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30);
		assertThat(ages, everyItem(lessThan(31)));
	}

	
	@Test
	public void everyitem_in_list_lessthan_or_equal_to_number () {
		 
		List<Integer> ages = Lists.newArrayList(21, 25, 30, 18);
		assertThat(ages, everyItem(lessThanOrEqualTo(30)));
	}

	@Test
	public void bigdecimal_is_close_to_bigdecimal () {
		
		BigDecimal seniorCitizen = new BigDecimal(65);
		
		// is close to retirement 
		assertThat(new BigDecimal(60), is(closeTo(seniorCitizen, new BigDecimal(5))));
	
	}
	
	
}
