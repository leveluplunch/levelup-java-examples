package com.levelup.java.number;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.junit.Test;

/**
 * This java example will demonstrate converting
 * a formatted string to a number
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/formatted-string-to-number/'>Formatted string to number</a>
 * 
 */
public class FormattedStringToNumber {
	
	@Test
	public void convert_formatted_string_to_number_java () throws ParseException {
		DecimalFormat df = new DecimalFormat("#,##0.00;(#,##0.00)");
		
		Number parsedNumber = df.parse("123,234.25");
		
		assertEquals(123234.25, parsedNumber);
	}
	
}
