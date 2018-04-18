package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

/**
 * This java example will demonstrate how to sort a collection
 * 
 * @author Justin Musgrove
 * @see <a
 *      href='http://www.leveluplunch.com/java/examples/sort-a-collection/'>Sort
 *      a collection</a>
 * 
 */
public class SortACollection {

	private static final Logger logger = Logger
			.getLogger(SortACollection.class);

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
	public void setup() {
		wrestlers.add(new Wrestler("Abe", 151, 5));
		wrestlers.add(new Wrestler("Steve", 151, 7));
		wrestlers.add(new Wrestler("Jack", 151, 1));

		wrestlers.add(new Wrestler("Jim", 215, 15));
		wrestlers.add(new Wrestler("Jack", 215, 1));
		wrestlers.add(new Wrestler("Joe", 215, 8));

		wrestlers.add(new Wrestler("Harry", 119, 6));
		wrestlers.add(new Wrestler("Sally", 119, 9));

	}

	/**
	 * Display wrestlers by weight class
	 */
	@Test
	public void sort_collection_with_java() {

		Comparator<Wrestler> byWeightClass = new Comparator<Wrestler>() {
			public int compare(Wrestler left, Wrestler right) {
				return Double.compare(left.getWeightClass(),
						right.getWeightClass()); // use your logic
			}
		};

		Collections.sort(wrestlers, byWeightClass);

		logger.info(wrestlers);

		Wrestler wrestler = wrestlers.get(0);
		assertEquals(119, wrestler.weightClass, 0);
	}

	@Test
	public void sort_collection_with_java8_byweight() {

		wrestlers.sort((w1, w2) -> Double.compare(w1.getWeightClass(),
				w2.getWeightClass()));

		logger.info(wrestlers);

		Optional<Wrestler> wrestler = wrestlers.stream().findFirst();

		assertEquals(119, wrestler.get().getWeightClass(), 0);
	}

	@Test
	public void sort_collection_with_java8_byweight_reverse() {

		Comparator<Wrestler> normal = ((w1, w2) -> Double.compare(
				w1.getWeightClass(), w2.getWeightClass()));

		Comparator<Wrestler> reversed = normal.reversed();

		wrestlers.sort(reversed);

		logger.info(wrestlers);

		Optional<Wrestler> wrestler = wrestlers.stream().findFirst();

		assertEquals(215, wrestler.get().getWeightClass(), 0);
	}

	@Test
	public void sort_collection_with_java8_byname() {

		wrestlers.sort((w1, w2) -> w1.getName().compareTo(w2.getName()));

		logger.info(wrestlers);

		Optional<Wrestler> wrestler = wrestlers.stream().findFirst();

		assertEquals("Abe", wrestler.get().getName());
	}

    @Test
    public void sort_collection_with_java8_byweight_wins_lambda() {
        Comparator<Wrestler> byWeightByWins = (o1, o2) -> {
            if (Double.compare(o1.weightClass, o2.weightClass) != 0) {
                return Double.compare(o1.weightClass, o2.weightClass);
            } else {
                return Integer.compare(o1.wins, o2.wins);
            }
        };
        List<Wrestler> sorted = wrestlers
                .stream()
                .sorted(byWeightByWins)
                .collect(Collectors.toList());
        logger.info(sorted);

        Optional<Wrestler> wrestler = sorted.stream().findFirst();

        assertEquals(119, wrestler.get().getWeightClass(), 0);
        assertEquals(6, wrestler.get().getWins());

    }

	@Test
	public void sort_collection_with_java8_byweight_wins() {
		List<Wrestler> sorted = wrestlers
				.stream()
				.sorted(Comparator.comparingDouble(Wrestler::getWeightClass).thenComparingInt(Wrestler::getWins))
				.collect(Collectors.toList());
		logger.info(sorted);

		Optional<Wrestler> wrestler = sorted.stream().findFirst();

		assertEquals(119, wrestler.get().getWeightClass(), 0);
		assertEquals(6, wrestler.get().getWins());
	}

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

	/**
	 * Display wrestlers by weight class
	 */
	@Test
	public void sort_collection_with_guava() {

		Collections.sort(wrestlers, byWeightClass);

		logger.info(wrestlers);

		Wrestler aWrestlerWithLowestWeight = Iterables
				.getFirst(wrestlers, null);

		assertNotNull(aWrestlerWithLowestWeight);
		assertEquals(119, aWrestlerWithLowestWeight.getWeightClass(), 0);
	}

	/**
	 * Display a wrestlers by name and show weight class
	 */
	@Test
	public void display_wrestlers_by_weightclass_and_in_alphabetical_order() {

		Collections.sort(wrestlers, byName);

		logger.info(wrestlers);

		Wrestler firstAlphabetically = Iterables.getFirst(wrestlers, null);

		assertNotNull(firstAlphabetically);
		assertEquals("Abe", firstAlphabetically.getName());
	}

	/**
	 * Display wrestlers from highest weight class to lowest
	 */
	@Test
	public void sort_collection_in_reverse_with_guava() {

		Collections.sort(wrestlers, byWeightClass.reverse());

		logger.info(wrestlers);

		Wrestler aWrestlerWithHighestWeightClass = Iterables.getFirst(
				wrestlers, null);

		assertNotNull(aWrestlerWithHighestWeightClass);
		assertEquals(215, aWrestlerWithHighestWeightClass.getWeightClass(), 0);
	}

	/**
	 * display a list of wrestlers by order of weight class and wins
	 */
	@Test
	public void sort_collection_with_multiple_comparables_guava() {

		Collections.sort(wrestlers, byWeightClass.compound(byWins));

		logger.info(wrestlers);

		Wrestler aLowestWeightClassWrestler = Iterables.getFirst(wrestlers,
				null);

		assertNotNull(aLowestWeightClassWrestler);
		assertEquals(119, aLowestWeightClassWrestler.getWeightClass(), 0);

	}

	/**
	 * Display top wrestlers in each weight class
	 */
	@Test
	public void sort_collection_with_multiple_comparables_guava_getfirstElement() {

		// first order elements
		Collections.sort(wrestlers, byWeightClass.compound(byWins.reverse()));

		// next get the first wrestler in each weight class which should have
		// the most wins
		ImmutableListMultimap<Double, Wrestler> wrestlersMappedByWeightClass = Multimaps
				.index(wrestlers, new Function<Wrestler, Double>() {
					public Double apply(Wrestler from) {
						return new Double(from.getWeightClass());
					}
				});

		logger.info(wrestlersMappedByWeightClass);

		// for each weight class get the first element which should be wrestler
		// with most wins
		for (Double weightClass : wrestlersMappedByWeightClass.keySet()) {

			List<Wrestler> weightClassWrestlers = wrestlersMappedByWeightClass
					.get(weightClass);
			logger.info(weightClass + " - "
					+ Iterables.getFirst(weightClassWrestlers, null));
		}
	}

}
