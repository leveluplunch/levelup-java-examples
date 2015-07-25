package com.levelup.java.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert a double to string vise
 * versa.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-string-to-double/'>Strin
 *      g to double object</a>
 */
public class StringToDouble {

	@Test
	public void string_to_double_primitive() {

		String myString = "2";

		double variable = Double.parseDouble(myString);

		assertEquals(2, variable, 0);
	}

	@Test
	public void primitive_double_to_string() {

		double number = 2;

		assertEquals("2.0", String.valueOf(number));
	}

	@Test
	public void stringbuffer_to_primitive_double() {

		StringBuffer buffer = new StringBuffer("2");

		assertEquals(2, Double.parseDouble(buffer.toString()), 0);
	}

	@Test
	public void stringbuider_to_double() {

		StringBuilder builder = new StringBuilder("2");

		assertEquals(2, Double.parseDouble(builder.toString()), 0);
	}

	@Test
	public void double_object_to_string() {

		Double doubleToString = Double.valueOf("2");

		assertEquals("2.0", doubleToString.toString());
	}
	
	@Test
	public void string_to_double_object() {
		
		Double stringToDoubleObject = Double.parseDouble("2");
		
		assertEquals(new Double(2), stringToDoubleObject);
	}
	
}
