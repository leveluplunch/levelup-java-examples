package com.levelup.java.util.stream;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.levelup.java.array.ConvertCollectionToArray;

/**
 * This java example will demonstrate Stream filter and slice examples.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-stream-filter-slice-example/'>Stream filter slice</a>
 */
public class StreamFilterAndSlice {

	private static final Logger logger = Logger
			.getLogger(ConvertCollectionToArray.class);

	class Post {

		String description;
		String tags;
		int wordlength;

		public Post(String description, String tags, int wordlength) {
			super();
			this.description = description;
			this.tags = tags;
			this.wordlength = wordlength;
		}

		@Override
		public String toString() {

			return com.google.common.base.Objects.toStringHelper(this)
					.add("description", description).add("tags", tags)
					.add("tags", wordlength).toString();
		}

		public String getDescription() {
			return description;
		}

		public String getTags() {
			return tags;
		}

		public int getWordlength() {
			return wordlength;
		}
	}

	List<Post> posts;

	@Before
	public void setUp() {

		posts = new ArrayList<>();

		posts.add(new Post("Java 8 is jammed packed with some cool",
				"java 8, eclipse", 459));
		posts.add(new Post("The Date-Time package introduced in the Java SE 8",
				"java 8, date time api", 750));
		posts.add(new Post("Prefer empty collection to null is a basic",
				"clean code, java", 245));
		posts.add(new Post("Screencast #1: Intro to filtering collections",
				"java, java tutorial, guava", 1234));
		posts.add(new Post("Screencast #2: Intro to transforming objects",
				"java, java tutorial", 9483));
	}

	@Test
	public void filter_with_predicate() {

		List<Post> postWithLessThan500 = posts.stream()
				.filter(p -> p.wordlength < 500).collect(Collectors.toList());

		assertEquals(2, postWithLessThan500.size());
	}

	@Test
	public void filter_unique_elements() {

		List<String> tags = posts
				.stream()
				.map(Post::getTags)
				.flatMap(
						tag -> Arrays.stream(tag.split(",")).map(String::trim)
								.map(String::toLowerCase)).distinct()
				.collect(Collectors.toList());

		assertThat(
				tags,
				contains("java 8", "eclipse", "date time api", "clean code",
						"java", "java tutorial", "guava"));

	}

	@Test
	public void filter_and_truncate() {

		List<Post> firstTwoPosts = posts.stream().limit(2)
				.collect(Collectors.toList());

		logger.info(firstTwoPosts);

		assertEquals(2, firstTwoPosts.size());
	}

	@Test
	public void skipping_elements() {

		List<Post> firstTwoPosts = posts.stream().skip(4)
				.collect(Collectors.toList());

		logger.info(firstTwoPosts);

		assertEquals(1, firstTwoPosts.size());
	}

}
