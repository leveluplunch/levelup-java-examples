package com.levelup.java.json;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This java example will demonstrate how to convert to/from json map using
 * jackson.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-json-to-from-map-jackson/'>Json
 *      to/from Map using Jackson</a>
 */
public class JsonToFromMapJackson {

	private static final Logger logger = Logger
			.getLogger(JsonToFromMapJackson.class);

	String sampleJson = "{\"ID\":\"SGML\",\"SortAs\":\"SGML\",\"GlossTerm\":\"Standard Generalized Markup Language\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\"}";

	@Test
	public void json_to_map() throws JsonParseException, JsonMappingException,
			IOException {

		Map<String, Object> map = new HashMap<>();

		ObjectMapper mapper = new ObjectMapper();
		map = mapper.readValue(sampleJson,
				new TypeReference<HashMap<String, Object>>() {
				});

		logger.info(sampleJson);

		assertThat(map.keySet(),
				hasItems("ID", "SortAs", "GlossTerm", "Acronym", "Abbrev"));
	}

	@Test
	public void java_map_to_json() throws JsonProcessingException {

		// initialize map
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("ID", "SGML");
		map.put("SortAs", "SGML");
		map.put("GlossTerm", "Standard Generalized Markup Language");
		map.put("Acronym", "SGML");
		map.put("Abbrev", "ISO 8879:1986");

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);

		logger.info(json);

		assertEquals(json, sampleJson);
	}

}
