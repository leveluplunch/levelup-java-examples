package com.levelup.java.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This java example will demonstrate how to 
 * group junit tests together with {@link Suite}
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-group-tests-together/'>Test Suites</a>
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  ExceptionTesting.class,
  IgnoreTest.class,
  SimpleTest.class
})
public class TestSuites {
	
	
}
