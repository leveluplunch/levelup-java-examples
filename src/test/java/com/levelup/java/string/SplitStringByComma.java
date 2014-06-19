package com.levelup.java.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Splitter;

/**
 * This java example will demonstrate how to split a string by a comma.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/split-string-by-comma-delimiter/'>Split string by comma</a>
 */
public class SplitStringByComma {

	private static final Logger logger = Logger.getLogger(SplitStrings.class);

	@Test
	public void split_string_comma_java() {

		String[] elementsInString = "Yo,Gabba, Gabba, Keep Trying".split(",");

		logger.info(Arrays.toString(elementsInString));

		assertTrue(elementsInString.length == 4);
	}

	@Test
	public void split_string_comma_guava() {

		List<String> elementsInString = Splitter.on(",").splitToList(
				"Yo,Gabba, Gabba, Keep Trying");

		logger.info(elementsInString);

		assertEquals(4, elementsInString.size());

	}

	@Test
	public void split_string_white_space_using_apache_commons() {

		String[] elementsInString = StringUtils.split(
				"Yo,Gabba, Gabba, Keep Trying", ",");

		logger.info(Arrays.toString(elementsInString));

		assertTrue(elementsInString.length == 4);
	}

}
