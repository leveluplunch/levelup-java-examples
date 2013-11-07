package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Ordering;

/**
 * This example will demonstrate sorting
 * a map by keys in java.  For calories burned
 * it will assume you were 200 pounds and performed 
 * the activity for 30 minutes.  The conversion was provided by
 * http://www.myfitnesspal.com/exercise/lookup.  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/sort-order-map-by-key/'>Sort map by key</a>
 * 
 */
public class SortMapByKeys {

	private static final Logger logger = Logger.getLogger(SortMapByKeys.class);
	
	Map<Integer, String> CALORIES_BURNED;
	
	@Before
	public void setUp () {
		
		CALORIES_BURNED = new HashMap<Integer, String>();
		CALORIES_BURNED.put(295, "Race walking");
		CALORIES_BURNED.put(249, "Punching bag");
		CALORIES_BURNED.put(499, "Rock climbing, ascending rock");
		CALORIES_BURNED.put(726, "Running (jogging), 10 mph (6 min mile)");
		CALORIES_BURNED.put(281, "Shoveling snow");
	}
	
	@Test
	public void sort_map_by_key_java () {
		
		TreeMap<Integer, String> caloriesBurnedSorted = 
				new TreeMap<Integer, String>(CALORIES_BURNED);

		logger.info(caloriesBurnedSorted);
		
		assertThat(caloriesBurnedSorted.keySet(), contains(249, 281, 295, 499, 726));
	}
	
	@Test
	public void sort_map_by_key_java_reverse () {
		
		TreeMap<Integer, String> caloriesBurnedReverse = 
				new TreeMap<Integer, String>(Collections.reverseOrder());
		
		caloriesBurnedReverse.putAll(CALORIES_BURNED);

		logger.info(caloriesBurnedReverse);
		
		assertThat(caloriesBurnedReverse.keySet(), contains(726, 499, 295, 281, 249));
	}

	@Test
	public void sort_map_by_key_guava () {

		TreeMap<Integer, String> caloriesBurnedReverse = 
				new TreeMap<Integer, String>(Ordering.natural().reverse());
		
		caloriesBurnedReverse.putAll(CALORIES_BURNED);

		logger.info(caloriesBurnedReverse);
		
		assertThat(caloriesBurnedReverse.keySet(), contains(726, 499, 295, 281, 249));
	}
	
}
