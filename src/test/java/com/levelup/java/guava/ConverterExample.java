package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.Converter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;

/**
 * This java example will demonstrate ways to use {@link Converter}s.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-converter-example/'>Converter example</a>
 */
public class ConverterExample {
	
	@Test
	public void double_converter () {
		
		Double val = Doubles.stringConverter().convert("1.0");
		
		assertEquals(new Double(1), val);
		
		String valAsString = Doubles.stringConverter().reverse().convert(new Double(1));
		
		assertEquals("1.0", valAsString);
	}
	
	@Test
	public void float_converter () {

		Float val = Floats.stringConverter().convert("2.0");
		
		assertEquals(new Float(2), val);
		
		String valAsString = Floats.stringConverter().reverse().convert(new Float(2));
		
		assertEquals("2.0", valAsString);
	}

	@Test
	public void ints_converter () {

		Integer val = Ints.stringConverter().convert("3");
		
		assertEquals(new Integer(3), val);
		
		String valAsString = Ints.stringConverter().reverse().convert(new Integer(3));
		
		assertEquals("3", valAsString);
	}

	@Test
	public void longs_converter () {

		Long val = Longs.stringConverter().convert("4");
		
		assertEquals(new Long(4), val);
		
		String valAsString = Longs.stringConverter().reverse().convert(new Long(4));
		
		assertEquals("4", valAsString);
	}
	
	@Test
	public void shorts_converter () {

		Short val = Shorts.stringConverter().convert("5");
		
		assertEquals(new Short("5"), val);
		
		String valAsString = Shorts.stringConverter().reverse().convert(new Short("5"));
		
		assertEquals("5", valAsString);
	}
	
	@Test
	public void maps_converter () {
		
		BiMap<String, String> stateCapitals = 
				HashBiMap.create();
		
		stateCapitals.put("Wisconsin", "Madison");
		stateCapitals.put("Iowa", "Des Moines");
		stateCapitals.put("Minnesota", "Saint Paul");
		stateCapitals.put("Illinois", "Springfield");
		stateCapitals.put("Michigan", "Lansing");

		Converter<String, String> converter = Maps.asConverter(stateCapitals);
		
		String state = converter.reverse().convert("Madison");
		
		assertEquals("Wisconsin", state);
	}
	
}
