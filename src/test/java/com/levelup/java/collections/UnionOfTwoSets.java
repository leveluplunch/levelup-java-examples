package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * This java example will demonstrate the union
 * of two sets.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/union-of-two-sets/'>Union of two sets</a>
 */
public class UnionOfTwoSets {
	
	Set<String> yourFriends = Sets.newHashSet(
			"Desiree Jagger",
			"Benedict Casteel",
			"Evon Saddler",
			"Toby Greenland", 
			"Norine Caruana",
			"Felecia Houghton",
			"Lanelle Franzoni",
			"Armandina Everitt",
			"Inger Honea", 
			"Autumn Hendriks");
	
	Set<String> myFriends = Sets.newHashSet(
			"Karrie Rutan",
			"Desiree Jagger", 
			"Armandina Everitt",
			"Arlen Nowacki",
			"Ward Siciliano",
			"Mira Yonts",
			"Marcelo Arab",
			"Autumn Hendriks",
			"Mazie Hemstreet",
			"Toby Greenland");
	
	@Test
	public void union_of_sets_java () {
		
		Set<String> totalFriends = new HashSet<String>(yourFriends);
		totalFriends.addAll(myFriends);
		
		assertEquals(16, totalFriends.size());
	}
	
	@Test
	public void union_of_sets_guava () {

		Set<String> totalFriends = Sets.union(yourFriends, myFriends);
		
		assertEquals(16, totalFriends.size());
	}
	
	@Test
	public void union_of_sets_apache () {
		
		@SuppressWarnings("unchecked")
		Collection<String> totalFriends = CollectionUtils.union(yourFriends, myFriends);
		
		assertEquals(16, totalFriends.size());
	}
	
}
