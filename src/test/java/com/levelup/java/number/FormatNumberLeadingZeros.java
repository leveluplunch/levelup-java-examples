package com.levelup.java.number;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate how to format a number with leading zeros.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/format-number-with-leading-zeros/'>Format number with leading zeros</a>
 */
public class FormatNumberLeadingZeros {

	@Test
	public void format_leading_zeros() {

		DecimalFormat df = new DecimalFormat("00000");

		assertEquals("00123", df.format(123));
	}

	@Test
	public void format_leading_zeros_string_format() {

		String leadingZero = String.format("%05d", 123);

		assertEquals("00123", leadingZero);
	}

	@Test
	public void format_leading_zeros_guava() {

		int asNumber = 123;

		String leadingZero = Strings.padStart(String.valueOf(asNumber), 5, '0');

		assertEquals("00123", leadingZero);
	}

	@Test
	public void format_leading_zeros_apache_commons() {

		int asNumber = 123;

		String leadingZero = StringUtils.leftPad(String.valueOf(asNumber), 5,
				"0");

		assertEquals("00123", leadingZero);
	}

}
