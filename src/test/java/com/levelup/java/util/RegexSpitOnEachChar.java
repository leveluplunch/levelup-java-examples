package com.levelup.java.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This java example will use a regex to split on each char.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/exercises/regular-expression-split-on-each-charachter/'>Regu
 *      l a r expression split on each char</a>
 */

public class RegexSpitOnEachChar {

	@Test
	public void split_on_each_char() {
		String sentence = "Daily newspaper for the greater San Francisco area.";

		String[] chars = sentence.split("");

		for (String singleChar: chars) {
			System.out.println(singleChar);
		}
		
		assertEquals(51, chars.length);
	}
}
