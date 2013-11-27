package com.levelup.java;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkPositionIndex;
import static com.google.common.base.Preconditions.checkState;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate fail fast concept using
 * Guava preconditions and Apache's Validate.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/check-parameters-for-validity-fail-fast-concept/'>Check parameters for validity</a>
 */
public class CheckParametersForValidity {
	
	// guava
	@Test(expected=IllegalArgumentException.class)
	public void check_argument_guava () {
		
		Integer stockPrice = 50;
		
		checkArgument(stockPrice > 50, "Stock price must be > 50");
		
		// ...
	}
	
	@Test(expected=NullPointerException.class)
	public void check_not_null_guava () {
		
		String val = null;
		
		checkNotNull(val, "val cannot be null");
		
		// ...
	}

	class Stock {
	
		private boolean initialized = false;
		
		Stock () {
			
		}
		
		void initialize () {
			this.initialized = true;
		}
	}
	
	@Test(expected=IllegalStateException.class)
	public void check_state_of_object () {
		
		Stock stock = new Stock();
		
		checkState(stock.initialized);
		
		// ...
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void check_element_index_guava () {

		List<String> stockSold = Lists.newArrayList();
		
		checkElementIndex(10, stockSold.size(), "must have 10 transactions to qualify for...");
		
		// ...
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void check_position_index_guava () {

		List<String> availableStocksForSale = Lists.newArrayList();
		
		checkPositionIndex(1, availableStocksForSale.size(), "there must be 1 availble stock for sale");

		// ...
	}
	
	// apache
	@Test(expected=IllegalArgumentException.class)
	public void check_argument_apache_commons () {
		
		Integer stockPrice = 50;
		
		Validate.isTrue(stockPrice > 50, "Stock price must be > 50");

		// ...
	}

	@Test(expected=IllegalArgumentException.class)
	public void check_not_null_apache_commons () {
		
		String val = null;
		
		Validate.notNull(val, "val cannot be null");
		
		// ...		
	}

	@Test(expected=IllegalArgumentException.class)
	public void check_position_index_apache_commons () {
		
		List<String> availableStocksForSale = Lists.newArrayList();
		
		Validate.isTrue(availableStocksForSale.size() >=1, "there must be 1 availble stock for sale");
		
		// ...	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void check_not_empty_index_apache_commons () {
		
		List<String> availableStocksForSale = Lists.newArrayList();
		
		Validate.notEmpty(availableStocksForSale, "there must be 1 availble stock for sale");
		
		// ...	
	}

}
