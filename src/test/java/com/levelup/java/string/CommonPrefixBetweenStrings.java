package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * This java example will demonstrate finding 
 * common prefix between two strings.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/common-prefix-between-strings/'>Common prefix</a>
 * 
 */
public class CommonPrefixBetweenStrings {

	
	@Test
	public void find_common_prefix_between_strings_guava (){
		
		String phrase1 = "semicircle";
		String phrase2 = "semiconductor";
		
		String prefix = Strings.commonPrefix(phrase1, phrase2); 
		
		assertEquals("semic", prefix);
	}
	
	@Test
	public void find_common_prefix_between_strings_apache_commons () {

		String phrase1 = "semicircle";
		String phrase2 = "semiconductor";
		
		String prefix = StringUtils.getCommonPrefix(phrase1, phrase2); 
		
		assertEquals("semic", prefix);

	}
	
	
}
