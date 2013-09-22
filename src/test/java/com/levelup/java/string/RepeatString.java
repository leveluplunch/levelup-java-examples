package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java snippet will demonstrate repeating a string
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class RepeatString {

	@Test
	public void repeat_a_string_java_with_char_array () {
		
		int numberOfTimesToRepeat = 3;
		String uppityup = new String(new char[numberOfTimesToRepeat]).replace("\0", "up");
		
		assertEquals("upupup", uppityup);
	}
	
	@Test
	public void repeat_a_string_java_with_loop () {
		
		int numberOfTimesToRepeat = 3;
		StringBuilder uppityup = new StringBuilder();
		for (int x = 0; x < numberOfTimesToRepeat; x++) {
			uppityup.append("up");
		}
		
		assertEquals("upupup", uppityup.toString());
	}
	
	@Test
	public void repeat_a_string_with_guava () {
		
		String uppityup = Strings.repeat("up", 3);
		assertEquals("upupup", uppityup);
	}

	@Test
	public void repeat_a_string_with_apache_commons () {

		String uppityup = StringUtils.repeat("up", 3);
		assertEquals("upupup", uppityup);
	}

	
	
}
