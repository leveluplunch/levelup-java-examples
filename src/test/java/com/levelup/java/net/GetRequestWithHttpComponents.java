package com.levelup.java.net;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * This java example will demonstrate how to make a request with apache commons.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/execute-get-request-apache-http-components/'>Execute get request with Apache Components</a>
 */
public class GetRequestWithHttpComponents {

	@Test
	public void make_request_http_client() throws ClientProtocolException,
			IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(
				"https://data.sparkfun.com/streams/dZ4EVmE8yGCRGx5XRX1W.json");
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			HttpEntity entity = response.getEntity();

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				String responseValue = EntityUtils.toString(entity);
				System.out.println(responseValue);
			} else {
				// log error
			}
		} finally {
			response.close();
		}
	}

}
