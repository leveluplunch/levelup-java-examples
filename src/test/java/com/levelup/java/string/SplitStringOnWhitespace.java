package com.levelup.java.string;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate how to split string by whitespace.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/split-string-on-whitespace-chars/'>Split string on whitespace</a>
 */
public class SplitStringOnWhitespace {

	private static final Logger logger = Logger.getLogger(SplitStrings.class);

	@Test
	public void split_on_whitespace_stringtokenizer() {

		StringTokenizer stringTokenizer = new StringTokenizer(
				"The snow glows white on the mountain tonight");

		int numberOfTokens = stringTokenizer.countTokens();

		while (stringTokenizer.hasMoreElements()) {
			logger.info(stringTokenizer.nextElement());
		}

		assertTrue(numberOfTokens == 8);
	}

	@Test
	public void split_on_whitespace_split_regex() {
		String[] tokens = "The snow glows white on the mountain tonight"
				.split("\\s+");

		logger.info(Arrays.toString(tokens));

		assertTrue(tokens.length == 8);
	}

	@Test
	public void split_string_whitespace_using_guava() {

		List<String> elementsInString = Lists.newArrayList(Splitter.on(" ")
				.split("The snow glows white on the mountain tonight"));

		logger.info(elementsInString);

		assertTrue(elementsInString.size() == 8);
	}

	@Test
	public void split_string_white_space_using_apache_commons() {

		String[] elementsInString = StringUtils
				.split("The snow glows white on the mountain tonight");

		logger.info(Arrays.toString(elementsInString));

		assertTrue(elementsInString.length == 8);
	}

}
