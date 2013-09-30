package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * This java example will demonstrate Google MultiSet.
 * 
 * MultiSets allow you to easily count elements within a list
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>Multi Set Example</a>
 * 
 */
public class MultisetExample {

	@Test
	public void multiset_example () {
		
		Multiset<String> camouflage = HashMultiset.create();
		camouflage.add("Realtree APG");
		camouflage.add("Realtree Hardwoods HD");
		camouflage.add("Realtree APG");
		camouflage.add("Realtree Hardwoods Green HD");
		camouflage.add("Mossy Oak New Break-Up");
		camouflage.add("Realtree APG");
		
		int numberOfRealTrees = camouflage.count("Realtree APG");
		
		// numberOfRealTrees = 3
		
		assertEquals(3, numberOfRealTrees);
	}
}
