package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * This java example will demonstrate finding
 * the difference between two sets.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/difference-of-two-sets/'>Difference of two sets</a>
 */
public class DifferenceOfTwoSets {
	
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
	public void difference_of_sets_java () {
		
		Set<String> possibleFriendRequests = new HashSet<String>(yourFriends);
		possibleFriendRequests.removeAll(myFriends);

		assertEquals(6, possibleFriendRequests.size());
	}
	
	@Test
	public void difference_of_sets_guava () {
		
		Set<String> possibleFriendRequests = Sets.difference(yourFriends, myFriends);
		
		assertEquals(6, possibleFriendRequests.size());
	}
	
	@Test
	public void difference_of_sets_apache () {

		@SuppressWarnings("rawtypes")
		Collection possibleFriendRequests = CollectionUtils.subtract(yourFriends, myFriends);
		
		assertEquals(6, possibleFriendRequests.size());
	}
	
}
