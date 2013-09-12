package com.levelup.java.guava;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * BiMap allows you have a set of entries that you can easily inverse the keys/values
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>BiMap Example</a>
 */
public class BiMapExample {

	@Test
	public void inverse_map_with_guava () {
		
		BiMap<String, String> dialectConverterForWisconsinites = 
				HashBiMap.create();
		
		dialectConverterForWisconsinites.put("bratwurst", "brat");
		dialectConverterForWisconsinites.put("drinking fountain", "bubbler");
		dialectConverterForWisconsinites.put("that", "dat");
		dialectConverterForWisconsinites.put("alright", "iet");
		dialectConverterForWisconsinites.put("soda", "pop");

		BiMap<String, String> dialectConverterForEveryoneElse = dialectConverterForWisconsinites.inverse();

		//dialectConverterForEveryoneElse = {bubbler=drinking fountain, brat=bratwurst, iet=alright, dat=that, pop=soda}
		
		assertNotNull(dialectConverterForEveryoneElse.get("brat"));
	}

	@Test
	public void inverse_map_with_java () {
		
		// this is just for illustration - you could create a generic method that handles the inverse
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

		//dialectConverterForEveryoneElse = {bubbler=drinking fountain, brat=bratwurst, iet=alright, dat=that, pop=soda}

		assertNotNull(dialectConverterForEveryoneElse.get("brat"));
	}

}
