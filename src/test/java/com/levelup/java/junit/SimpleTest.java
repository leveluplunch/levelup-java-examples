package com.levelup.java.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate a simple
 * test using Junit
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-create-test-case/'>Simple Test Junit</a>
 * 
 */
public class SimpleTest {

	static class Calculator {

		public static int add (int a, int b) {
			return a + b;
		}
		
	}
	
	@Test
	public void calculator_add () {
		int calculatedValue = Calculator.add(5,  10);
		assertEquals(15, calculatedValue);
	}
	
}
