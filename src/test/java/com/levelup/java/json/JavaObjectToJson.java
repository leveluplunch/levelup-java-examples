package com.levelup.java.json;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

/**
 * This java example will demonstrate marshalling java object and java list to json
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-object-to-json/'>Java object to json</a>
 * 
 */
public class JavaObjectToJson {

	private static final Logger logger = Logger.getLogger(JavaObjectToJson.class);
	
	class Plane {
		private String planeType;

		public Plane(String planeType) {
			super();
			this.planeType = planeType;
		}

		public String getPlaneType() {
			return planeType;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("plane type: ", planeType).toString();
		}
		
	}
	
	private static final String JSON_ARRAY = "[{\"planeType\":\"Commercial Transport Planes\"},{\"planeType\":\"General Aviation Planes\"},{\"planeType\":\"Military Planes\"},{\"planeType\":\"Sea Planes\"},{\"planeType\":\"Special Purpose Planes\"}]";
	private static final String JSON_OBJECT = "{\"planeType\":\"Sea Planes\"}";
	
	private List<Plane> planes = Lists.newArrayList();
	private Plane seaPlane; 
	
	@Before
	public void seedData () {
		planes.add(new Plane("Commercial Transport Planes"));
		planes.add(new Plane("General Aviation Planes"));
		planes.add(new Plane("Military Planes"));
		planes.add(new Plane("Sea Planes"));
		planes.add(new Plane("Special Purpose Planes"));
		
		seaPlane = new Plane("Sea Planes");
	}
	
	@Test
	public void marshall_java_object_to_json_with_gson () {
		Gson gson = new Gson();
		String json = gson.toJson(seaPlane);

		logger.info(json);
		
		assertEquals(JSON_OBJECT, json);
	}
	
	@Test
	public void marshall_java_list_to_json_with_gson () {
		Gson gson = new Gson();
		String json = gson.toJson(planes);
		
		logger.info(json);
		
		assertEquals(JSON_ARRAY, json);
	}

	@Test
	public void marshall_java_object_to_json_with_jackson () throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(seaPlane);

		logger.info(json);
		
		assertEquals(JSON_OBJECT, json);
	}

	
	@Test
	public void marshall_java_list_to_json_with_jackson () throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(planes);
		
		logger.info(json);
		
		assertEquals(JSON_ARRAY, json);
	}

}
