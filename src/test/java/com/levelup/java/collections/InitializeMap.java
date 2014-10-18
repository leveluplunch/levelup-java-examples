package com.levelup.java.collections;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import com.google.common.collect.Maps;

/**
 * This example will demonstrate creating
 * new Map with straight up java, guava and apache commons.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/initialize-map/'>Initialize map</a>
 * 
 */
public class InitializeMap {

	@Test
	public void create_new_map_java () {
		
		Map<String, String> newMap = new HashMap<String, String>();
		
		assertNotNull(newMap);
	}

	@Test
	public void create_new_map_java_diamond_operator () {
		
		Map<String, String> newMap = new HashMap<>();
		
		assertNotNull(newMap);
	}
	
	@Test
	public void create_new_map_guava () {

		Map<String, String> newMap = Maps.newHashMap();
		
		assertNotNull(newMap);
	}

	@Test
	public void create_new_map_apache () {
		
		@SuppressWarnings("unchecked")
		Map<String, String> newMap = MapUtils.EMPTY_MAP;
		
		assertNotNull(newMap);
	}

}
