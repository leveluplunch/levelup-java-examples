package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate printing a List<String 
 * with a delimiter.  AKA pretty printing a list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class PrintList {
	
	private List<String> programmingLanguages = Lists.newArrayList("java", "python", "ruby", "groovy");
	private String languagesSeperatedByComma = "java,python,ruby,groovy";
	
	
	/**
	 * Method will join separator to all elements in 
	 * string array.  This could be easily modified to 
	 * to a list
	 * 
	 * @param join
	 * @param strings
	 * @return
	 */
	private static String join(String separator, String... strings) {
	    if (strings == null || strings.length == 0) {
	        return "";
	    } else if (strings.length == 1) {
	        return strings[0];
	    } else {
	        StringBuilder sb = new StringBuilder();
	        sb.append(strings[0]);
	        for (int i = 1; i < strings.length; i++) {
	            sb.append(separator).append(strings[i]);
	        }
	        return sb.toString();
	    }
	}	
	
	@Test
	public void join_elements_in_list_java () {
		String elementsJoined = join(",", programmingLanguages.toArray(new String[programmingLanguages.size()]));
		assertEquals(languagesSeperatedByComma, elementsJoined);
	}

	@Test
	public void join_elements_in_list_guava () {
		String elementsJoined = Joiner.on(",").join(programmingLanguages);
		assertEquals(languagesSeperatedByComma, elementsJoined);
	}

	@Test
	public void join_elements_in_list_apache_commons () {
		String elementsJoined = StringUtils.join(programmingLanguages, ",");
		assertEquals(languagesSeperatedByComma, elementsJoined);
	}

	@Test
	public void join_elements_in_list_spring () {
		String elementsJoined = org.springframework.util.StringUtils.collectionToDelimitedString(programmingLanguages, ",");
		assertEquals(languagesSeperatedByComma, elementsJoined);
	}
	
	
	

}
