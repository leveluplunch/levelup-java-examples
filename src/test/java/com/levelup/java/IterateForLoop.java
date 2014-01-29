package com.levelup.java;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate how to loop over 
 * a for loop.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/iterate-looping-for-each-statement/'>Iterate using for Loop</a>
 */
public class IterateForLoop {

	double[] numbers = {55, 29, 68, 21, 48, 36,	92,	56,	88,	96};
	
	@Ignore
	@Test
	public void loop_for_infinite () {
		
		for ( ; ; ) {
			System.out.println("don't run this code");
		}
	}

	@Test
	public void loop_for_java_1_4 () {
		
		for (int x = 0; x < numbers.length; x ++) {
			System.out.println(numbers[x]);
		}
	}
	
	
	@Test
	public void loop_for_java_1_5 () {
		
		for (double number : numbers) {
			System.out.println(number);
		}
	}

	@Test
	public void loop_for_java_1_8 () {
		
		Arrays.stream(numbers).forEach(x -> System.out.println(x));
		
	}
	
	
	

	
}
