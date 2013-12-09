package com.levelup.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate java's
 * branching statements break and continue.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com//'></a>
 */
public class BranchingStatements {

	@Test
	public void break_statement_unlabeled () {

		String[] countries = {"United States", "Great Britain", "Canada"}; 
		
        String countryToSearchFor = "Great Britain";
        int count = 0;
        
        for (String country : countries) {
        	
        	if (country.equals(countryToSearchFor)) {
        		break;
        	}
        	count ++;
        }
        
        assertEquals(1, count);
	}
	
	@Test
	public void break_statement_labeled () {
		
		String[] countries = {"United States", "Great Britain", "Canada"};
		String[] capitals = {"Washington DC", "London", "Ottawa"};

        String countryToSearchFor = "Great Britain";
        String capitalToSearchFor = "London";
        
        int count = 0;
        
        capitalSearch : 
	        for (String country : countries) {
	        	
	        	for (String capital : capitals) {
	        		
	        		if (country.equals(countryToSearchFor)) {
	        			if (capital.equals(capitalToSearchFor)) {
	        				break capitalSearch;
	        			}
	        		}
	        		count++;
	        	}
	        }

        assertEquals(4, count);
	}
	
	@Test 
	public void continue_statement () {
		
		int[] testScores = {23, 55, 78, 67, 99, 82};
		
		int passingTestScores = 0;
		
		for (int score : testScores) {
			
			if (score <= 60) {
				continue;
			}
			
			passingTestScores ++;
		}
	
        assertEquals(4, passingTestScores);
	}
	
}
