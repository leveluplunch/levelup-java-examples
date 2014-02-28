package com.levelup.java.util.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Objects;

/**
 * This java example will demonstrate java.util.stream common find and match
 * methods.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-stream-find-match-example/'>Stream find and match</a>
 */
public class StreamFindAndMatch {

	class HiddenObjectGame {

		String name = null;
		double rating;
		double totalPlays;
		LocalDate releaseDate;

		public HiddenObjectGame(String name, double rating, double totalPlays,
				LocalDate releaseDate) {
			super();
			this.name = name;
			this.rating = rating;
			this.totalPlays = totalPlays;
			this.releaseDate = releaseDate;
		}

		public String getName() {
			return name;
		}

		public double getRating() {
			return rating;
		}

		public double getTotalPlays() {
			return totalPlays;
		}

		public LocalDate getReleaseDate() {
			return releaseDate;
		}

		@Override
		public String toString() {

			return Objects.toStringHelper(this).add("name", name)
					.add("rating", rating).add("totalPlays", totalPlays)
					.add("releaseDate", releaseDate).toString();
		}

	}

	List<HiddenObjectGame> games;

	@Before
	public void setUp() {

		games = new ArrayList<>();

		games.add(new HiddenObjectGame("The Daily SNOOP", 4.65, 22207,
				LocalDate.of(2011, Month.MARCH, 15)));
		games.add(new HiddenObjectGame("Gardenscapes", 4.43, 1670, LocalDate
				.of(2009, Month.DECEMBER, 29)));
		games.add(new HiddenObjectGame("Barn Yarn", 4.55, 1453, LocalDate.of(
				2013, Month.JUNE, 18)));
		games.add(new HiddenObjectGame("The Treasures of Mystery Island", 4.09,
				594, LocalDate.of(2009, Month.JUNE, 29)));
		games.add(new HiddenObjectGame("Paparazzi", 3.74, 391, LocalDate.of(
				2006, Month.OCTOBER, 10)));
	}

	@Test
	public void stream_allMatch() {

		boolean containVowel = games.stream().allMatch(
				game -> game.getName().contains("a"));

		assertTrue(containVowel);

	}

	@Test
	public void stream_anyMatch() {

		boolean playsGt1000 = games.stream().anyMatch(
				game -> game.getTotalPlays() > 1000);

		assertTrue(playsGt1000);
	}

	@Test
	public void stream_noneMatch() {

		Predicate<HiddenObjectGame> playsGt1000 = p -> p.getTotalPlays() > 1000;
		Predicate<HiddenObjectGame> ratingGt5 = p -> p.getRating() > 5;

		boolean noneMatch = games.stream()
				.noneMatch(ratingGt5.and(playsGt1000));

		assertTrue(noneMatch);
	}

	@Test
	public void stream_findFirst() {

		Optional<HiddenObjectGame> firstHiddenGame = games.stream().findFirst();

		assertTrue(firstHiddenGame.isPresent());
		assertEquals("The Daily SNOOP", firstHiddenGame.get().getName());
	}

	@Test
	public void stream_findAny() {

		Predicate<HiddenObjectGame> releaseDateInApril = p -> Month.APRIL == p
				.getReleaseDate().getMonth();

		Optional<HiddenObjectGame> hiddenGameReleaseInApril = games.stream()
				.filter(releaseDateInApril).findAny();
		
		assertFalse(hiddenGameReleaseInApril.isPresent());
	}

}
