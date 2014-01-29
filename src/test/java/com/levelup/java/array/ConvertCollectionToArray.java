package com.levelup.java.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;

/**
 * This java example will demonstrate converting a collection to array
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-collection-to-array/'>Convert collection to array</a>
 * 
 */
public class ConvertCollectionToArray {

	private static final Logger logger = Logger.getLogger(ConvertCollectionToArray.class);

	@Test
	public void convert_collection_of_strings_to_array_with_java () {

		List<String> searchEnginesAsList = Lists.newArrayList("Google", "Bing", "Yahoo", "Ask", "AOL"); 
		
		String[] searchEngines = searchEnginesAsList.toArray(new String[searchEnginesAsList.size()]);
		
		logger.info(Arrays.toString(searchEngines));
		
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
		
		logger.info(Arrays.toString(searchEngineMarketShareArray));

		assertEquals(5, searchEngineMarketShareArray.length);
	}

	@Test
	public void convert_collection_of_primitives_to_array_with_java8 () {
		
		List<Double> searchEngineMarketShare = Lists.newArrayList();
		searchEngineMarketShare.add(67.1);
		searchEngineMarketShare.add(16.9);
		searchEngineMarketShare.add(11.8);
		searchEngineMarketShare.add(2.7);
		searchEngineMarketShare.add(1.6);

		double [] searchEngineMarketShareArray = searchEngineMarketShare
				.stream()
				.mapToDouble(Double::doubleValue)
				.toArray();
		
		logger.info(Arrays.toString(searchEngineMarketShareArray));

		assertEquals(5, searchEngineMarketShareArray.length);
	}

	
	@Test
	public void convert_collection_of_objects_to_primitive_array_with_guava () {
		
		List<Double> searchEngineMarketShare = Lists.newArrayList();
		searchEngineMarketShare.add(67.1);
		searchEngineMarketShare.add(16.9);
		searchEngineMarketShare.add(11.8);
		searchEngineMarketShare.add(2.7);
		searchEngineMarketShare.add(1.6);

		double[] searchEngineMarketShareArray = Doubles.toArray(searchEngineMarketShare);
		
		logger.info(Arrays.toString(searchEngineMarketShareArray));
		
		assertEquals(5, searchEngineMarketShareArray.length);
		
	}
	
	@Test
	public void convert_collection_of_objects_to_array_with_apachecommons () {

		List<Double> searchEngineMarketShare = Lists.newArrayList();
		searchEngineMarketShare.add(67.1);
		searchEngineMarketShare.add(16.9);
		searchEngineMarketShare.add(11.8);
		searchEngineMarketShare.add(2.7);
		searchEngineMarketShare.add(1.6);

		Double[] searchEngineMarketShareDoubleArray = searchEngineMarketShare
				.toArray(new Double[searchEngineMarketShare.size()]);
		
		double[] searchEngineMarketShareArray = 
				ArrayUtils.toPrimitive(searchEngineMarketShareDoubleArray);

		logger.info(Arrays.toString(searchEngineMarketShareArray));
		
		assertEquals(5, searchEngineMarketShareArray.length);
	}

}
