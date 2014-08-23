package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate removing a carriage return from a string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/remove-newline-carriage-return-from-string/'>Remove newline from string</a>
 */
public class RemoveCarriageReturnFromString {

	@Test
	public void get_system_property() {
		System.out.println(System.getProperty("line.separator"));
	}

	@Test
	public void remove_carriage_return_java() {

		String text = "Our line rackets \rthe encouraged symmetry.\n";
		String cleanString = text.replaceAll("\r", "").replaceAll("\n", "");

		assertEquals("Our line rackets the encouraged symmetry.", cleanString);
	}

	@Test
	public void remove_carriage_return_guava() {

		String randomSentence = "The backed valley manufactures \r"
				+ "a politician above \n" + "a scratched body.";

		String cleanString = CharMatcher.BREAKING_WHITESPACE
				.removeFrom(randomSentence);

		assertEquals(
				"Thebackedvalleymanufacturesapoliticianaboveascratchedbody.",
				cleanString);
	}

	@Test
	public void remove_carriage_return_apache() {

		String randomSentence = "The pocket reflects "
				+ "over an intimate. \r";

		String cleanString = StringUtils.chomp(randomSentence);

		assertEquals(
				"The pocket reflects over an intimate. ",
				cleanString);
	}

}
