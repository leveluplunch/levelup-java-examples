package com.levelup.java.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert a int to a string and vise
 * versa.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-string-to-int/'>String
 *      to primitive value</a>
 */
public class StringToInt {

	@Test
	public void string_to_int() {

		String myString = "2";

		int variable = Integer.parseInt(myString);

		assertEquals(2, variable);
	}

	@Test
	public void int_to_string() {

		int number = 2;

		assertEquals("2", String.valueOf(number));
	}

	@Test
	public void stringbuffer_to_int() {

		StringBuffer buffer = new StringBuffer("2");

		assertEquals(2, Integer.parseInt(buffer.toString()));
	}

	@Test
	public void stringbuider_to_int() {

		StringBuilder builder = new StringBuilder("2");

		assertEquals(2, Integer.parseInt(builder.toString()));
	}

}
