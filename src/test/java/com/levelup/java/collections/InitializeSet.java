package com.levelup.java.collections;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.SetUtils;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * This example will demonstrate creating 
 * a new set with Java, Guava and apache commons. 
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>Create new set</a>
 * 
 */
public class InitializeSet {
	
	@Test
	public void create_new_set_java () {
		
		Set<String> newSet = new HashSet<String>();
		
		assertNotNull(newSet);
	}

	@Test
	public void create_new_set_guava () {

		Set<String> newSet = Sets.newHashSet();
		
		assertNotNull(newSet);
	}

	@Test
	public void create_new_set_apache () {

		@SuppressWarnings("unchecked")
		Set<String> newSet = SetUtils.EMPTY_SET;
		
		assertNotNull(newSet);
	}


}
