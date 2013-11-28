package com.levelup.java.number;

import static org.junit.Assert.assertEquals;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.Test;

/**
 * This java example will demonstrate a few different ways
 * to format a decimal using {@link DecimalFormat}.  Look 
 * further at java's special pattern characters.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com//'></a>
 */
public class FormatDecimal {

	@Test
	public void format_decimal_with_rounding_mode () {
		
		double hdTv = 1229.99;
		
		DecimalFormat df = new DecimalFormat("###,###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		assertEquals("1,230", df.format(hdTv));
	}
	
	@Test
	public void format_with_trailing_zeros () {
		
		double singAlongMic = 49;
		
		DecimalFormat df = new DecimalFormat("00.00");
		
		assertEquals("49.00", df.format(singAlongMic));
	}
	
	@Test
	public void format_with_leading_zeros () {
		
		double videoGame = 49;
		
		DecimalFormat df = new DecimalFormat("000,000");
		
		assertEquals("000,049", df.format(videoGame));
	}
	
	@Test
	public void format_decimal_with_commas () {
		
		double expensiveLegos = 1244444;

		DecimalFormat df = new DecimalFormat("###,###");
		
		assertEquals("1,244,444", df.format(expensiveLegos));
	}
	
	
	@Test 
	public void format_decimal_with_dollar_sign_currency () {
		
		double blackFridayTVDeal = 120.9;
		
		DecimalFormat df = new DecimalFormat("$#.00");
		
		assertEquals("$120.90", df.format(blackFridayTVDeal));
	}
	
	@Test
	public void format_decimal_with_optional_zero () {
		
		double gameConsole = 229.90;

		DecimalFormat df = new DecimalFormat("#.##");
		
		assertEquals("229.9", df.format(gameConsole));
	}
	
}
