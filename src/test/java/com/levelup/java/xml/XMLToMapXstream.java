package com.levelup.java.xml;

import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;

/**
 * This java example will demonstrate converting xml to map with xstream.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-xml-to-from-hashmap-object-xstream/'>Convert xml to hashmap using xstream</a>
 */
public class XMLToMapXstream {

	private static final Logger logger = Logger
			.getLogger(XMLToMapXstream.class);

	class Restaurant {

		private Integer id;
		private String name;
		private String address;

		public Restaurant(Integer id, String name, String address) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
		}

		public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getAddress() {
			return address;
		}
	}

	Map<Integer, Restaurant> restaurantByKey;

	@Before
	public void setUp() {

		Restaurant resturant = new Restaurant(1, "Woodlawn super club",
				"Fort Atkinson");
		Restaurant resturant2 = new Restaurant(2, "Sammy's", "Fort Atkinson");
		Restaurant resturant3 = new Restaurant(3, "ColdSpring Inn", "Cold Spring");

		restaurantByKey = Maps.newHashMap();
		restaurantByKey.put(1, resturant);
		restaurantByKey.put(2, resturant2);
		restaurantByKey.put(3, resturant3);
	}

	@Test
	public void serialize_map_to_xml() {

		XStream xStream = new XStream();
		xStream.alias("map", java.util.Map.class);

		String xml = xStream.toXML(restaurantByKey);

		logger.info(xml);

		assertNotNull(xml);
	}

	@Test
	public void deserialize_xml_to_hashmap() {

		String xmlAsMap = "<map> <entry> <int>1</int> <com.levelup.java.xml.XMLToMapXstream_-Resturant> <id>1</id> <name>Woodlawn super club</name> <address>Fort Atkinson</address> <outer-class> <resturantByKey reference=\"../../../..\"/> </outer-class> </com.levelup.java.xml.XMLToMapXstream_-Resturant> </entry> <entry> <int>2</int> <com.levelup.java.xml.XMLToMapXstream_-Resturant> <id>2</id> <name>Sammy&apos;s</name> <address>Fort Atkinson</address> <outer-class reference=\"../../../entry/com.levelup.java.xml.XMLToMapXstream_-Resturant/outer-class\"/> </com.levelup.java.xml.XMLToMapXstream_-Resturant> </entry> <entry> <int>3</int> <com.levelup.java.xml.XMLToMapXstream_-Resturant> <id>2</id> <name>ColdSpring Inn</name> <address>Cold Spring</address> <outer-class reference=\"../../../entry/com.levelup.java.xml.XMLToMapXstream_-Resturant/outer-class\"/> </com.levelup.java.xml.XMLToMapXstream_-Resturant> </entry> </map>";

		XStream xStream = new XStream();
		xStream.alias("map", java.util.Map.class);

		@SuppressWarnings("unchecked")
		Map<Integer, Restaurant> resturantConverted = (Map<Integer, Restaurant>) xStream
				.fromXML(xmlAsMap);

		assertThat(resturantConverted, hasKey(new Integer("1")));

	}

}
