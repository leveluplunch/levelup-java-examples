package com.levelup.java.junit;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate how to limit
 * the execution time on a junit test with a timeout parameters.
 * This is helpful if you mix integration test with unit test or if 
 * you have long running tests.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/example/junit-limit-length-of-test/'>Limit length of test</a>
 * 
 */
public class TimeoutParameter {

	@Ignore("Test will always fail")
	@Test(timeout=100)
	public void limit_test_execution_time () {

		//Infinite loop
		while (true) {
		}
	}
	
}
