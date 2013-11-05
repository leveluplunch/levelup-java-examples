package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate checking if 
 * string is null or if it has a value.  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/is-string-null-or-empty/'>Is string null or empty</a>
 * 
 */
public class IsStringNullOrEmpty {
	
	@Test
	public void string_is_null_or_empty_java () {
		
		String outputVal = null;
		String stringToCheck = "abc";
		
		if (stringToCheck != null && stringToCheck.length() > 0) {
			outputVal = "do some work";
		}
		
		assertEquals("do some work", outputVal);
	}
	
	@Test
	public void string_is_null_or_empty_isempty () {

		String outputVal = null;
		String stringToCheck = "abc";
		
		if (stringToCheck != null && !stringToCheck.isEmpty()) {
			outputVal = "do some work";
		}
		
		assertEquals("do some work", outputVal);
		
	}

	@Test
	public void string_is_null_or_empty_guava () {
		
		String outputVal = null;
		String stringToCheck = "abc";

		if (!Strings.isNullOrEmpty(stringToCheck)) {
			outputVal = "do some work";
		};

		assertEquals("do some work", outputVal);
	}

	@Test
	public void string_is_null_or_empty_apache () {
		

		String outputVal = null;
		String stringToCheck = "abc";

		if (StringUtils.isNotEmpty(stringToCheck)) {
			outputVal = "do some work";
		};
		
		assertEquals("do some work", outputVal);
	}

}
