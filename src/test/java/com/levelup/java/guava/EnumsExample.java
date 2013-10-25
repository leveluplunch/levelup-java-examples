package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;

import com.google.common.base.Enums;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate uses of 
 * Guava Enums.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-enums-example/'>Enums example</a>
 * 
 */
public class EnumsExample {
	
	enum Day {
		
	    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY 
	} 
	
	
	@Test
	public void enums_getfield () {
		
		Field field = Enums.getField(Day.FRIDAY);
		
	    assertTrue(field.isEnumConstant());
	}
	
	@Test
	public void enums_getIfPresent () {
		
		Optional<Day> friday = Enums.getIfPresent(Day.class, "FRIDAY");
		
	    assertEquals(friday.get(), Day.FRIDAY);
	}

	@Test
	public void enums_valueOfFunction () {
		
	    Function<String, Day> valueOfFunction = Enums.valueOfFunction(Day.class);
	    
	    Day friday = valueOfFunction.apply("FRIDAY");
	    
	    assertEquals(friday, Day.FRIDAY);
	}
	
	
	@Test
	public void transform_string_to_enum () {
	
		List<String> days = Lists.newArrayList(
				"WEDNESDAY", 
				"SUNDAY", 
				"MONDAY", 
				"TUESDAY", 
				"WEDNESDAY");
		
	    Function<String, Day> valueOfFunction = Enums.valueOfFunction(Day.class);

		Iterable<Day> daysAsEnums = Iterables.transform(days, valueOfFunction);
		
		assertThat(daysAsEnums, IsIterableWithSize.<Day>iterableWithSize(5));
		assertThat(daysAsEnums, IsIterableContainingInOrder.
				<Day>contains(
						Day.WEDNESDAY, 
						Day.SUNDAY, 
						Day.MONDAY, 
						Day.TUESDAY, 
						Day.WEDNESDAY));

	}
}
