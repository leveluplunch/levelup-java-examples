package com.levelup.java.hamcrest;

import org.junit.Test;

import com.google.common.collect.Lists;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.text.IsEmptyString.*;
import static org.hamcrest.text.IsEqualIgnoringCase.*;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.*;
import static org.hamcrest.text.StringContainsInOrder.*;
import static org.junit.Assert.assertThat;

/**
 * This java example will demonstrate testing
 * strings with junit hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-text-testing-hamcrest/'>Unit test text</a>
 * 
 */
public class TextMatchers {

	@Test
	public void string_is_empty () {

		String favoriteCereal = "";
		assertThat(favoriteCereal, isEmptyOrNullString());
	}
	
	@Test
	public void string_is_empty_or_null () {
		String favoriteCereal = null;
		assertThat(favoriteCereal, isEmptyOrNullString());
	}

	@Test
	public void string_equal_to () {

		String favoriteCereal = "cinnamon life";
		assertThat(favoriteCereal, equalTo("cinnamon life"));
	}

	@Test
	public void string_equal_to_ignoring_case () {

		String favoriteCereal = "CINNAMON LIFE";
		assertThat(favoriteCereal, equalToIgnoringCase("cinnamon life"));
	}
	
	@Test
	public void string_equal_to_ignoring_whitespace () {

		String favoriteCereal = "CINNAMON LIFE          ";
		assertThat(favoriteCereal, equalToIgnoringWhiteSpace("cinnamon life"));
	}
	
	@Test
	public void string_contains () {
		
		String cereal = "mini wheats";
		assertThat(cereal, containsString("mini"));
	}
	
	@Test
	public void string_ends_with () {

		String cereal = "corn flakes";
		assertThat(cereal, endsWith("s"));
	}
	
	@Test
	public void string_starts_with () {

		String cereal = "honey smacks";
		assertThat(cereal, containsString("honey"));
	}

	@Test
	public void string_has_order () {
		
		String cereal = "apple jacks";
		assertThat(cereal, stringContainsInOrder(Lists.newArrayList("apple", "jacks")));
	}
	
}
