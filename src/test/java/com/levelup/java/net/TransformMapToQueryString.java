package com.levelup.java.net;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Joiner;

/**
 * This java example will demonstrate how to convert a map to a query string
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/build-convert-map-to-query-string/'>Convert map to query string</a>
 */
public class TransformMapToQueryString {

	Map<String, String> mapToConvert;

	@Before
	public void setup() {

		mapToConvert = new HashMap<String, String>();
		mapToConvert.put("end-date", "2014-11-26");
		mapToConvert.put("itemsPerPage", String.valueOf(25));
	}

	@Test
	public void construct_uri_jersey () {
		          
		UriBuilder builder = UriBuilder
				.fromPath("www.leveluplunch.com")
				.scheme("http");
		
		for (Entry<String, String> entry : mapToConvert.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		
		URI uri = builder.build();
		
		assertEquals(
				"http:/www.leveluplunch.com?end-date=2014-11-26&itemsPerPage=25",
				uri.toString());
	}
	
	@Test
	public void convert_map_to_querystring_guava() {

		String mapJoined = Joiner.on("&").withKeyValueSeparator("=")
				.join(mapToConvert);

		assertEquals("end-date=2014-11-26&itemsPerPage=25", mapJoined);
	}

	@Test
	public void convert_map_to_uri_spring() {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		for (Entry<String, String> entry : mapToConvert.entrySet()) {
			params.add(entry.getKey(), entry.getValue());
		}

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("http").host("www.leveluplunch.com")
				.queryParams(params).build();

		assertEquals(
				"http://www.leveluplunch.com?end-date=2014-11-26&itemsPerPage=25",
				uriComponents.toUriString());
	}
	
	@Test
	public void contruct_uri_parameters_apache () throws URISyntaxException {
		
		List<NameValuePair> queryParams = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : mapToConvert.entrySet()) {
			queryParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
	      
		URIBuilder builder = new URIBuilder()
				.setScheme("http")
				.setHost("www.leveluplunch.com")
				.setParameters(queryParams);
		
		URI uri = builder.build();
		
		assertEquals(
				"http://www.leveluplunch.com?end-date=2014-11-26&itemsPerPage=25", 
				uri.toString());
	}

}
