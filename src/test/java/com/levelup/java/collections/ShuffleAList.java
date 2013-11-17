package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate how to shuffle
 * elements in list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/shuffle-randomize-order-elements-in-list/'>Shuffle elements in list</a>
 */
public class ShuffleAList {
	
	private static final Logger logger = Logger.getLogger(ShuffleAList.class);

	@Test
	public void shuffle_a_list_java () {
		
		List<String> deckOfCards = new ArrayList<String>();

		deckOfCards.addAll(
				Arrays.asList(
					"Ace", "2", "3", "4", 
					"5", "6", "7", "8", 
					"9", "10", "Jack", 
					"Queen", "King"));
		
		Collections.shuffle(deckOfCards);
		
		logger.info(deckOfCards);
	
		assertThat(deckOfCards, containsInAnyOrder(
				"Ace", "2", "3", "4", 
				"5", "6", "7", "8", 
				"9", "10", "Jack", 
				"Queen", "King"));
		
	}
	

}
