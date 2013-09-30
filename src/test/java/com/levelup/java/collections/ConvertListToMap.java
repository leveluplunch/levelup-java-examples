package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate converting a list to map with 
 * straight up java and google guava.
 * 
 * @author Justin Musgrove
 * @see <a href="http://www.leveluplunch.com/java">Convert List To Map</a>
 */
public class ConvertListToMap {
	
	@Test
	public void convert_list_to_map_with_java () {
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "The Shawshank Redemption"));
		movies.add(new Movie(2, "The Godfather"));

		Map<Integer, Movie> mappedMovies = new HashMap<Integer, Movie>();
		for (Movie movie : movies) {
			mappedMovies.put(movie.getRank(), movie);
		}
		
		//mappedMovies = {1=com.levelup.java.collections.ConvertListToMap$Movie@37bd2664, 2=com.levelup.java.collections.ConvertListToMap$Movie@63238bd2}
		
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
		
		//mappedMovies = {1=com.levelup.java.collections.ConvertListToMap$Movie@37bd2664, 2=com.levelup.java.collections.ConvertListToMap$Movie@63238bd2}
		
		assertTrue(mappedMovies.size() == 2);
		assertEquals("The Shawshank Redemption", mappedMovies.get(1).getDescription());
	}
	
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
		
	}
	

}
