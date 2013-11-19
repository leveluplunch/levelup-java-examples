package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * This java example will demonstrate finding
 * the frequency of an object within a collection.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/find-frequency-of-object-within-collection/'>Fequency of object in collection</a>
 */
public class FrequencyOfObjectInCollection {

	String randomParagraph = "Difficulty on insensible reasonable in. From as went "
			+ "he they. Preference themselves me as thoroughly partiality considered "
			+ "on in estimating. Middletons acceptance discovered projecting so is so "
			+ "or. In or attachment inquietude remarkably comparison at an. Is "
			+ "surrounded prosperous stimulated am me discretion expression. But "
			+ "truth being state can she china widow. Occasional preference fat "
			+ "remarkably now projecting uncommonly dissimilar. Sentiments projection "
			+ "particular companions interested do at my delightful. Listening newspaper "
			+ "in advantage frankness to concluded unwilling."; 
	
	List<String> words;
	
	@Before
	public void setUp () {
		
		words = Splitter.on(CharMatcher.anyOf(" ."))
				.trimResults(CharMatcher.is('.'))
				.omitEmptyStrings()
				.splitToList(randomParagraph);
	}

	@Test
	public void frequency_of_object_in_collection_java () {
		
		int numberOfOccurences = Collections.frequency(words, "me");
		
		assertEquals(2, numberOfOccurences);
	}
	
	@Test
	public void frequency_of_object_in_collection_guava () {

		int numberOfOccurences = Iterables.frequency(words, "me");
		
		assertEquals(2, numberOfOccurences);
	}
}
