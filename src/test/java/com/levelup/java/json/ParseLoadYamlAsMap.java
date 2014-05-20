package com.levelup.java.json;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

/**
 * This java example will demonstrate how to
 * load a yaml document into a {@link HashMap}.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/parse-load-yaml-as-hashmap/'>Load Yaml as Map</a>
 */
public class ParseLoadYamlAsMap {

	@Test
	public void load_yml_as_map_snake() {

		String yamlAsString = "{JYaml: Original Java Implementation, "
				+ "JvYaml: Java port of RbYaml, SnakeYAML: Java 5 / YAML 1.1, "
				+ "YamlBeans: To/from JavaBeans}";

		Yaml yaml = new Yaml();

		@SuppressWarnings("unchecked")
		Map<String, String> yamlParsers = (Map<String, String>) yaml
				.load(yamlAsString);

		assertThat(yamlParsers.keySet(),
				hasItems("JYaml", "JvYaml", "YamlBeans", "SnakeYAML"));
	}
}
