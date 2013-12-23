package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate how to center justify 
 * a string by using by using java's string.format, 
 * google guava Strings.padStart and Strings.padend, and apache commons StringUtils.center. .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/center-justify-string/'>Center justify string</a>
 */
public class CenterJustifyString {

	@Test
	public void center_string_with_java () {
		
		int width = 20;
		String s = "level";
		
		int padSize = width - s.length();
		int padStart = s.length() + padSize / 2;

		s = String.format("%" + padStart + "s", s);
		s = String.format("%-" + width  + "s", s);
		
		assertEquals("       level        ", s);
	}
	
	@Test
	public void center_string_with_google_guava () {
		
		int width = 20;
		String s = "level";
		
		int padSize = width - s.length();
		
		s = Strings.padStart(s, s.length() + padSize / 2, ' ');
		s = Strings.padEnd(s, width, ' ');
		
		assertEquals("       level        ", s);
	}
	
	@Test
	public void center_string_with_apache_commons () {
		
		String centered = StringUtils.center("level", 20);
		
		assertEquals("       level        ", centered);
	}
	
	
}
