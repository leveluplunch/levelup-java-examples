package com.levelup.java.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * This java example will demonstrate junits
 * parameterized tests by using {@link Parameter} annotation vs
 * a constructor. Paramertized tests are useful when you
 * are interested in running the same test with different test data.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-paramertize-test-field-injection/'>Junit Paramertized Test Field Injection</a>
 * 
 */
@RunWith(Parameterized.class)
public class ParameterizedTestWithFieldInjection {
	
	private static final Logger logger = Logger.getLogger(ParameterizedTestWithFieldInjection.class);

	static class Calculator {

		public static int add(int a, int b) {
			return a + b;
		}
		
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{0, 0, 0},
				{1, 0, 1},
				{0, 1, 1},
				{1, 1, 2},
				{1, 2, 3}, 
				{2, 1, 3}
			});
	}
	
	@Parameter (value = 0) public int a;
	@Parameter (value = 1) public int b;
	@Parameter (value = 2) public int expected;
	
	@Test
	public void test_calculator_add () {

		logger.info("a=" + a + " b " + b + " = c " + expected);
		
		int calculatedValue = Calculator.add(a,  b);
		assertEquals(expected, calculatedValue);
	}	
}
