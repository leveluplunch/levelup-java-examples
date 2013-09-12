package com.levelup.java.io;

import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java snippet will demonstrate how to read input from a keyboard.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class ReadInputFromKeyboard {

	@Test
	@Ignore
	public void read_input_from_keyboard() {
		
		// Variables to hold the month, day, and year
		int month;
		int day;
		int year;

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Get a month.
		System.out.print("Enter the number for a month: ");
		month = keyboard.nextInt();

		// Get a day.
		System.out.print("Enter the number for a day: ");
		day = keyboard.nextInt();

		// Get a two-digit year.
		System.out.print("Enter a two-digit year: ");
		year = keyboard.nextInt();
		
		System.out.println(month + "/" + day + "/" + year);
	}
}
