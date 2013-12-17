package com.levelup.java.beans;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.junit.Assert.assertThat;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This java example will demonstrate converting a java
 * bean or POJO to a map of the properties.  The key will represent
 * the field name and map value represents the value of the field.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-object-bean-properties-map-key-value/'>Convert object to map</a>
 */
public class ConvertBeanToMap {

	public class NoteBook {
		
		private double numberOfSheets;
		private String description;

		public NoteBook(double numberOfSheets, String description) {
			super();
			this.numberOfSheets = numberOfSheets;
			this.description = description;
		}
		
		public double getNumberOfSheets() {
			return numberOfSheets;
		}
		public String getDescription() {
			return description;
		}
		
	}
	
	@Test
	public void convert_object_to_map_java() throws IntrospectionException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {

		NoteBook actionMethodNoteBook = new NoteBook(100, "Action Method Notebook");

		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		BeanInfo info = Introspector.getBeanInfo(actionMethodNoteBook.getClass());
		for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
			Method reader = pd.getReadMethod();
			if (reader != null)
				objectAsMap.put(pd.getName(),reader.invoke(actionMethodNoteBook));
		}

		assertThat(objectAsMap, hasEntry("numberOfSheets", (Object) new Double(100.0)));
		assertThat(objectAsMap, hasEntry("description", (Object) "Action Method Notebook"));
	}
	

	@Test
	public void convert_object_to_map_apache_commons () throws IllegalAccessException, 
		InvocationTargetException, NoSuchMethodException {
		
		NoteBook fieldNoteBook = new NoteBook(878, "Field Notebook");

		@SuppressWarnings("unchecked")
		Map<String, Object> objectAsMap = BeanUtils.describe(fieldNoteBook);
		
		assertThat(objectAsMap, hasEntry("numberOfSheets", (Object) "878.0"));
		assertThat(objectAsMap, hasEntry("description", (Object)  "Field Notebook"));
	}
	
	@Test
	public void convert_object_to_map_jackson () {
		
		NoteBook moleskineNoteBook = new NoteBook(200, "Moleskine Notebooks");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		@SuppressWarnings("unchecked")
		Map<String, Object> objectAsMap = objectMapper.convertValue(moleskineNoteBook, Map.class);
		
		assertThat(objectAsMap, hasEntry("numberOfSheets", (Object) new Double(200.0)));
		assertThat(objectAsMap, hasEntry("description", (Object) "Moleskine Notebooks"));
	}
	
}
