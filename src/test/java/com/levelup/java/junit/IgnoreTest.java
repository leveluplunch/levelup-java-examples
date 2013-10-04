package com.levelup.java.junit;

import static org.junit.Assert.assertFalse;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate ignoring
 * a test with junit.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-ignore-test/'>Ignore Test</a>
 * 
 */
public class IgnoreTest {

	@Ignore("Ignore this test")
	@Test
	public void ignore_test_junit () {
		assertFalse(true);
	}
	
}
