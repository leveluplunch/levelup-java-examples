package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * This java example will demonstrate how to perform a reverse key lookup.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/reverse-map-lookup-flip-key-values-bimap/'>Reverse
 *      map lookup - How to get key from value?</a>
 */
public class ReverseMapLookup {

	private static final Logger logger = Logger
			.getLogger(ReverseMapLookup.class);

	@Test
	public void flip_map_entries_with_guava() {

		BiMap<String, String> stateCodeToDescription = HashBiMap.create();

		stateCodeToDescription.put("WI", "Wisconsin");
		stateCodeToDescription.put("MN", "Minnesota");
		stateCodeToDescription.put("FL", "Florida");
		stateCodeToDescription.put("IA", "Iowa");
		stateCodeToDescription.put("OH", "Ohio");

		BiMap<String, String> descriptionToStateCode = stateCodeToDescription
				.inverse();

		logger.info(descriptionToStateCode);

		assertEquals("WI", descriptionToStateCode.get("Wisconsin"));
	}

	@Test
	public void flip_map_entries_with_apachecommons() {

		BidiMap stateCodeToDescription = new DualHashBidiMap();

		stateCodeToDescription.put("WI", "Wisconsin");
		stateCodeToDescription.put("MN", "Minnesota");
		stateCodeToDescription.put("FL", "Florida");
		stateCodeToDescription.put("IA", "Iowa");
		stateCodeToDescription.put("OH", "Ohio");

		BidiMap descriptionToStateCode = stateCodeToDescription
				.inverseBidiMap();

		logger.info(descriptionToStateCode);

		assertEquals("IA", descriptionToStateCode.get("Iowa"));
	}

}
