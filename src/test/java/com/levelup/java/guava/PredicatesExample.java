package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate guava 
 * predicates.  Before you begin using functions
 * be sure to read Caveats <a href="https://code.google.com/p/guava-libraries/wiki/FunctionalExplained">Functional Explained</a>
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-predicates-example/'>Predicates example</a>
 * 
 */
public class PredicatesExample {

	private static final Logger logger = Logger.getLogger(PredicatesExample.class);
	
	class HTMLElement {
		
		public HTMLElement(String tagName) {
			super();
			this.tagName = tagName;
		}

		private String tagName;
		
		@Override
		public String toString() {
			return Objects.toStringHelper(HTMLElement.class)
					.add("tagName", tagName)
					.toString();
		}

		public String getTagName() {
			return tagName;
		}
		
	}
	
	Predicate<HTMLElement> byAnchor = new Predicate<HTMLElement>() {
		public boolean apply(HTMLElement input) {
			return input.getTagName().startsWith("a");
		}
	};
	
	@Test 
	public void filter_collection_with_predicate () {
		
		List<HTMLElement> htmlElements = Lists.newArrayList(
				new HTMLElement("a:link"), 
				new HTMLElement("a:visited"), 
				new HTMLElement("a:hover"), 
				new HTMLElement("a:active"), 
				new HTMLElement("a:focus"), 
				new HTMLElement("a:focus:hover"), 
				new HTMLElement("p"), 
				new HTMLElement("p:first-letter"),
				new HTMLElement("p:first-line")
			);

		Collection<HTMLElement> anchors = Collections2.filter(htmlElements, byAnchor);
		
		logger.info(anchors);
		
		assertEquals(6, anchors.size());
	}

	@Test
	public void filter_empty_null_elements() {

		List<String> words = Lists.newArrayList(
				"", null, "do", "not", "cry",
				null, "over", "spilt", "beer");

		Predicate<String> NOT_EMPTY = new Predicate<String>() {
			@Override
			public boolean apply(String arg0) {
				return !arg0.isEmpty();
			}
		};

		Iterable<String> filteredWords = 
				Iterables.filter(words,
						Predicates.
						and(Predicates.notNull(), 
								NOT_EMPTY));

		logger.info(filteredWords);
		
		assertThat(filteredWords, IsIterableContainingInOrder.
				<String>contains("do", "not", "cry",
						"over", "spilt", "beer"));

	}
	
	
	/**
	 * {@link CharMatcher} implements predicate but has special syntax.
	 */
	@Test
	public void charmatcher_implements_predicate () {

		String theDigits = CharMatcher
				.DIGIT
				.retainFrom("ACB 132, ABC 123"); // only the digits

		assertEquals("132123", theDigits);
	}
	
}
