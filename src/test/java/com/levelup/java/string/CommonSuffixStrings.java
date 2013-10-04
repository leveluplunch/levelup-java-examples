package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate finding 
 * common suffix between two strings.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/common-suffix-between-strings/'>Common prefix</a>
 * 
 */
public class CommonSuffixStrings {

	
	@Test
	public void find_common_suffix_between_strings_guava (){
		
		String phrase1 = "fix";
		String phrase2 = "six";
		
		String prefix = Strings.commonSuffix(phrase1, phrase2); 
		
		assertEquals("ix", prefix);
	}

}
