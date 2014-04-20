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
 * This java example will demonstrate splitting of a string based on a
 * delimiter.
 * 
 * It is likely if you are dealing with single field with multiple values such
 * as select_139393_494949, you may need to parse string values. OR you want to
 * iterate over a string to determine the number of times a word occurred.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/split-string/'>Split
 *      string</a>
 * 
 */
public class SplitStrings {

	private static final Logger logger = Logger.getLogger(SplitStrings.class);

	private static final String CONSTANT_STRING = "The Dog goes woof, The cat goes meow, the cow says moo, the duck says quack";

	@Test
	public void split_string_using_stringtokenizer_java() {

		StringTokenizer stringTokenizer = new StringTokenizer(CONSTANT_STRING);

		int numberOfTokens = stringTokenizer.countTokens();

		while (stringTokenizer.hasMoreElements()) {
			logger.info(stringTokenizer.nextElement());
		}

		assertTrue(numberOfTokens == 16);
	}

	@Test
	public void split_string_using_string_split_java() {
		String delims = "[ ]+";
		String[] tokens = CONSTANT_STRING.split(delims);

		logger.info(Arrays.toString(tokens));

		assertTrue(tokens.length == 16);
	}

	@Test
	public void split_string_whitespace_using_guava() {

		List<String> elementsInString = Lists.newArrayList(Splitter.on(" ")
				.split(CONSTANT_STRING));

		logger.info(elementsInString);

		assertTrue(elementsInString.size() == 16);
	}

	@Test
	public void split_string_white_space_using_apache_commons() {

		String[] elementsInString = StringUtils.split(CONSTANT_STRING);

		logger.info(Arrays.toString(elementsInString));

		assertTrue(elementsInString.length == 16);
	}

}
