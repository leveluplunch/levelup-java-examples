package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java snippet will demonstrate Google
 * Guava Charmatcher
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CharMatcherExample {

	@Test
	public void remove_all_lower_case_from_string () {
		
		String allButLowerCase = CharMatcher.JAVA_LOWER_CASE.negate().retainFrom("B-double E double R U-N beer run");
		
		assertEquals("B- E  R U-N ", allButLowerCase);
	}
	
}
