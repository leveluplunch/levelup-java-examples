package com.levelup.java;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

/**
 * This java example will demonstrate the basics of a switch statement.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/switch-statement/'>Switch statement</a>
 */
public class SwitchStatement {

	@Test
	public void switch_statement_primitive_type () {
		
		int day = 5;
		
		String expression = null;

		switch (day) {
		
			case Calendar.SUNDAY:
			case Calendar.SATURDAY:
				expression = "This is a weekend day";
				break;
				
			case Calendar.MONDAY:
			case Calendar.TUESDAY:
			case Calendar.WEDNESDAY:
			case Calendar.THURSDAY:
			case Calendar.FRIDAY:
				expression = "This is a weekday";
				break;
		}
		
		assertEquals("This is a weekday", expression);
	}
	
	public enum Day {
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	}
	
	@Test
	public void switch_statement_enumerated_type () {
		
		Day day = Day.MONDAY;
		
		String expression = null;

		switch (day) {

			case SUNDAY:
			case SATURDAY:
				expression = "This is a weekend day";
				break;
				
			case MONDAY:
			case TUESDAY:
			case WEDNESDAY:
			case THURSDAY:
			case FRIDAY:
				expression = "This is a weekday";
				break;
		}
		
		assertEquals("This is a weekday", expression);
	}

	@Test
	public void switch_statement_string () {

		String day = "MONDAY";
		
		String expression = null;
		
		switch (day) {
		
			case "SUNDAY":
			case "SATURDAY":
				expression = "This is a weekend day";
				break;
				
			case "MONDAY":
			case "TUESDAY":
			case "WEDNESDAY":
			case "THURSDAY":
			case "FRIDAY":
				expression = "This is a weekday";
				break;
		}
		
		assertEquals("This is a weekday", expression);		
	}
	
}
