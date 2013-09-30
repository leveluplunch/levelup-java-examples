package com.levelup.java.number;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.NumberFormat;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import com.google.common.primitives.Doubles;

/**
 * This java example will demonstrate 
 * checking if a string is a number.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class IsStringANumber {
	
	@Test
	public void is_string_a_number_java () {

		boolean isANumber = false;
		String numberString = "1234.54";

		try {
			Double.parseDouble(numberString);
			isANumber = true;
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		assertTrue(isANumber);
	}

	@Test
	public void is_string_a_number_numberformat_java ()  {

		boolean isANumber = true;
		String numberString = "1234.54";

		try {
		    NumberFormat.getInstance().parse(numberString);
		} catch (ParseException nfe) {
			isANumber = false;
		}
		assertTrue(isANumber);
	}

	
	@Test
	public void is_string_a_number_java_with_char_array () {

		boolean isANumber = true;
		String numberString = "1234";
		
		for (char c : numberString.toCharArray()) {
	        if (!Character.isDigit(c)) {
	        	isANumber = false;
	        }
	    }
		assertTrue(isANumber);
	}

	@Test
	public void is_string_a_number_java_with_regular_expression () {

		boolean isANumber = false;
		String numberString = "1234.54";
		
		if (numberString.matches("[+-]?\\d*(\\.\\d+)?")) {
			isANumber = true;
		}
		assertTrue(isANumber);
	}

	@Test
	public void is_string_a_number_guava () {
		Double parsedString = Doubles.tryParse("123234.54");
		
		assertEquals(new Double(123234.54), parsedString);
	}
	

	@Test
	public void is_string_a_number_apache_commons_stringutils () {
		
		boolean isANumber = StringUtils.isNumeric("12345");
		assertTrue(isANumber);
	}

	
	@Test
	public void is_string_a_number_apache_commons () {
		
		boolean isANumber = NumberUtils.isNumber("12345");
		assertTrue(isANumber);
	}

	@Test
	public void is_formatted_string_a_number_apache_commons () {
		
		boolean isANumber = NumberUtils.isNumber("123123.45");
		assertTrue(isANumber);
	}

	
}
