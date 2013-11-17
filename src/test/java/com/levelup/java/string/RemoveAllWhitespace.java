package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate how to 
 * remove all whitespace from a string
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/remove-all-whitespace-from-string/'>Remove all whitespace from string</a>
 * 
 */
public class RemoveAllWhitespace {

	@Test
	public void remove_all_whitespace_java () {
	
		String dsmJs = "Des Moines JavaScript User Group";
		
		String removeAllSpaces = dsmJs.replaceAll(" ", "");
		
		assertEquals("DesMoinesJavaScriptUserGroup", removeAllSpaces);
	}
	
	@Test
	public void remove_all_whitespace_guava () {
		
		String cijug = "Central Iowa Java Users Group";
		String removeAllSpaces = CharMatcher.is(' ').removeFrom(cijug);
		
		assertEquals("CentralIowaJavaUsersGroup", removeAllSpaces);
	}
	
	@Test
	public void remove_all_whitespace_apache_commons () {
		
		String madJug = "Madison Java User Group";
		
		String removeAllSpaces = StringUtils.deleteWhitespace(madJug);
		
		assertEquals("MadisonJavaUserGroup", removeAllSpaces);
	}
	
}
