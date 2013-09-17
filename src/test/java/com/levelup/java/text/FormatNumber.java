package com.levelup.java.text;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;

import org.junit.Test;

public class FormatNumber {

	@Test
	public void format_a_number_with_Java () {
//		NumberFormat	
	}
	
	public void format_currency_with_java () {
		
	}
	
	@Test
	public void format_a_percent_with_java () {
		NumberFormat formatter = NumberFormat.getPercentInstance();
//		formatter.setMinimumFractionDigits(3);
		
		double perfectScore = 1.00;
		String perfectScoreFormatted = formatter.format(perfectScore);
		
//		perfectScoreFormatted == 100%

		assertEquals("100%", perfectScoreFormatted);
	}
	
	
	
}
