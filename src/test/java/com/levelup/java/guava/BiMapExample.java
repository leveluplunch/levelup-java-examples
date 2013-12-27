package com.levelup.java.guava;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * BiMap allows you have a set of entries that you can easily inverse the keys/values
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-bimap-example/'>Guava BiMap Example</a>
 */
public class BiMapExample {

	private static final Logger logger = Logger.getLogger(BiMapExample.class);
	
	@Test
	public void bidirectional_map_with_guava () {
		
		BiMap<String, String> dialectConverterForWisconsinites = 
				HashBiMap.create();
		
		dialectConverterForWisconsinites.put("bratwurst", "brat");
		dialectConverterForWisconsinites.put("drinking fountain", "bubbler");
		dialectConverterForWisconsinites.put("that", "dat");
		dialectConverterForWisconsinites.put("alright", "iet");
		dialectConverterForWisconsinites.put("soda", "pop");

		BiMap<String, String> dialectConverterForEveryoneElse = dialectConverterForWisconsinites.inverse();

		logger.info(dialectConverterForEveryoneElse);
		
		assertNotNull(dialectConverterForEveryoneElse.get("brat"));
	}

	@Test
	public void bidirectional_map_with_java () {
		
		Map<String,String> dialectConverterForWisconsinites = new HashMap<String,String>();
		dialectConverterForWisconsinites.put("bratwurst", "brat");
		dialectConverterForWisconsinites.put("drinking fountain", "bubbler");
		dialectConverterForWisconsinites.put("that", "dat");
		dialectConverterForWisconsinites.put("alright", "iet");
		dialectConverterForWisconsinites.put("soda", "pop");
		
		Map<String,String> dialectConverterForEveryoneElse = new HashMap<String,String>();
		for (Entry<String,String> entry: dialectConverterForWisconsinites.entrySet()) {
			dialectConverterForEveryoneElse.put(entry.getValue(), entry.getKey());
		}

		logger.info(dialectConverterForEveryoneElse);

		assertNotNull(dialectConverterForEveryoneElse.get("brat"));
	}

}
