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
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-xml-to-from-hashmap-object-xstream/'>Conver
 *      t xml to hashmap using xstream</a>
 */
public class XMLToMapXstream {

	private static final Logger logger = Logger
			.getLogger(XMLToMapXstream.class);

	public class Restaurant {

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
		Restaurant resturant3 = new Restaurant(3, "ColdSpring Inn",
				"Cold Spring");

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

		String xmlAsMap = "<map>\n <entry>\n <int>1</int>\n <com.levelup.java.xml.XMLToMapXstream_-Restaurant>\n <id>1</id>\n <name>Woodlawn super club</name>\n <address>Fort Atkinson</address>\n <outer-class>\n <restaurantByKey reference=\"../../../..\"/>\n </outer-class>\n </com.levelup.java.xml.XMLToMapXstream_-Restaurant>\n </entry>\n <entry>\n <int>2</int>\n <com.levelup.java.xml.XMLToMapXstream_-Restaurant>\n <id>2</id>\n <name>Sammy&apos;s</name>\n <address>Fort Atkinson</address>\n <outer-class reference=\"../../../entry/com.levelup.java.xml.XMLToMapXstream_-Restaurant/outer-class\"/>\n </com.levelup.java.xml.XMLToMapXstream_-Restaurant>\n </entry>\n <entry>\n <int>3</int>\n <com.levelup.java.xml.XMLToMapXstream_-Restaurant>\n <id>3</id>\n <name>ColdSpring Inn</name>\n <address>Cold Spring</address>\n <outer-class reference=\"../../../entry/com.levelup.java.xml.XMLToMapXstream_-Restaurant/outer-class\"/>\n </com.levelup.java.xml.XMLToMapXstream_-Restaurant>\n </entry>\n</map>\n";

		XStream xStream = new XStream();
		xStream.alias("map", java.util.Map.class);

		@SuppressWarnings("unchecked")
		Map<Integer, Restaurant> resturantConverted = (Map<Integer, Restaurant>) xStream
				.fromXML(xmlAsMap);

		assertThat(resturantConverted, hasKey(new Integer("1")));

	}

}
