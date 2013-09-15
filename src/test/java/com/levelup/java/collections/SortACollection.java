package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

public class SortACollection {
	
	private static final Logger logger = Logger.getLogger(SortACollection.class);

//	In this exercise we are going to sort a list of transaction by
//	transactions decending.  While a collection maintains order
//	it may be important sort on a web page or process nulls first.

// keywords: sort a collection in java, how to order a collection list in java	
//	http://www.polygenelubricants.com/2010/10/elegant-comparison-logic-with-guava.html
	
	
	public class Wrestler {

		private String name;
		private double weightClass;
		private int wins;

		public Wrestler(String name, double weightClass, int wins) {
			super();
			this.name = name;
			this.weightClass = weightClass;
			this.wins = wins;
		}

		public String getName() {
			return name;
		}

		public double getWeightClass() {
			return weightClass;
		}

		public int getWins() {
			return wins;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("name", name)
					.add("weightClass", weightClass).add("wins", wins)
					.toString();
		}

	}
	
	private List<Wrestler> wrestlers = Lists.newArrayList();

	@Before 
	public void setup () {
		wrestlers.add(new Wrestler("Abe", 151, 5));
		wrestlers.add(new Wrestler("Steve", 151, 7));
		wrestlers.add(new Wrestler("Jack", 151, 1));
		
		wrestlers.add(new Wrestler("Jim", 215, 15));
		wrestlers.add(new Wrestler("Jack", 215, 1));
		wrestlers.add(new Wrestler("Joe", 215, 8));
		
		wrestlers.add(new Wrestler("Harry", 119, 6));
		wrestlers.add(new Wrestler("Sally", 119, 9));

	}
	
	
	// display wrestlers by weight class
	@Test
	public void sort_collection_with_java () {
		
		Comparator<Wrestler> byWeightClass = new Comparator<Wrestler>() {
		    public int compare(Wrestler left, Wrestler right) {
		        return Double.compare(left.getWeightClass(), right.getWeightClass()) ; // use your logic
		    }
		};
		
		Collections.sort(wrestlers, byWeightClass);
		
		logger.info(wrestlers);
		
	}
	
//	The ordering class is an enhanced comparator, with additional methods to support common operations. 
//	If are familiar with the FluentIterable, FluentIterable is to Iterable as Ordering is to comparator.
	
	// Lets first create a couple of comparators
	static final Ordering<Wrestler> byWeightClass = new Ordering<Wrestler>() {
		public int compare(Wrestler left, Wrestler right) {
			return Doubles.compare(left.getWeightClass(),
					right.getWeightClass());
		}
	};

	static final Ordering<Wrestler> byName = new Ordering<Wrestler>() {
		public int compare(Wrestler left, Wrestler right) {
			return left.getName().equals(right.getName()) ? 1 : 0;
		}
	};

	static final Ordering<Wrestler> byWins = new Ordering<Wrestler>() {
		public int compare(Wrestler left, Wrestler right) {
			return Ints.compare(left.getWins(), right.getWins());
		}
	};
	
	
	// display wrestlers by weight class
	@Test
	public void sort_collection_with_guava () {
		
		Collections.sort(wrestlers, byWeightClass);
		
		//wrestlers = [Wrestler{name=Harry, weightClass=119.0}, Wrestler{name=Sally, weightClass=119.0}, Wrestler{name=Abe, weightClass=151.0}, Wrestler{name=Steve, weightClass=151.0}, Wrestler{name=Jack, weightClass=151.0}, Wrestler{name=Jim, weightClass=215.0}, Wrestler{name=Jack, weightClass=215.0}, Wrestler{name=Joe, weightClass=215.0}]
		
		Wrestler aWrestlerWithLowestWeight  = Iterables.getFirst(wrestlers, null);

		assertNotNull(aWrestlerWithLowestWeight);
		assertEquals(119, aWrestlerWithLowestWeight.getWeightClass(), 0);
	}
	
	// Display a wrestlers by name and show weight class
	@Test
	public void display_wrestlers_by_weightclass_and_in_alphabetical_order () {

		Collections.sort(wrestlers, byName);
		
		for (Wrestler wrestler : wrestlers) {
			logger.info(wrestler.toString());
		}
		
//		Abe : 151.0
//		Steve : 151.0
//		Jack : 151.0
//		Jim : 215.0
//		Jack : 215.0
//		Joe : 215.0
//		Harry : 119.0
//		Sally : 119.0
		
	}


	// Display wrestlers from highest weight class to lowest
	@Test
	public void sort_collection_in_reverse_with_guava () {
		
		Collections.sort(wrestlers, byWeightClass.reverse());
		
		//wrestlers = [Wrestler{name=Harry, weightClass=119.0}, Wrestler{name=Sally, weightClass=119.0}, Wrestler{name=Abe, weightClass=151.0}, Wrestler{name=Steve, weightClass=151.0}, Wrestler{name=Jack, weightClass=151.0}, Wrestler{name=Jim, weightClass=215.0}, Wrestler{name=Jack, weightClass=215.0}, Wrestler{name=Joe, weightClass=215.0}]
		
		Wrestler aWrestlerWithHighestWeightClass  = Iterables.getFirst(wrestlers, null);

		assertNotNull(aWrestlerWithHighestWeightClass);
		assertEquals(215, aWrestlerWithHighestWeightClass.getWeightClass(), 0);
	}

	// display a list of wrestlers by order of weight class and wins
	@Test
	public void sort_collection_with_multiple_comparables_guava () {
		
		Collections.sort(wrestlers, byWeightClass.compound(byWins));
		
//		wrestlers = 
//		[Wrestler{name=Sally, weightClass=119.0, wins=9}, 
//		 Wrestler{name=Harry, weightClass=119.0, wins=6}, 
//		 Wrestler{name=Steve, weightClass=151.0, wins=7}, 
//		 Wrestler{name=Abe, weightClass=151.0, wins=5}, 
//		 Wrestler{name=Jack, weightClass=151.0, wins=1}, 
//		 Wrestler{name=Jim, weightClass=215.0, wins=15}, 
//		 Wrestler{name=Joe, weightClass=215.0, wins=8}, 
//		 Wrestler{name=Jack, weightClass=215.0, wins=1}]
		
		Wrestler aLowestWeightClassWrestler  = Iterables.getFirst(wrestlers, null);

		assertNotNull(aLowestWeightClassWrestler);
		assertEquals(119, aLowestWeightClassWrestler.getWeightClass(), 0);
		
	}
	
	// Display top wrestlers in each weight class
	@Test
	public void sort_collection_with_multiple_comparables_guava_getfirstElement () {
	
		// first order elements
		Collections.sort(wrestlers, byWeightClass.compound(byWins.reverse()));
		
		// next get the first wrestler in each weight class which should have the most wins
		ImmutableListMultimap<Double, Wrestler> wrestlersMappedByWeightClass = Multimaps.index(wrestlers, new Function <Wrestler, Double> () {
			  public Double apply(Wrestler from) {
			    return new Double(from.getWeightClass()); 
		}});

//		wrestlersMappedByWeightClass = 
//		{119.0=[Wrestler{name=Sally, weightClass=119.0, wins=9}, Wrestler{name=Harry, weightClass=119.0, wins=6}], 
//		 151.0=[Wrestler{name=Steve, weightClass=151.0, wins=7}, Wrestler{name=Abe, weightClass=151.0, wins=5}, Wrestler{name=Jack, weightClass=151.0, wins=1}], 
//		 215.0=[Wrestler{name=Jim, weightClass=215.0, wins=15}, Wrestler{name=Joe, weightClass=215.0, wins=8}, Wrestler{name=Jack, weightClass=215.0, wins=1}]}

		// for each weight class get the first element which should be wrestler with most wins
		for (Double weightClass : wrestlersMappedByWeightClass.keySet()) {

			List<Wrestler> weightClassWrestlers = wrestlersMappedByWeightClass.get(weightClass);
			logger.info(weightClass + " - " + Iterables.getFirst(weightClassWrestlers, null));
		}
		
//		119.0 - Wrestler{name=Sally, weightClass=119.0, wins=9}
//		151.0 - Wrestler{name=Steve, weightClass=151.0, wins=7}
//		215.0 - Wrestler{name=Jim, weightClass=215.0, wins=15}
	}
	
	
	
}
