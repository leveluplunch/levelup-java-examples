package com.levelup.java.number;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;

import org.junit.Test;

/**
 * This java example will demonstrate formatting
 * a number.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/format-number/'>Format Number</a>
 * 
 */
public class FormatNumber {

	@Test
	public void format_a_number_with_java () {

		double nflSalaryCap2013 = 123000000;
		
		NumberFormat formatter = NumberFormat.getIntegerInstance();
		String salaryCapFormated = formatter.format(nflSalaryCap2013);
		
		assertEquals("123,000,000", salaryCapFormated);
	}
	
	@Test
	public void format_currency_with_java () {
		
		double moMoney = 1000.01;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(moMoney);
		
		assertEquals("$1,000.01", moneyString);
	}
	
	@Test
	public void format_a_percent_with_java () {
		NumberFormat formatter = NumberFormat.getPercentInstance();
		
		double perfectScore = 1.00;
		String perfectScoreFormatted = formatter.format(perfectScore);
		
		assertEquals("100%", perfectScoreFormatted);
	}
	
}
