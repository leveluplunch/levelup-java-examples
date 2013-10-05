package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsArray.array;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.collection.IsIn.isOneOf;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate testing
 * collections with junit hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-collections-testing-hamcrest/'>Unit test collections</a>
 * 
 */
public class CollectionMatchers {
	
	// iterables
	@Test
	public void check_size_of_iterable () {
		
		List<String> cloths = Lists.newArrayList(
				"shirts", "shoes", "pants", "socks");
		
		assertThat(cloths, IsIterableWithSize.<String>iterableWithSize(4));
	}
	
	@Test 
	public void iterable_has_any_order () {

		List<String> cloths = Lists.newArrayList(
				"shirts", "shoes", "pants", "socks");
		
		assertThat(cloths, IsIterableContainingInAnyOrder.
				<String>containsInAnyOrder("shoes", "pants", "shirts", "socks"));
		
	}
	
	@Test
	public void iterable_matches_order () {

		List<String> cloths = Lists.newArrayList(
				"shirts", "shoes", "pants", "socks");
		
		assertThat(cloths, IsIterableContainingInOrder.
				<String>contains("shirts", "shoes", "pants", "socks"));

	}
	
//	array
	@Test
	public void check_size_of_array () {
		
		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, arrayWithSize(3));
	}
	
	@Test
	public void array_contains_all_elements () {

		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, arrayContaining(10, 15, 20));
	}

	@Test
	public void array_contains_all_elements_in_any_order () {

		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, arrayContainingInAnyOrder(20, 10, 15));
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void check_array_elements_equal() {

		Integer[] numbers = new Integer[] {10, 15, 20};
		assertThat(numbers, 
				is(array(equalTo(10), equalTo(15), equalTo(20)))); 
	}
	
	// collections
	@Test
	public void check_size_of_collection () {
		
		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
		assertThat(fruit, hasSize(5));
	}
	
	@Test
	public void collection_contains_elements_in_order () {
		
		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
	    assertThat(fruit, contains("apple", "banana", "pear", "blackberry", "grape"));
		
	}

	@Test
	public void collection_contains_elements_in_any_order () {
		
		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
	    assertThat(fruit, containsInAnyOrder("banana", "apple", "blackberry", "grape", "pear"));
	}
	
	@Test
	public void collection_contains_element () {
		
		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
	    assertThat(fruit, hasItem("apple"));
		
	}

	@Test
	public void collection_contains_elements () {
		
		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
	    assertThat(fruit, hasItems("apple"));
	}
	
	@Test
	public void element_in_collection () { 

		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
	    assertThat("apple", isIn(fruit));
	    
	}
	
	@Test
	public void element_in_one_of () { 
	
		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
	    assertThat("apple", isOneOf(fruit.toArray()));
	}

	@Test
	public void collection_is_empty () { 
	
		List<String> fruit = Lists.newArrayList();
	    assertThat(fruit, empty());
	}

	@Test
	public void collection_is_not_empty () { 
	
		List<String> fruit = Lists.newArrayList("apple", "banana", "pear", "blackberry", "grape");
	    assertThat(fruit, not(empty()));
	}
	
	@Test
	public void each_element_ends_with () { 
	
		List<String> cereal = Lists.newArrayList(
				"mini wheats", "corn flakes",
				"honey smacks", "apple jacks", 
				"lucky charms");
	    
		assertThat(cereal, hasItem(endsWith("s")));
	}
	
	// Maps
	@Test
	public void map_has_entry () {

		Map<String, String> breeds = Maps.newHashMap();
		breeds.put("labrador", "buzz");
		breeds.put("dachshund", "gypsy");
		breeds.put("boxer", "buddy");
		
		assertThat(breeds, hasEntry("labrador", "buzz"));
	}
	
	@Test
	public void map_has_key () {

		Map<String, String> breeds = Maps.newHashMap();
		breeds.put("labrador", "buzz");
		breeds.put("dachshund", "gypsy");
		breeds.put("boxer", "buddy");
		
		assertThat(breeds, hasKey("labrador"));
	}
	
	@Test
	public void map_has_hasValue () {

		Map<String, String> breeds = Maps.newHashMap();
		breeds.put("labrador", "buzz");
		breeds.put("dachshund", "gypsy");
		breeds.put("boxer", "buddy");
		
		assertThat(breeds, hasValue("gypsy"));
	}

}
