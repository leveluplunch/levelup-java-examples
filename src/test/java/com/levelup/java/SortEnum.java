package com.levelup.java;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * This java example will demonstrate how to sort an enum.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/sorting-enum/'>Sort Enum</a>
 */
public class SortEnum {

	private static final Logger logger = Logger.getLogger(SortEnum.class);

	enum Fruit {
		ORANGE, APPLE, BANANAS, CHERRIES;
	}

	List<Fruit> RANDOM_FRUIT = Lists.newArrayList(Fruit.CHERRIES, Fruit.ORANGE,
			Fruit.APPLE, Fruit.CHERRIES, Fruit.BANANAS, Fruit.ORANGE);

	@Test
	public void sort_enum_with_java() {
		TreeSet<Fruit> sorted = new TreeSet<>(Comparator.comparing(Enum::name));
		sorted.addAll(RANDOM_FRUIT);

        logger.info(sorted);
		assertThat(
				sorted,
				contains(Fruit.APPLE, Fruit.BANANAS, Fruit.CHERRIES, Fruit.ORANGE));
	}

	@Test
	public void create_drop_down() {

		Ordering<Fruit> byFruitAlphabetical = Ordering.explicit(Fruit.APPLE,
				Fruit.BANANAS, Fruit.CHERRIES, Fruit.ORANGE);

		List<Fruit> dropDown = byFruitAlphabetical.sortedCopy(Arrays
				.asList(Fruit.values()));

		logger.info(dropDown);

		assertThat(
				dropDown,
				contains(Fruit.APPLE, Fruit.BANANAS, Fruit.CHERRIES,
						Fruit.ORANGE));
	}

	@Test
	public void sort_enum_with_guava() {

		Ordering<Fruit> byFruitAlphabetical = Ordering.explicit(Fruit.APPLE,
				Fruit.BANANAS, Fruit.CHERRIES, Fruit.ORANGE);

		List<Fruit> fruitAlphabetical = byFruitAlphabetical
				.sortedCopy(RANDOM_FRUIT);

		logger.info(fruitAlphabetical);

		assertThat(
				fruitAlphabetical,
				contains(Fruit.APPLE, Fruit.BANANAS, Fruit.CHERRIES,
						Fruit.CHERRIES, Fruit.ORANGE, Fruit.ORANGE));

	}
}
