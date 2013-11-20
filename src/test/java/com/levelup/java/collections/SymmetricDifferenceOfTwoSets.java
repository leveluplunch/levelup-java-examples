package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * This java example will demonstrate finding 
 * the symmetric difference of two sets.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/symmetric-difference-of-two-sets/'>Symmetric difference of two sets</a>
 */
public class SymmetricDifferenceOfTwoSets {

	private static final Logger logger = Logger.getLogger(SymmetricDifferenceOfTwoSets.class);
	
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
	public void symmetric_set_difference_java () {

		Set<String> yourFriendsOrMyFriends = new HashSet<String>(yourFriends);
		yourFriendsOrMyFriends.addAll(myFriends);
		
		logger.info(yourFriendsOrMyFriends.size()); //16
		logger.info(yourFriendsOrMyFriends); 
		
		Set<String> tmp = new HashSet<String>(yourFriends);
		tmp.retainAll(myFriends);
		yourFriendsOrMyFriends.removeAll(tmp);

		assertEquals(12, yourFriendsOrMyFriends.size());
	}
	
	@Test
	public void symmetric_set_difference_guava () {
		Set<String> yourFriendsOrMyFriends = Sets.symmetricDifference(yourFriends, myFriends);
		
		assertEquals(12, yourFriendsOrMyFriends.size());
	}
	
	@Test
	public void symmetric_set_difference_apache_commons () {
		
		@SuppressWarnings("rawtypes")
		Collection yourFriendsOrMyFriends = CollectionUtils.disjunction(yourFriends, myFriends);
		
		assertEquals(12, yourFriendsOrMyFriends.size());
	}
}
