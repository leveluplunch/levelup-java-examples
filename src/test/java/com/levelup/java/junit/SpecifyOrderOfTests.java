package com.levelup.java.junit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * This java example will demonstrate how to specify 
 * execution order of junit tests. 
 *  
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/example/junit-specify-order-of-tests/'>Specify order of tests</a>
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpecifyOrderOfTests {

	private static String executionOrder = "";

	@Test
	public void c_three () {
		executionOrder += "three";
	}
	
	@Test
	public void a_one () {
		executionOrder += "one";
	}
	
	@Test
	public void b_two () {
		executionOrder += "two";
	}
	
	@AfterClass
	public static void validate () {
		assertEquals("onetwothree", executionOrder);
	}
	
}
