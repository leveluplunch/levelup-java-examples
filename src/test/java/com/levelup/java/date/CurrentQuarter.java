package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

/**
 * This example will demonstrate getting current
 * quarter in Java.  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/current-quarter/'>Current quarter</a>
 * 
 */
public class CurrentQuarter {

	@Test
	public void current_quarter_with_java() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 3);
		
		int month = cal.get(Calendar.MONTH);
		int quarter = 0;

		// 3, 6, 9, 12
		if (month <= 3) {
			quarter = 1;
		} else if (month <= 6) {
			quarter = 2;
		} else if (month <= 9) {
			quarter = 3;
		} else {
			quarter = 4;
		}
		
		assertEquals(1, quarter);
	}
	
}
