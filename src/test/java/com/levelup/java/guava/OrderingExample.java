package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * This java example will demonstrate some
 * capabilities of Guava's Ordering
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class OrderingExample {
	
	private static final Logger logger = Logger.getLogger(OrderingExample.class);
	
	@Test
	public void order_list_of_strings_alphabetically_case_insensitive () {
		
		List<String> TOP_RATED_CENTERS = Lists.newArrayList(
				"Dawson", "Gatski", "Langer", "Hein", "Frankie Baggadonuts", "Turner", "Trafton", "Stephenson", "Ringo", "Otto", "Webster");

		
		String topNameAlphabetically = Ordering.from(String.CASE_INSENSITIVE_ORDER).min(TOP_RATED_CENTERS);
		
		assertEquals("Dawson", topNameAlphabetically);

	}
	
	class GlassWare {
		
		private String name;
		private String description;
		
		public GlassWare(String name, String description) {
			super();
			this.name = name;
			this.description = description;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}
		
	}
	
	@Test
	public void order_by_object_field () {
		
		List<GlassWare> beerGlasses = Lists.newArrayList(
				new GlassWare("Flute Glass", "Enhances and showcases carbonation. Releases volatiles quickly for a more intense upfront aroma."),
				new GlassWare("Pilsner Glass (or Pokal)", "showcases color, clarity and carbonation. Promotes head retention. Enhances volatiles."),
				new GlassWare("Pint Glass", "cheap to make. Easy to store. Easy to drink out of. "),
				new GlassWare("Goblet (or Chalice)", "Eye candy. Designed to maintain head. Wide-mouthed for deep sips. "),
				new GlassWare("Mug (or Seidel, Stein)", "Easy to drink out of. Holds plenty of volume. "),
				new GlassWare(null, null)
			);
		
		Ordering<GlassWare> byGlassWareName = Ordering.natural().nullsFirst().onResultOf(new Function <GlassWare, String> () {
			  public String apply(GlassWare glassWare) {
			    return glassWare.getName();
			  }
			});
		
		GlassWare firstBeerGlass = byGlassWareName.min(beerGlasses);
		
		// first element will be null
		assertNull(firstBeerGlass.getName());

		GlassWare lastBeerGlass = byGlassWareName.max(beerGlasses);
		assertEquals("Pint Glass", lastBeerGlass.getName());

	}
	
	@Test
	public void find_max_value_from_list_of_integers_guava () {

		List<Integer> top10CentersNumbers = Lists.newArrayList(
				63, 52, 62, 0, 66, 0, 57, 51, 60
				);
		
		Integer maxJerseyNumber = Ordering.natural().max(top10CentersNumbers);
		
		assertEquals(new Integer (66), maxJerseyNumber);
	}
	
	@Test 
	public void order_elements_based_on_length () {
		
		Ordering<String> byLength = new Ordering<String>() {
		   @Override
		   public int compare(String s1, String s2) {
		      return Ints.compare(s1.length(), s2.length());
		   }
		};
		
		List<String> famousBridges = Lists.newArrayList(
				"Great Belt Bridge", 
				"Chapel Bridge", 
				"Chengyang Bridge",
				"null",
				"Brooklyn Bridge",
				"Ponte Vecchio"
				);
		
		Collections.sort(famousBridges,
				byLength.nullsFirst());

		//[null, Chapel Bridge, Ponte Vecchio, Brooklyn Bridge, Chengyang Bridge, Great Belt Bridge]
		assertEquals("Great Belt Bridge", famousBridges.get(5));
	}
	
	@Test
	public void reverse_elements_in_list () {
		
		Ordering<String> byLength = new Ordering<String>() {
		   @Override
		   public int compare(String s1, String s2) {
		      return Ints.compare(s1.length(), s2.length());
		   }
		};
		
		List<String> famousBridges = Lists.newArrayList(
				"Great Belt Bridge", 
				"Chapel Bridge", 
				"Chengyang Bridge",
				"null",
				"Brooklyn Bridge",
				"Ponte Vecchio"
				);
		
		Collections.sort(famousBridges,
				byLength.nullsFirst().reverse());
		
		logger.info(famousBridges); //[Great Belt Bridge, Chengyang Bridge, Brooklyn Bridge, Chapel Bridge, Ponte Vecchio, null]
		assertEquals("Great Belt Bridge", famousBridges.get(0));

	}
	
	@Test
	public void order_list_of_integer_least_to_greatest () {
		
		List<Integer> startingLineUp = Lists.newArrayList(
				73, 58, 66, 57, 32, 88, 90, 12, 15, 99, 11
			);
		
		List<Integer> startingLineUpInOrder = Ordering.natural().leastOf(startingLineUp, startingLineUp.size());
		
		logger.info(startingLineUpInOrder); 		//		[11, 12, 15, 32, 57, 58, 66, 73, 88, 90, 99]
		
		assertEquals(new Integer(11), startingLineUpInOrder.get(0));

	}
	
	@Test
	public void order_list_of_integer_greatest_to_least () {
		
		List<Integer> startingLineUp = Lists.newArrayList(
				73, 58, 66, 57, 32, 88, 90, 12, 15, 99, 11
			);
		
		List<Integer> startingLineUpGreatestToLeast = Ordering.natural().greatestOf(startingLineUp, startingLineUp.size());
		
		logger.info(startingLineUpGreatestToLeast); 		//		[11, 12, 15, 32, 57, 58, 66, 73, 88, 90, 99]
		
		assertEquals(new Integer(99), startingLineUpGreatestToLeast.get(0));

	}	
	


}
