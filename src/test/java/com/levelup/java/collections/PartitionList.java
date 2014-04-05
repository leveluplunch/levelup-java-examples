package com.levelup.java.collections;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate partitioning a list, or breaking a list
 * into sublists based on specified size.
 * 
 * @author Justin Musgrove
 * @see <a
 *      href='http://www.leveluplunch.com/java/examples/partition-list/'>Partiti
 *      o n a list</a>
 * 
 */
public class PartitionList {

	private static final Logger logger = Logger.getLogger(PartitionList.class);

	List<String> playerDecisions = Lists.newArrayList("Hit", "Stand",
			"Double down", "Split", "Surrender");

	@Test
	public void partition_list_java() {

		List<List<String>> decisionsBy2 = new ArrayList<List<String>>();

		final int sizeOfList = playerDecisions.size();
		final int breakApart = 2;

		for (int i = 0; i < sizeOfList; i += breakApart) {
			decisionsBy2.add(new ArrayList<String>(playerDecisions.subList(i,
					Math.min(sizeOfList, i + breakApart))));
		}

		logger.info(decisionsBy2);

		assertThat(decisionsBy2.get(0), hasItems("Hit", "Stand"));
		assertThat(decisionsBy2.get(1), hasItems("Double down", "Split"));
		assertThat(decisionsBy2.get(2), hasItems("Surrender"));
	}

	@Test
	public void partition_list_java8() {

		Predicate<String> startWithS = p -> p.toLowerCase().startsWith("s");

		Map<Boolean, List<String>> decisionsByS = playerDecisions.stream()
				.collect(Collectors.partitioningBy(startWithS));

		logger.info(decisionsByS);

		assertTrue(decisionsByS.get(Boolean.TRUE).size() == 3);
	}

	@Test
	public void partition_list_guava() {

		List<List<String>> decisionsBy2 = Lists.partition(playerDecisions, 2);

		logger.info(decisionsBy2);

		assertThat(decisionsBy2.get(0), hasItems("Hit", "Stand"));
		assertThat(decisionsBy2.get(1), hasItems("Double down", "Split"));
		assertThat(decisionsBy2.get(2), hasItems("Surrender"));
	}

	@Ignore("Will be released in collections 4")
	@Test
	public void partition_list_apache_commons() {
		// TODO not yet released, collections 4
		// ListUtils.partition(playerDecisions, 2)
		// http://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/ListUtils.html#partition(java.util.List,
		// int)
	}
}
