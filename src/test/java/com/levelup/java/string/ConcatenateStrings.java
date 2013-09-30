package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate how to 
 * concatenate strings.  It is recommended that
 * when concatenating large strings to use {@link StringBuffer}
 * OR {@link StringBuilder}.  The difference b/t
 * {@link StringBuffer} and {@link StringBuilder} is 
 * that {@link StringBuffer} is synchronized. 
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class ConcatenateStrings {
	
	@Test
	public void concatenate_strings_java () {
		
		String one = "one";
		String two = "two";
		
		assertEquals("onetwo", one + two);
		
	}

	@Test
	public void concatenate_strings_with_concat_java () {

		String one = "one";
		String two = "two";

		assertEquals("onetwo", one.concat(two));
		
	}

	
	@Test
	public void concatenate_strings_with_stringbuilder_java () {
		
		StringBuilder sb = new StringBuilder();
		sb.append("one");
		sb.append("two");
		
		assertEquals("onetwo", sb.toString());
		
	}

	@Test
	public void concatenate_strings_with_stringbuffer_java () {

		StringBuffer sb = new StringBuffer();
		sb.append("one");
		sb.append("two");
		
		assertEquals("onetwo", sb.toString());
		
	}

}
