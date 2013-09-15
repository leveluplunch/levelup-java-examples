package com.levelup.java.json;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * This java snippet will demonstrate converting json to a java object.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class JsontoJavaObject {

	static class Plane {
		private String planeType;

		public Plane() {
			// TODO Auto-generated constructor stub
		}
		
		public String getPlaneType() {
			return planeType;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("plane type: ", planeType).toString();
		}
		
	}

	private final String ARRAY_AS_JSON = "[{\"planeType\":\"Commercial Transport Planes\"},{\"planeType\":\"General Aviation Planes\"},{\"planeType\":\"Military Planes\"},{\"planeType\":\"Sea Planes\"},{\"planeType\":\"Special Purpose Planes\"}]";
	private static final String JSON_OBJECT = "{\"planeType\":\"Sea Planes\"}";
	
	@Test
	public void unmarshall_json_to_object_with_gson () {
		Gson gson = new Gson();

		Plane plane = gson.fromJson(JSON_OBJECT, Plane.class);
		
		assertEquals("Sea Planes", plane.getPlaneType());
	}
	
	
	@Test
	public void unmarshall_json_to_list_with_gson () {
		
		Gson gson = new Gson();
		
		@SuppressWarnings("serial")
		List<Plane> planes = gson.fromJson(ARRAY_AS_JSON, new TypeToken<List<Plane>>(){}.getType());
		
//		[Plane{plane type: =Commercial Transport Planes}, Plane{plane type: =General Aviation Planes}, Plane{plane type: =Military Planes}, Plane{plane type: =Sea Planes}, Plane{plane type: =Special Purpose Planes}]
		
		assertEquals(5, planes.size());
	}

	@Test
	public void unmarshall_json_to_java_array_with_gson () {
		
		Gson gson = new Gson();
		
		Plane[] planes = gson.fromJson(ARRAY_AS_JSON, Plane[].class);
		
//		[Plane{plane type: =Commercial Transport Planes}, Plane{plane type: =General Aviation Planes}, Plane{plane type: =Military Planes}, Plane{plane type: =Sea Planes}, Plane{plane type: =Special Purpose Planes}]
		
		assertEquals(5, planes.length);
		
	}
	
	@Test
	public void unmarshall_json_to_object_with_jackson () throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		Plane plane = objectMapper.readValue(JSON_OBJECT, Plane.class);
		
		assertEquals("Sea Planes", plane.getPlaneType());
	}

	
	@Test
	public void unmarshall_json_to_list_with_jackson () throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Plane> planes = objectMapper.readValue(ARRAY_AS_JSON, 
				objectMapper.getTypeFactory().constructCollectionType(List.class, Plane.class));
		
//		[Plane{plane type: =Commercial Transport Planes}, Plane{plane type: =General Aviation Planes}, Plane{plane type: =Military Planes}, Plane{plane type: =Sea Planes}, Plane{plane type: =Special Purpose Planes}]

		assertEquals(5, planes.size());
	}

	@Test
	public void unmarshall_json_to_java_array_with_jackson () throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Plane[] planes = objectMapper.readValue(ARRAY_AS_JSON, JsontoJavaObject.Plane[].class);
		
//		[Plane{plane type: =Commercial Transport Planes}, Plane{plane type: =General Aviation Planes}, Plane{plane type: =Military Planes}, Plane{plane type: =Sea Planes}, Plane{plane type: =Special Purpose Planes}]

		assertEquals(5, planes.length);
	}
	
	
}
