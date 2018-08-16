package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate converting a list to map with 
 * straight up java, lambda and google guava.
 * 
 * @author Justin Musgrove
 * @see <a href="http://www.leveluplunch.com/java/examples/convert-list-to-map/">Convert List To Map</a>
 */
public class ConvertListToMap {
	
	private static final Logger logger = Logger.getLogger(ConvertListToMap.class);
	
	class Movie {

		private Integer rank;
		private String description;
		
		public Movie(Integer rank, String description) {
			super();
			this.rank = rank;
			this.description = description;
		}
		
		public Integer getRank() {
			return rank;
		}

		public String getDescription() {
			return description;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("rank", rank)
					.add("description", description)
					.toString();
		}
	}
	
	@Test
	public void convert_list_to_map_with_java () {
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "The Shawshank Redemption"));
		movies.add(new Movie(2, "The Godfather"));

		Map<Integer, Movie> mappedMovies = new HashMap<Integer, Movie>();
		for (Movie movie : movies) {
			mappedMovies.put(movie.getRank(), movie);
		}
		
		logger.info(mappedMovies);

		assertTrue(mappedMovies.size() == 2);
		assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());
	}
	
	@Test
	public void convert_list_to_map_with_java8_lambda () {
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "The Shawshank Redemption"));
		movies.add(new Movie(2, "The Godfather"));

		Map<Integer, Movie> mappedMovies = movies.stream().collect(
				Collectors.toMap(Movie::getRank, (p) -> p));

		logger.info(mappedMovies);

		assertTrue(mappedMovies.size() == 2);
		assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());
	}

	@Test
	public void convert_list_string_to_map_with_java8_lambda() {
        List<String> attributes = Arrays.asList("Title",
                "Price",
                "Bokey",
                "LastMatchingChange",
                "LastShopDataChange",
                "CheckoutApproved",
                "OnlineProductIds");

        Map<String, Integer> stringIntegerMap = attributes.stream()
                .collect(Collectors.toMap(java.util.function.Function.identity(), String::length));

        logger.info(stringIntegerMap);
        assertTrue(stringIntegerMap.size() == 7);
	}

	@Test
	public void convert_list_to_map_with_java8_pair() {
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "The Shawshank Redemption"));
		movies.add(new Movie(2, "The Godfather"));

		Map<Integer, Movie> mappedMovies = movies.stream()
				.map(s -> Pair.of(s.getRank(), s))
				.collect(Collectors.toMap(Pair::getKey, Pair::getValue));

		logger.info(mappedMovies);
		assertTrue(mappedMovies.size() == 2);
		assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());

	}

	@Test
	public void convert_list_to_map_with_guava () {

		// create a list
		List<Movie> movies = Lists.newArrayList();
		movies.add(new Movie(1, "The Shawshank Redemption"));
		movies.add(new Movie(2, "The Godfather"));
		
		// convert list to map 
		Map<Integer,Movie> mappedMovies = Maps.uniqueIndex(movies, new Function <Movie,Integer> () {
			  public Integer apply(Movie from) {
			    return from.getRank(); // or something else
		}});
		
		logger.info(mappedMovies);
		
		assertTrue(mappedMovies.size() == 2);
		assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());
	}
	
}
