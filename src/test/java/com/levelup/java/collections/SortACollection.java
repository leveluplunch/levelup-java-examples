package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

public class SortACollection {

//	In this exercise we are going to sort a list of transaction by
//	transactions decending.  While a collection maintains order
//	it may be important sort on a web page or process nulls first.

// keywords: sort a collection in java, how to order a collection list in java	
//	http://www.polygenelubricants.com/2010/10/elegant-comparison-logic-with-guava.html
	
	class Transaction {
		
		private BigDecimal id;
		private double amount;
		
		public Transaction(BigDecimal id, double amount) {
			super();
			this.id = id;
			this.amount = amount;
		}

		public BigDecimal getId() {
			return id;
		}
		public double getAmount() {
			return amount;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("id", id).add("amount", amount).toString();
		}

	}

	private List<Transaction> checkBook = Lists.newArrayList();
	
	@Before 
	public void setup () {
		
		checkBook.add(new Transaction(new BigDecimal(1), 500));
		checkBook.add(new Transaction(new BigDecimal(2), 25));
		checkBook.add(new Transaction(new BigDecimal(3), 78));
		checkBook.add(new Transaction(new BigDecimal(4), 222));
		checkBook.add(new Transaction(new BigDecimal(5), 903));
		checkBook.add(new Transaction(new BigDecimal(6), 0));
		
	}
	
	@Test
	public void sort_collection_with_java () {
		
		Comparator<Transaction> byAmount = new Comparator<Transaction>() {
		    public int compare(Transaction left, Transaction right) {
		        return Double.compare(left.getAmount(), right.getAmount()) ; // use your logic
		    }
		};
		
//		1. figure out how to chain comparators with standard java
//		Lists
//		Collections.reverseOrder() byAmount

//		Collections.sort(checkBook, ); // use the comparator as much as u want

		//[Transaction{id=903.0}, Transaction{id=500.0}, Transaction{id=222.0}, Transaction{id=78.0}, Transaction{id=25.0}]

		System.out.println(checkBook);
	}
	
//	The ordering class is an enhanced comparator, with additional methods to support common operations. 
//	If are familiar with the FluentIterable, FluentIterable is to Iterable as Ordering is to comparator.
	
	Ordering<Transaction> byAmount = new Ordering<Transaction>() {
	  public int compare(Transaction left, Transaction right) {
	    return Doubles.compare(left.getAmount(), right.getAmount());
	  }
	};
	
	// TODO determine right way to compare BigDecimal
	
	Ordering<Transaction> byId = new Ordering<Transaction>() {
	  public int compare(Transaction left, Transaction right) {
	    return Doubles.compare(left.getId().intValue(), right.getId().intValue());
	  }
	};
	
	@Test
	public void sort_collection_with_guava () {
		
		List<Transaction> highestTransactions = byAmount.greatestOf(checkBook, 3);
		
		//[Transaction{id=903.0}, Transaction{id=500.0}, Transaction{id=222.0}]
		
		Transaction highestTransaction = Iterables.getFirst(highestTransactions, null);

		assertNotNull(highestTransaction);
		assertEquals(903, highestTransaction.getAmount(), 0);
	}
	
	@Test
	public void sort_collection_with_guava_least () {
		
		List<Transaction> lowestTransactions = byAmount.leastOf(checkBook, 3);

//		System.out.println(lowestTransactions);
		
		// lowestTransactions = [Transaction{id=6, amount=0.0}, Transaction{id=2, amount=25.0}, Transaction{id=3, amount=78.0}]

		Transaction lowestTransaction = Iterables.getFirst(lowestTransactions, null);
		
		assertNotNull(lowestTransactions);
		assertEquals(0, lowestTransaction.getAmount(), 0);
		
	}
	
	// In the instance you want to chain multiple iterators together you can easily do this with guava
	// lets validate that the ordering of ids w/ comparables
	
	@Test
	public void sort_collection_with_guava_byId () {
		List<Transaction> lowestTransactionById = byId.leastOf(checkBook, 1);

		// lowestTransactionById = [Transaction{id=1, amount=500.0}]

		Transaction lowestTransaction = Iterables.getFirst(lowestTransactionById, null);
		
		assertNotNull(lowestTransactionById);
		assertEquals(new BigDecimal(1), lowestTransaction.getId());
	}
	
	
	@Test
	public void chaining_multiple_comparables_with_guava () {
		
		// the byAmount comparator is set up to order ascending
		// 		[Transaction{id=6, amount=0.0}, Transaction{id=2, amount=25.0}, Transaction{id=3, amount=78.0}, Transaction{id=4, amount=222.0}, Transaction{id=1, amount=500.0}, Transaction{id=5, amount=903.0}]
		//		[Transaction{id=6, amount=0.0}, Transaction{id=2, amount=25.0}, Transaction{id=3, amount=78.0}, Transaction{id=4, amount=222.0}, Transaction{id=1, amount=500.0}, Transaction{id=5, amount=903.0}]

		// if we compund muliple comparables (byAmount and byId)
		// we should get the lowest amount and id


		// byid
		//		[Transaction{id=1, amount=500.0}, Transaction{id=2, amount=25.0}, Transaction{id=3, amount=78.0}, Transaction{id=4, amount=222.0}, Transaction{id=5, amount=903.0}, Transaction{id=6, amount=0.0}]
		//		[Transaction{id=1, amount=500.0}, Transaction{id=2, amount=25.0}, Transaction{id=3, amount=78.0}, Transaction{id=4, amount=222.0}, Transaction{id=5, amount=903.0}, Transaction{id=6, amount=0.0}]

//		[Transaction{id=6, amount=0.0}, Transaction{id=2, amount=25.0}, Transaction{id=3, amount=78.0}, Transaction{id=4, amount=222.0}, Transaction{id=1, amount=500.0}, Transaction{id=5, amount=903.0}]

//		[Transaction{id=5, amount=903.0}, Transaction{id=1, amount=500.0}, Transaction{id=4, amount=222.0}, Transaction{id=3, amount=78.0}, Transaction{id=2, amount=25.0}, Transaction{id=6, amount=0.0}]

//		Collections.sort(checkBook, byAmount	
//										.compound(
//												byId.reverse())
//										.reverse());
//		System.out.println(checkBook);
		
//		System.out.println(byAmount.greatestOf(checkBook, 10));
//		System.out.println(byAmount.compound(byId.greatestOf(checkBook, k)).greatestOf(checkBook, 10));
		
//		Ordering.compound()
		
//		System.out.println(checkBook);
		
		// by default our comparator will byAmount
//		byAmount.compound(byId);
		
//		List<Transaction> orderedByAmountAndId = byAmount.com(checkBook, 3);

		
	}
	
//	@Test 
//	public void  
	
		
	
}
