package com.levelup.java.guava;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.levelup.java.array.ConvertCollectionToArray;

/**
 * This java example will demonstrate common usages of
 * Google Guava Maps Utility.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-maps-utility-example/'>Maps utility example</a>
 */
public class MapsExample {
	
	private static final Logger logger = Logger.getLogger(ConvertCollectionToArray.class);
	
	class State {
		
		String code;
		String name;
		String region;
		double population;

		public State(String code, String name, String region, double population) {
			super();
			this.code = code;
			this.name = name;
			this.region = region;
			this.population = population;
		}		
		
		@Override
		public String toString() {
			return com.google.common.base.Objects.toStringHelper(this)
					.add("code", code).add("name", name)
					.toString();
		}
		
	}
	
	List<State> states;
	
	/**
	 * Seed data
	 */
	@Before
	public void setUp () {
		
		states = Lists.newArrayList();
		
		states.add(new State("WI", "Wisconsin", "MDW", 5726398));
		states.add(new State("FL", "Florida", "SE", 19317568));
		states.add(new State("IA", "Iowa", "MDW", 3078186));
		states.add(new State("CA", "California", "W", 38041430));
		states.add(new State("NY", "New York", "NE", 19570261));
		states.add(new State("CO", "Colorado", "W", 5187582));
		states.add(new State("OH", "Ohio", "MDW", 11544225));
		states.add(new State("ME", "Maine", "NE", 1329192));
		states.add(new State("SD", "South Dakota", "MDW", 833354));
		states.add(new State("TN", "Tennessee", "SE", 6456243));
		states.add(new State("OR", "Oregon", "W", 3899353));
	}
	
	
	/**
	 * Initialize map
	 */
	@Test
	public void intialize_map () {
		
		Map<String, String> newMap = Maps.newHashMap();
		
		assertNotNull(newMap);
	}
	
	/**
	 * Convert a list to a map keying off object's field
	 */
	@Test
	public void maps_unique_index () {
		
		Map<String, State> statesKeyByCode = Maps.uniqueIndex(states, new Function <State, String> () {
			  public String apply(State from) {
			    return from.code;
		}});

		logger.info(statesKeyByCode);
		
		assertThat(statesKeyByCode, 
				hasKey("WI"));
		
	}
	
	/**
	 * Convert properties to map
	 */
	@Test
	public void map_of_properties() {

		Properties properties = new Properties();
		properties.put("leveluplunch.java.examples",
				"http://www.leveluplunch.com/java/examples/");
		properties.put("leveluplunch.java.exercises",
				"http://www.leveluplunch.com/java/exercises/");
		properties.put("leveluplunch.java.tutorials",
				"http://www.leveluplunch.com/java/tutorials/");

		Map<String, String> mapOfProperties = Maps.fromProperties(properties);

		logger.info(mapOfProperties);

		assertThat(mapOfProperties, hasKey("leveluplunch.java.examples"));

	}
	
	/**
	 * Filter map by entries
	 */
	@Test
	public void maps_filter_entries() {

		// create a map
		Map<String, State> statesKeyByCode = Maps.uniqueIndex(states,
				new Function<State, String>() {
					public String apply(State from) {
						return from.code;
					}
				});

		// predicate to filter states by region code
		Predicate<Entry<String, State>> byMDWStates = new Predicate<Map.Entry<String, State>>() {
			@Override
			public boolean apply(Entry<String, State> input) {
				return input.getValue().region.equals("MDW");
			}
		};

		// filter entries
		Map<String, State> midwestStates = Maps.filterEntries(statesKeyByCode,
				byMDWStates);

		logger.info(midwestStates);

		assertThat(midwestStates.keySet(), hasSize(5));
	}
	
	/**
	 * Filter map by keys
	 */
	@Test
	public void map_filter_keys() {

		// create a map
		Map<String, State> statesKeyByCode = Maps.uniqueIndex(states,
				new Function<State, String>() {
					public String apply(State from) {
						return from.code;
					}
				});

		Predicate<String> byStateCodeContainsVowelI = new Predicate<String>() {
			@Override
			public boolean apply(String stateCode) {
				return stateCode.contains("I");
			}
		};

		Map<String, State> stateCodeWithVowelI = Maps.filterKeys(
				statesKeyByCode, byStateCodeContainsVowelI);

		logger.info(stateCodeWithVowelI);

		assertThat(stateCodeWithVowelI.keySet(), hasSize(2));
	}
	
	/**
	 * Filter map by values
	 */
	@Test
	public void map_filter_by_values() {

		// create a map
		Map<String, State> statesKeyByCode = Maps.uniqueIndex(states,
				new Function<State, String>() {
					public String apply(State from) {
						return from.code;
					}
				});

		Predicate<State> by15MillionOrGreater = new Predicate<State>() {
			@Override
			public boolean apply(State input) {
				return input.population >= 15000000;
			}
		};

		Map<String, State> populationGT15Million = Maps.filterValues(
				statesKeyByCode, by15MillionOrGreater);

		logger.info(populationGT15Million);

		assertThat(populationGT15Million.keySet(), hasSize(3));
	}
	
}
