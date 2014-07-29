package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * This java example will demonstrate how to convert a map to string with seperator .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-map-value-key-entries-to-string-with-separator/'>Convert map to string</a>
 */
public class ConvertMapToString {

	private Map<String, Double> bookAndPrice = new HashMap<>();

	@Before
	public void setUp() {
		bookAndPrice.put("Delancey: A Man, a Woman, a Restaurant, a Marriage",
				18.63);
		bookAndPrice.put("Whole-Grain Mornings: New Breakfast Recipes to Span",
				13.92);
		bookAndPrice.put("Greg Atkinsons In Season: Culinary Adventures of a",
				15.57);
	}

	@Test
	public void convert_map_to_string_java() {

		String seperator = ", ";
		String keyValueSeparator = " cost ";

		StringBuffer buffer = new StringBuffer();

		Iterator<Entry<String, Double>> entryIterator = bookAndPrice.entrySet()
				.iterator();

		while (entryIterator.hasNext()) {

			Entry<String, Double> entry = entryIterator.next();

			buffer.append(entry.getKey());
			buffer.append(keyValueSeparator);
			buffer.append(entry.getValue());

			if (entryIterator.hasNext()) {
				buffer.append(seperator);
			}
		}
		assertEquals(
				"Delancey: A Man, a Woman, a Restaurant, a Marriage cost 18.63, "
						+ "Whole-Grain Mornings: New Breakfast Recipes to Span cost 13.92, "
						+ "Greg Atkinsons In Season: Culinary Adventures of a cost 15.57",
				buffer.toString());

	}

	@Test
	public void convert_map_to_string_guava() {

		String mapJoined = Joiner.on(", ").withKeyValueSeparator(" cost ")
				.join(bookAndPrice);

		assertEquals(
				"Delancey: A Man, a Woman, a Restaurant, a Marriage cost 18.63, "
						+ "Whole-Grain Mornings: New Breakfast Recipes to Span cost 13.92, "
						+ "Greg Atkinsons In Season: Culinary Adventures of a cost 15.57",
				mapJoined);

	}
}
