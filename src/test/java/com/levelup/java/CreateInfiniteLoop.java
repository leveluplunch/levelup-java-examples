package com.levelup.java;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate how to create an infinite for loop.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/create-infinite-loop-for-while-do/'>Infinite loops</a>
 */
public class CreateInfiniteLoop {

	@Ignore("Infinite loop")
	@Test
	public void infinite_for_loop () {
		
		for (;;) {
		}
	}
	
	@Ignore("Infinite loop")
	@Test
	public void infinite_while_loop () {
	
		while (true) {
			
		}
		
	}

	@Ignore("Infinite loop")
	@Test
	public void infinite_do_while_loop() {

		do {

		} while (true);

	}
}
