package com.levelup.java.junit;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * This java example will demonstrate how to limit
 * the execution time on a junit test with a junit rule.
 * This is helpful if you mix integration test with unit test or if 
 * you have long running tests.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/example/junit-limit-length-of-all-tests/'>Limit length of all tests</a>
 * 
 */
public class TimeoutRule {

	//https://github.com/junit-team/junit/wiki/Timeout-for-tests
	
	@Rule public Timeout globalTimeout = new Timeout(100); // 10 seconds max per method tested

	@Ignore("Test will always fail")
	@Test
	public void infinate_while_loop() {
		while (true) {
		}
	}

	@Ignore("Test will always fail")
	@Test
	public void infinate_for_loop() {
		for (;;) {
		}
	}

}
