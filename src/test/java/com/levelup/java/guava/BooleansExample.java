package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;

/**
 * This example demostrates uses of Google guavas Booleans, static utility
 * methods pertaining to boolean primitives that are not found in Boolean or Arrays.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-booleans-utility-example/'>Booleans utility example</a>
 */
public class BooleansExample {
	
	
	@Test
	public void count_total_number_of_booleans () {
		
		boolean [] values = {true, true, false, true, false};
		
		int count = Booleans.countTrue(values);
		
		assertEquals(3, count);
	}
	
	@Test
	public void convert_boolean_array_to_Boolean_list () {

		boolean[] booleanArray = {true, false, true, false};
		
		List<Boolean> booleans = Booleans.asList(booleanArray);
		
		assertEquals(4, booleans.size());
	}
	
	@Test
	public void concat_boolean_arrays () {

		boolean[] booleanArray1 = {true, false};
		boolean[] booleanArray2 = {true, false};

		boolean[] concatedArray = Booleans.concat(booleanArray1, booleanArray2);
		
		assertEquals(4, concatedArray.length);
	}
	
	@Test
	public void boolean_array_contains () {
		
		boolean[] booleanArray = {true, false, true, false};

		boolean arrayContains = Booleans.contains(booleanArray, true);
		
		assertTrue(arrayContains);
	}
	
	@Test
	public void boolean_array_index () {

		boolean[] booleanArray = {true, false, true, false};

		int index = Booleans.indexOf(booleanArray, false);
		
		assertEquals(1, index);
	}
	
	@Test
	public void join_elements_of_boolean_array () {

		boolean[] booleanArray = {true, false, true, false};

		String joinedElements = Booleans.join("-", booleanArray);
		
		assertEquals("true-false-true-false", joinedElements);
	}
	
	@Test
	public void convert_Boolean_to_primitive () {

		List<Boolean> booleans = Lists.newArrayList(
				Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);
		
		boolean[] primitiveArray = Booleans.toArray(booleans);
		
		assertEquals(4, primitiveArray.length);
	}		

}
