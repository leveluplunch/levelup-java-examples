package com.levelup.java.json;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This java example will demonstrate how to 
 * pretty print json in java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/pretty-print-json/'>Pretty print json</a>
 * 
 */
public class PrettyPrintJson {

	private static final Logger logger = Logger.getLogger(PrettyPrintJson.class);

	class GitHubMember { 
		
		private String login;
		private String id;
		private String avatar_url;
		private String gravatar_id;
		private String url;
		
		public GitHubMember(String login, String id, String avatar_url,
				String gravatar_id, String url) {
			super();
			this.login = login;
			this.id = id;
			this.avatar_url = avatar_url;
			this.gravatar_id = gravatar_id;
			this.url = url;
		}

		public String getLogin() {
			return login;
		}

		public String getId() {
			return id;
		}

		public String getAvatar_url() {
			return avatar_url;
		}

		public String getGravatar_id() {
			return gravatar_id;
		}

		public String getUrl() {
			return url;
		}
	}
	
	@Test
	public void pretty_print_json_gson() {

		String GITHUB_MEMBER_JSON = "[\n  {\n    \"login\": \"octocat\",\n    \"id\": \"1\",\n    "
				+ "\"avatar_url\": \"https://github.com/images/error/octocat_happy.gif\",\n    "
				+ "\"gravatar_id\": \"somehexcode\",\n    \"url\": "
				+ "\"https://api.github.com/users/octocat\"\n  }\n]";

		List<GitHubMember> members = Lists.newArrayList(new GitHubMember(
				"octocat", "1",
				"https://github.com/images/error/octocat_happy.gif",
				"somehexcode", "https://api.github.com/users/octocat"));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		String prettyJson = gson.toJson(members);

		logger.info(prettyJson);

		assertEquals(GITHUB_MEMBER_JSON, prettyJson);
	}

	@Test
	public void pretty_print_json_jackson() throws IOException {

		String GITHUB_MEMBER_JSON = "[ {\n  \"login\" : \"octocat\",\n  \"id\" : "
				+ "\"1\",\n  \"avatar_url\" : \"https://github.com/images/error/octocat_happy.gif\","
				+ "\n  \"gravatar_id\" : \"somehexcode\",\n  \"url\" : "
				+ "\"https://api.github.com/users/octocat\"\n} ]";

		List<GitHubMember> members = Lists.newArrayList(new GitHubMember(
				"octocat", "1",
				"https://github.com/images/error/octocat_happy.gif",
				"somehexcode", "https://api.github.com/users/octocat"));

		ObjectMapper objectMapper = new ObjectMapper();
		ObjectWriter writer = objectMapper.writer().with(
				SerializationFeature.INDENT_OUTPUT);

		String prettyJson = writer.writeValueAsString(members);

		logger.info(prettyJson);

		assertEquals(GITHUB_MEMBER_JSON, prettyJson);
	}

	
}
