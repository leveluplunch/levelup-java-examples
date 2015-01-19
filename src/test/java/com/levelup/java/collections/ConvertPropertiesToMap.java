package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Maps;

/**
 * This java example will demonstrate converting properties to Map<String,
 * String>
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-properties-to-map/'>Conver
 *      t properties to map</a>
 * 
 */
public class ConvertPropertiesToMap {

	private static final Logger logger = Logger
			.getLogger(ConvertPropertiesToMap.class);

	@Test
	public void create_map_from_properties() {

		Properties properties = new Properties();
		properties.put("database.username", "yourname");
		properties.put("database.password", "encrypted_password");
		properties.put("database.driver", "com.mysql.jdbc.Driver");
		properties.put("database.url",
				"jdbc:mysql://localhost:3306/sakila?profileSQL=true");

		@SuppressWarnings({ "unchecked", "rawtypes" })
		Map<String, String> mapOfProperties = new HashMap(properties);

		assertThat(
				mapOfProperties.keySet(),
				containsInAnyOrder("database.username", "database.password",
						"database.driver", "database.url"));
	}

	@Test
	public void create_map_from_properties_java() {

		Properties properties = new Properties();
		properties.put("database.username", "yourname");
		properties.put("database.password", "encrypted_password");
		properties.put("database.driver", "com.mysql.jdbc.Driver");
		properties.put("database.url",
				"jdbc:mysql://localhost:3306/sakila?profileSQL=true");

		Map<String, String> mapOfProperties = new HashMap<String, String>();

		Enumeration<?> propertyNames = properties.propertyNames();

		while (propertyNames.hasMoreElements()) {
			String key = (String) propertyNames.nextElement();
			mapOfProperties.put(key, properties.getProperty(key));
		}

		logger.info(mapOfProperties);

		assertThat(
				mapOfProperties.keySet(),
				containsInAnyOrder("database.username", "database.password",
						"database.driver", "database.url"));
	}

	@Test
	public void create_map_from_properties_java8() {

		Properties properties = new Properties();
		properties.put("database.username", "yourname");
		properties.put("database.password", "encrypted_password");
		properties.put("database.driver", "com.mysql.jdbc.Driver");
		properties.put("database.url",
				"jdbc:mysql://localhost:3306/sakila?profileSQL=true");

		Stream<Entry<Object, Object>> stream = properties.entrySet().stream();
		Map<String, String> mapOfProperties = stream.collect(Collectors.toMap(
				e -> String.valueOf(e.getKey()),
				e -> String.valueOf(e.getValue())));

		assertThat(
				mapOfProperties.keySet(),
				containsInAnyOrder("database.username", "database.password",
						"database.driver", "database.url"));
	}

	@Test
	public void create_map_from_properties_guava() {

		Properties properties = new Properties();
		properties.put("database.username", "yourname");
		properties.put("database.password", "encrypted_password");
		properties.put("database.driver", "com.mysql.jdbc.Driver");
		properties.put("database.url",
				"jdbc:mysql://localhost:3306/sakila?profileSQL=true");

		Map<String, String> mapOfProperties = Maps.fromProperties(properties);

		logger.info(mapOfProperties);

		assertThat(
				mapOfProperties.keySet(),
				containsInAnyOrder("database.username", "database.password",
						"database.driver", "database.url"));
	}

}
