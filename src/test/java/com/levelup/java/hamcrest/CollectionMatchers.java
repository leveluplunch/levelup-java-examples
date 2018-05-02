package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.collection.IsIn.isOneOf;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate testing
 * collections with junit hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/hamcrest-collection-matchers-junit-testing/'>Collection matchers</a>
 * 
 */
public class CollectionMatchers {

	// collections
	@Test
	public void check_size_of_collection () {
		
		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
		
		assertThat(fruit, hasSize(5));
	}
	
	@Test
	public void collection_contains_elements_in_order () {
		
		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
		
	    assertThat(fruit, contains(
	    		"apple", "banana", "pear", "blackberry", "grape"));
	}

	@Test
	public void collection_contains_elements_in_any_order () {
		
		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
		
	    assertThat(fruit, containsInAnyOrder(
	    		"banana", "apple", "blackberry", "grape", "pear"));
	}
	
	@Test
	public void collection_contains_element () {
		
		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
	    
		assertThat(fruit, hasItem("apple"));
	}

	@Test
	public void collection_contains_elements () {
		
		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
		
	    assertThat(fruit, hasItems("apple", "pear"));
	}
	
	@Test
	public void element_in_collection () { 

		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
		
	    assertThat("apple", isIn(fruit));
	}
	
	@Test
	public void element_in_one_of () { 
	
		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
		
	    assertThat("apple", isOneOf(fruit.toArray()));
	}

	@Test
	public void collection_is_empty () { 
	
		List<String> fruit = Lists.newArrayList();
	    assertThat(fruit, empty());
	}

	@Test
	public void collection_is_not_empty () { 
	
		List<String> fruit = Lists.newArrayList(
				"apple", "banana", "pear", "blackberry", "grape");
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

}
