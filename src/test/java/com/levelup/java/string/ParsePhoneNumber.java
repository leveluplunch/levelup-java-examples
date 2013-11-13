package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * This java example will demonstrate splitting, parsing
 * or extract a phone number from a string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/parse-phone-number-from-string/'>Parse/Split/Extract phone number</a>
 * 
 */
public class ParsePhoneNumber {

	@Test
	public void parse_phone_number_java () {
		
		String formattedPhoneNumber = "123-456-7890";

		String [] phoneNumberElements = formattedPhoneNumber.split("-");
		
		String areaCode = phoneNumberElements[0];
		String prefix = phoneNumberElements[1];
		String lineNumber = phoneNumberElements[2];
		
		assertEquals("123", areaCode);
		assertEquals("456", prefix);
		assertEquals("7890", lineNumber);
		
	}
	
	@Test
	public void parse_phone_number_guava () {

		String formattedPhoneNumber = "(123) 456-7890";
		
		Iterable<String> phoneSplit = Splitter.on(CharMatcher.anyOf("-)("))
				.omitEmptyStrings().trimResults().split(formattedPhoneNumber);

		String areaCode = Iterables.get(phoneSplit, 0);
		String prefix = Iterables.get(phoneSplit, 1);
		String lineNumber = Iterables.get(phoneSplit, 2);
		
		assertEquals("123", areaCode);
		assertEquals("456", prefix);
		assertEquals("7890", lineNumber);
	}
	
	@Test
	public void parse_phone_number_apache_commons () {
		
		String formattedPhoneNumber = "123-456-7890";

		String [] phoneNumberElements = StringUtils.split(formattedPhoneNumber, "-");
		
		String areaCode = phoneNumberElements[0];
		String prefix = phoneNumberElements[1];
		String lineNumber = phoneNumberElements[2];
		
		assertEquals("123", areaCode);
		assertEquals("456", prefix);
		assertEquals("7890", lineNumber);
	}
	
}
