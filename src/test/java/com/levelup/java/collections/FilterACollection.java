package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * This java snippet will demonstrate how to filter items from a list with 
 * straight up java and google guava.  
 * 
 * Please note, the order of the teams listed is the overall ranking
 * 1 - Green Bay Packers 
 * 2 - Chicago Bears
 * 3 - Detroit Lions
 * 
 * @author Justin Musgrove
 * @see <a href="http://www.leveluplunch.com/java">Filter a collection</>
 */
public class FilterACollection {

	@Test
	public void filter_items_in_list_with_java () {
		
		List<NFLTeam> nflTeams = Lists.newArrayList();
		nflTeams.add(new NFLTeam("Green Bay Packers", true));
		nflTeams.add(new NFLTeam("Chicago Bears", true));
		nflTeams.add(new NFLTeam("Detroit Lions", false));

		//  [NFLTeam{name=Green Bay Packers, wonsuperbow=true}, NFLTeam{name=Chicago Bears, wonsuperbow=true}]
		Collection<NFLTeam> superBowlWinners = new ArrayList<NFLTeam>();
		for (NFLTeam team : nflTeams) {
			if (team.hasWonSuperBowl) {
				superBowlWinners.add(team);
			}
		}
		assertTrue(superBowlWinners.size() == 2);
	}
	
	
	
	@Test
	public void filter_items_in_list_with_guava () {
		
		List<NFLTeam> nflTeams = Lists.newArrayList();
		nflTeams.add(new NFLTeam("Green Bay Packers", true));
		nflTeams.add(new NFLTeam("Chicago Bears", true));
		nflTeams.add(new NFLTeam("Detroit Lions", false));

		// superBowlWinners = [NFLTeam{name=Green Bay Packers, wonsuperbow=true}, NFLTeam{name=Chicago Bears, wonsuperbow=true}]
		Collection<NFLTeam> superBowlWinners = Collections2.filter(nflTeams, new Predicate<NFLTeam> () {
			public boolean apply(NFLTeam nflTeam) {
				return nflTeam.hasWonSuperBowl;
			}
		});
		assertTrue(superBowlWinners.size() == 2);
	}
	
	class NFLTeam {
		
		private String name;
		private boolean hasWonSuperBowl;

		
		public NFLTeam(String name, boolean hasWonSuperBowl) {
			super();
			this.name = name;
			this.hasWonSuperBowl = hasWonSuperBowl;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(NFLTeam.class)
					.add("name", name)
					.add("wonsuperbow", hasWonSuperBowl)
					.toString();
		}

		public String getName() {
			return name;
		}

		public boolean isHasWonSuperBowl() {
			return hasWonSuperBowl;
		}
		
	}
	
	
	
}
