package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;

/**
 * This java snippet will demonstrate converting a collection to array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class ConvertCollectionToArray {

	
	@Test
	public void convert_collection_of_strings_to_array_with_java () {

		List<String> searchEnginesAsList = Lists.newArrayList("Google", "Bing", "Yahoo", "Ask", "AOL"); 
		
		String[] searchEngines = searchEnginesAsList.toArray(new String[searchEnginesAsList.size()]);
		
		assertEquals(5, searchEngines.length);
		
	}

	@Test
	public void convert_collection_of_primitives_to_array_with_java () {
		
		List<Double> searchEngineMarketShare = Lists.newArrayList();
		searchEngineMarketShare.add(67.1);
		searchEngineMarketShare.add(16.9);
		searchEngineMarketShare.add(11.8);
		searchEngineMarketShare.add(2.7);
		searchEngineMarketShare.add(1.6);
		
		double [] searchEngineMarketShareArray = new double[searchEngineMarketShare.size()];
		for (int x=0; x <= searchEngineMarketShare.size() - 1; x ++) {
			searchEngineMarketShareArray[x] = searchEngineMarketShare.get(x);
		}
		assertEquals(5, searchEngineMarketShareArray.length);
	}

	@Test
	public void convert_collection_of_primitives_to_array_with_guava () {
		
		List<Double> searchEngineMarketShare = Lists.newArrayList();
		searchEngineMarketShare.add(67.1);
		searchEngineMarketShare.add(16.9);
		searchEngineMarketShare.add(11.8);
		searchEngineMarketShare.add(2.7);
		searchEngineMarketShare.add(1.6);

		double[] searchEngineMarketShareArray = Doubles.toArray(searchEngineMarketShare);
		
		assertEquals(5, searchEngineMarketShareArray.length);
		
	}
	
	@Test
	public void convert_collection_of_primitives_to_array_with_apachecommons () {

		List<Double> searchEngineMarketShare = Lists.newArrayList();
		searchEngineMarketShare.add(67.1);
		searchEngineMarketShare.add(16.9);
		searchEngineMarketShare.add(11.8);
		searchEngineMarketShare.add(2.7);
		searchEngineMarketShare.add(1.6);

		Double[] searchEngineMarketShareDoubleArray = searchEngineMarketShare.toArray(new Double[searchEngineMarketShare.size()]);
		double[] searchEngineMarketShareArray = ArrayUtils.toPrimitive(searchEngineMarketShareDoubleArray);

		assertEquals(5, searchEngineMarketShareArray.length);
	}

}
