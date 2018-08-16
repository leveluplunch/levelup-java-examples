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
 * the intersection of two sets.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/intersection-of-two-sets/'>Intersection of two sets</a>
 */
public class IntersectionOfTwoSets {

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
	public void intersection_of_sets_java () {
		
		Set<String> mutalFriends = new HashSet<String>(yourFriends);
		mutalFriends.retainAll(myFriends);
		
		assertEquals(4, mutalFriends.size());
	}

	@Test
	public void intersection_of_sets_guava () {

		Set<String> mutualFriends = Sets.intersection(yourFriends, myFriends);

		assertEquals(4, mutualFriends.size());
	}
	
	@Test
	public void intersection_of_sets_apache_commons () {
		
		@SuppressWarnings("rawtypes")
		Collection mutalFriends = CollectionUtils.intersection(yourFriends, myFriends);
		
		assertEquals(4, mutalFriends.size());
	}
	
}
