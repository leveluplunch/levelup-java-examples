package com.levelup.java.jsonpath;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

/**
 * This java example will demonstrate extracting elements
 * from a json object using JSONPath
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/parse-elements-json-jsonpath'>Parse elements from JSON object</a>
 * 
 */
public class JsonPathExample {

//	Similiar to XPATH, JSONPath allows you to parse element
//	https://code.google.com/p/json-path/
//	http://goessner.net/articles/JsonPath/
//	show json path
// go through examples identified 
	
	private static final Logger logger = Logger.getLogger(JsonPathExample.class);

	private String githubIssues = "[ \r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/30\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/30/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/30/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/30/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/issues/30\",\r\n    \"id\": 18687132,\r\n    \"number\": 30,\r\n    \"title\": \"Use a generic origin (not the S3 origin) when creating CloudFront dist\",\r\n    \"user\": {\r\n      \"login\": \"laurilehmijoki\",\r\n      \"id\": 864166,\r\n      \"avatar_url\": \"https://2.gravatar.com/avatar/4ffa0818a97d3dac407136330bb6cfca?d=https%3A%2F%2Fidenticons.github.com%2Fd7071c86e756da81ad04b9cf78377d43.png\",\r\n      \"gravatar_id\": \"4ffa0818a97d3dac407136330bb6cfca\",\r\n      \"url\": \"https://api.github.com/users/laurilehmijoki\",\r\n      \"html_url\": \"https://github.com/laurilehmijoki\",\r\n      \"followers_url\": \"https://api.github.com/users/laurilehmijoki/followers\",\r\n      \"following_url\": \"https://api.github.com/users/laurilehmijoki/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/laurilehmijoki/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/laurilehmijoki/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/laurilehmijoki/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/laurilehmijoki/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/laurilehmijoki/repos\",\r\n      \"events_url\": \"https://api.github.com/users/laurilehmijoki/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/laurilehmijoki/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n      {\r\n        \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement\",\r\n        \"name\": \"enhancement\",\r\n        \"color\": \"84b6eb\"\r\n      }\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 0,\r\n    \"created_at\": \"2013-08-28T18:37:47Z\",\r\n    \"updated_at\": \"2013-09-20T15:48:20Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": null,\r\n      \"diff_url\": null,\r\n      \"patch_url\": null\r\n    },\r\n    \"body\": \"### Problem\\r\\n\\r\\nWhen the `s3_website cfg apply` creates a CloudFront distribution, it marks the origin as an S3 origin. While it is true that in our case the origin is always an S3 bucket, this causes a problem that @bakura10 describes in https://github.com/laurilehmijoki/s3_website/issues/29#issuecomment-23340073.\\r\\n\\r\\n### Solution\\r\\n\\r\\nModify the `s3_website cfg apply` such that it creates the distribution with a generic origin.\\r\\n\\r\\n### Benefit\\r\\n\\r\\nNew users benefit from this feature, because they will be able to invalidate CloudFront resources like `/article/`. \\r\\n\\r\\nI.e., without this feature, they have to stick to URLs like `http://mysite.com/article/index.html`.\"\r\n  },\r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/24\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/24/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/24/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/24/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/issues/24\",\r\n    \"id\": 17788879,\r\n    \"number\": 24,\r\n    \"title\": \"Ignore Folders\",\r\n    \"user\": {\r\n      \"login\": \"Romiko\",\r\n      \"id\": 579058,\r\n      \"avatar_url\": \"https://1.gravatar.com/avatar/906891c444d617b9d8a0dfdbd2bb72b3?d=https%3A%2F%2Fidenticons.github.com%2F7fa8247becbcbcdd95ce270ba9fa79f0.png\",\r\n      \"gravatar_id\": \"906891c444d617b9d8a0dfdbd2bb72b3\",\r\n      \"url\": \"https://api.github.com/users/Romiko\",\r\n      \"html_url\": \"https://github.com/Romiko\",\r\n      \"followers_url\": \"https://api.github.com/users/Romiko/followers\",\r\n      \"following_url\": \"https://api.github.com/users/Romiko/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/Romiko/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/Romiko/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/Romiko/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/Romiko/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/Romiko/repos\",\r\n      \"events_url\": \"https://api.github.com/users/Romiko/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/Romiko/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n      {\r\n        \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement\",\r\n        \"name\": \"enhancement\",\r\n        \"color\": \"84b6eb\"\r\n      }\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 1,\r\n    \"created_at\": \"2013-08-08T05:03:19Z\",\r\n    \"updated_at\": \"2013-09-20T15:47:10Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": null,\r\n      \"diff_url\": null,\r\n      \"patch_url\": null\r\n    },\r\n    \"body\": \"Hi,\\r\\n\\r\\nI use the draft feature in Jekyll, however, the push is also pushing draft content, which is not required. Is it possible to add folder filtering?\\r\\n\\r\\ne.g. \\r\\nignore_folders:\\r\\n \\\"rafts\\\"\"\r\n  },\r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/21\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/21/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/21/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/21/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/issues/21\",\r\n    \"id\": 17377538,\r\n    \"number\": 21,\r\n    \"title\": \"Performance: replace the AWS SDK gem with EventMachine\",\r\n    \"user\": {\r\n      \"login\": \"laurilehmijoki\",\r\n      \"id\": 864166,\r\n      \"avatar_url\": \"https://2.gravatar.com/avatar/4ffa0818a97d3dac407136330bb6cfca?d=https%3A%2F%2Fidenticons.github.com%2Fd7071c86e756da81ad04b9cf78377d43.png\",\r\n      \"gravatar_id\": \"4ffa0818a97d3dac407136330bb6cfca\",\r\n      \"url\": \"https://api.github.com/users/laurilehmijoki\",\r\n      \"html_url\": \"https://github.com/laurilehmijoki\",\r\n      \"followers_url\": \"https://api.github.com/users/laurilehmijoki/followers\",\r\n      \"following_url\": \"https://api.github.com/users/laurilehmijoki/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/laurilehmijoki/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/laurilehmijoki/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/laurilehmijoki/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/laurilehmijoki/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/laurilehmijoki/repos\",\r\n      \"events_url\": \"https://api.github.com/users/laurilehmijoki/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/laurilehmijoki/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n      {\r\n        \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement\",\r\n        \"name\": \"enhancement\",\r\n        \"color\": \"84b6eb\"\r\n      }\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 0,\r\n    \"created_at\": \"2013-07-30T05:08:03Z\",\r\n    \"updated_at\": \"2013-09-20T15:47:22Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": null,\r\n      \"diff_url\": null,\r\n      \"patch_url\": null\r\n    },\r\n    \"body\": \"At the moment `s3_website` invokes the AWS SDK gem's upload API in parallel, within `Thread.new`. Obviously, this is considerably faster than performing the uploads sequentially. \\r\\n\\r\\nI assume that most `s3_website` users are using an RMI Ruby. As far as I know, the thread schedulers in RMI Rubies are not optimally fair to our use case of making parallel HTTP connections. As a result, I suggest that we try replacing the usage AWS SDK with <http://rubyeventmachine.com>. It should be able to speed up the HTTP operations of `s3_website`.\\r\\n\\r\\nThere is, however, one significant hindrance to adopting EventMachine: the Cucumber+VCR integration tests. I don't yet know how to transform them into the evented world. **Does anyone have ideas on how to solve this problem?** More specifically: how to test evented HTTP requests against fixture data?\"\r\n  },\r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/20\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/20/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/20/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/20/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/issues/20\",\r\n    \"id\": 17276276,\r\n    \"number\": 20,\r\n    \"title\": \"Reduce GET Bucket (List Objects) operations from 2 to 1\",\r\n    \"user\": {\r\n      \"login\": \"laurilehmijoki\",\r\n      \"id\": 864166,\r\n      \"avatar_url\": \"https://2.gravatar.com/avatar/4ffa0818a97d3dac407136330bb6cfca?d=https%3A%2F%2Fidenticons.github.com%2Fd7071c86e756da81ad04b9cf78377d43.png\",\r\n      \"gravatar_id\": \"4ffa0818a97d3dac407136330bb6cfca\",\r\n      \"url\": \"https://api.github.com/users/laurilehmijoki\",\r\n      \"html_url\": \"https://github.com/laurilehmijoki\",\r\n      \"followers_url\": \"https://api.github.com/users/laurilehmijoki/followers\",\r\n      \"following_url\": \"https://api.github.com/users/laurilehmijoki/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/laurilehmijoki/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/laurilehmijoki/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/laurilehmijoki/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/laurilehmijoki/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/laurilehmijoki/repos\",\r\n      \"events_url\": \"https://api.github.com/users/laurilehmijoki/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/laurilehmijoki/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n      {\r\n        \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement\",\r\n        \"name\": \"enhancement\",\r\n        \"color\": \"84b6eb\"\r\n      }\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 0,\r\n    \"created_at\": \"2013-07-26T18:08:01Z\",\r\n    \"updated_at\": \"2013-07-26T18:08:01Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": null,\r\n      \"diff_url\": null,\r\n      \"patch_url\": null\r\n    },\r\n    \"body\": \"At the moment `s3_website push` does two [GET Bucket](http://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketGET.html) operations:\\r\\n\\r\\n1. in the [filey-diff](https://github.com/laurilehmijoki/filey-diff/blob/master/lib/filey-diff/data-sources/aws_sdk_s3.rb#L23) gem, when calculating diff\\r\\n2. in [uploader.rb](https://github.com/laurilehmijoki/s3_website/blob/master/lib/s3_website/uploader.rb#L108) when determining files-to-remove-from-s3\\r\\n\\r\\nOne of two requests is unnecessary. Remove either of them.\"\r\n  },\r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/17\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/17/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/17/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/17/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/issues/17\",\r\n    \"id\": 17015371,\r\n    \"number\": 17,\r\n    \"title\": \"Set \\\"no-cache\\\" to Cache-Control header when max_age=0\",\r\n    \"user\": {\r\n      \"login\": \"bkaid\",\r\n      \"id\": 315615,\r\n      \"avatar_url\": \"https://2.gravatar.com/avatar/3e6fec2fd77de59951f89112acd6953b?d=https%3A%2F%2Fidenticons.github.com%2Ff7e6dbcbc550339e9dce5e4b13ccc49e.png\",\r\n      \"gravatar_id\": \"3e6fec2fd77de59951f89112acd6953b\",\r\n      \"url\": \"https://api.github.com/users/bkaid\",\r\n      \"html_url\": \"https://github.com/bkaid\",\r\n      \"followers_url\": \"https://api.github.com/users/bkaid/followers\",\r\n      \"following_url\": \"https://api.github.com/users/bkaid/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/bkaid/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/bkaid/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/bkaid/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/bkaid/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/bkaid/repos\",\r\n      \"events_url\": \"https://api.github.com/users/bkaid/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/bkaid/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n      {\r\n        \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement\",\r\n        \"name\": \"enhancement\",\r\n        \"color\": \"84b6eb\"\r\n      }\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 1,\r\n    \"created_at\": \"2013-07-21T06:03:26Z\",\r\n    \"updated_at\": \"2013-09-20T15:48:33Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": null,\r\n      \"diff_url\": null,\r\n      \"patch_url\": null\r\n    },\r\n    \"body\": \"On certain files I want to disable caching by setting this header: \\\"Cache-Control: no-cache, max-age=0\\\".  If I set max_age to 0, I only get \\\"Cache-Control: max-age=0\\\".  Would be great if when max_age is 0, then no-cache is added as well.\"\r\n  },\r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/16\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/16/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/16/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/16/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/issues/16\",\r\n    \"id\": 17015052,\r\n    \"number\": 16,\r\n    \"title\": \"Changing config settings returns \\\"No new or changed files to upload\\\"\",\r\n    \"user\": {\r\n      \"login\": \"bkaid\",\r\n      \"id\": 315615,\r\n      \"avatar_url\": \"https://2.gravatar.com/avatar/3e6fec2fd77de59951f89112acd6953b?d=https%3A%2F%2Fidenticons.github.com%2Ff7e6dbcbc550339e9dce5e4b13ccc49e.png\",\r\n      \"gravatar_id\": \"3e6fec2fd77de59951f89112acd6953b\",\r\n      \"url\": \"https://api.github.com/users/bkaid\",\r\n      \"html_url\": \"https://github.com/bkaid\",\r\n      \"followers_url\": \"https://api.github.com/users/bkaid/followers\",\r\n      \"following_url\": \"https://api.github.com/users/bkaid/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/bkaid/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/bkaid/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/bkaid/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/bkaid/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/bkaid/repos\",\r\n      \"events_url\": \"https://api.github.com/users/bkaid/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/bkaid/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n      {\r\n        \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement\",\r\n        \"name\": \"enhancement\",\r\n        \"color\": \"84b6eb\"\r\n      }\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 1,\r\n    \"created_at\": \"2013-07-21T05:08:10Z\",\r\n    \"updated_at\": \"2013-09-20T15:48:54Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": null,\r\n      \"diff_url\": null,\r\n      \"patch_url\": null\r\n    },\r\n    \"body\": \"If I deploy my site and then change options, such as max_age or gzip extensions, I can't re-deploy the site with the new settings without getting \\\"No new or changed files to upload.\\\"  Maybe a ```s3_website push --force``` option would help.\"\r\n  },\r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/5\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/5/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/5/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/5/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/issues/5\",\r\n    \"id\": 16286782,\r\n    \"number\": 5,\r\n    \"title\": \"Cloudfront invalidation fails\",\r\n    \"user\": {\r\n      \"login\": \"sud0n1m\",\r\n      \"id\": 137983,\r\n      \"avatar_url\": \"https://1.gravatar.com/avatar/ca1fb1457515fe98bf1609ee150ad2a5?d=https%3A%2F%2Fidenticons.github.com%2F19fa4b139577ab5554b841cf350d14ab.png\",\r\n      \"gravatar_id\": \"ca1fb1457515fe98bf1609ee150ad2a5\",\r\n      \"url\": \"https://api.github.com/users/sud0n1m\",\r\n      \"html_url\": \"https://github.com/sud0n1m\",\r\n      \"followers_url\": \"https://api.github.com/users/sud0n1m/followers\",\r\n      \"following_url\": \"https://api.github.com/users/sud0n1m/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/sud0n1m/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/sud0n1m/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/sud0n1m/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/sud0n1m/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/sud0n1m/repos\",\r\n      \"events_url\": \"https://api.github.com/users/sud0n1m/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/sud0n1m/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n      {\r\n        \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/labels/bug\",\r\n        \"name\": \"bug\",\r\n        \"color\": \"fc2929\"\r\n      }\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 3,\r\n    \"created_at\": \"2013-07-02T20:48:16Z\",\r\n    \"updated_at\": \"2013-09-20T15:51:58Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": null,\r\n      \"diff_url\": null,\r\n      \"patch_url\": null\r\n    },\r\n    \"body\": \"Cloudfront invalidation seems to fail with the following error:\\r\\n\\r\\n    /Users/sudonim/.rbenv/versions/1.9.3-p194-perf/lib/ruby/gems/1.9.1/gems/simple-cloudfront-invalidator-1.0.0/lib/simple-cloudfront-invalidator.rb:57:in `sign_and_call': AWS API call failed. Reason: (RuntimeError)`\\r\\n\\r\\nThe full response is in this Gist:\\r\\nhttps://gist.github.com/sud0n1m/aceecb10f0e48cfd435a\\r\\n\\r\\nIt seems to suggest that I'm sending a malformed response. Is that so?\"\r\n  },\r\n  {\r\n    \"url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/4\",\r\n    \"labels_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/4/labels{/name}\",\r\n    \"comments_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/4/comments\",\r\n    \"events_url\": \"https://api.github.com/repos/laurilehmijoki/s3_website/issues/4/events\",\r\n    \"html_url\": \"https://github.com/laurilehmijoki/s3_website/pull/4\",\r\n    \"id\": 16211616,\r\n    \"number\": 4,\r\n    \"title\": \"Added support for symlinked directories.\",\r\n    \"user\": {\r\n      \"login\": \"watbe\",\r\n      \"id\": 1361632,\r\n      \"avatar_url\": \"https://2.gravatar.com/avatar/10a424322bb680c9f1e804331e8bfe44?d=https%3A%2F%2Fidenticons.github.com%2Feee4ba85029a14aef091acb07504e0a3.png\",\r\n      \"gravatar_id\": \"10a424322bb680c9f1e804331e8bfe44\",\r\n      \"url\": \"https://api.github.com/users/watbe\",\r\n      \"html_url\": \"https://github.com/watbe\",\r\n      \"followers_url\": \"https://api.github.com/users/watbe/followers\",\r\n      \"following_url\": \"https://api.github.com/users/watbe/following{/other_user}\",\r\n      \"gists_url\": \"https://api.github.com/users/watbe/gists{/gist_id}\",\r\n      \"starred_url\": \"https://api.github.com/users/watbe/starred{/owner}{/repo}\",\r\n      \"subscriptions_url\": \"https://api.github.com/users/watbe/subscriptions\",\r\n      \"organizations_url\": \"https://api.github.com/users/watbe/orgs\",\r\n      \"repos_url\": \"https://api.github.com/users/watbe/repos\",\r\n      \"events_url\": \"https://api.github.com/users/watbe/events{/privacy}\",\r\n      \"received_events_url\": \"https://api.github.com/users/watbe/received_events\",\r\n      \"type\": \"User\"\r\n    },\r\n    \"labels\": [\r\n\r\n    ],\r\n    \"state\": \"open\",\r\n    \"assignee\": null,\r\n    \"milestone\": null,\r\n    \"comments\": 1,\r\n    \"created_at\": \"2013-07-01T12:26:14Z\",\r\n    \"updated_at\": \"2013-07-05T02:41:09Z\",\r\n    \"closed_at\": null,\r\n    \"pull_request\": {\r\n      \"html_url\": \"https://github.com/laurilehmijoki/s3_website/pull/4\",\r\n      \"diff_url\": \"https://github.com/laurilehmijoki/s3_website/pull/4.diff\",\r\n      \"patch_url\": \"https://github.com/laurilehmijoki/s3_website/pull/4.patch\"\r\n    },\r\n    \"body\": \"In relation to this issue: https://github.com/laurilehmijoki/s3_website/issues/3 \\r\\n\\r\\nI've pushed a fix in filey-diff (https://github.com/laurilehmijoki/filey-diff/pull/5) and also added this small change to fix the issue. Symlinks should now be followed to one depth (to prevent recursive links). \\r\\n\\r\\nI might have missed out other directory traversals. I am also not familiar with ruby so you might want to review it.\"\r\n  }\r\n]\r\n";

	/**
	 * Get all issues ids
	 */
	@Test
	public void all_issues_ids () {
		
		List<String> issueIds = JsonPath.read(githubIssues, "$.[*].id");

		logger.info(issueIds);
		
		assertEquals(8, issueIds.size());
	}

	
	/**
	 * First issue title
	 */
	@Test
	public void first_issue_title () {
		
		String firstIssuesTitle = JsonPath.read(githubIssues, "$.[0].title");
		
		logger.info(firstIssuesTitle);
		
		assertEquals("Use a generic origin (not the S3 origin) when creating CloudFront dist", firstIssuesTitle);
	}
	
	/**
	 * All issues by author 
	 */
	@Test
	public void issues_authored_by () {
		
		List<Object> issuesByAuthor = JsonPath.read(githubIssues, "$.[*].user[?(@.login == 'laurilehmijoki')]");
		
		logger.info(issuesByAuthor);

		assertEquals(3, issuesByAuthor.size());
	}
	
	/**
	 * All issues labeled as 'bug' 
	 */
	@Test
	public void issues_labeled_as_bug () {
		
		List<Object> bugs = JsonPath.read(githubIssues, "$..labels[?(@.name==bug)]"); // OR filter(where("name").is("bug")));
		
		logger.info(bugs);

		assertEquals(1, bugs.size());

	}
	
	/**
	 * Issues that are open and have a number >= 30
	 */
	@Test
	public void issues_by_state_and_number () {
		
		Filter<?> filter = Filter.filter(Criteria.where("state").is("open").and("number").gte(30));

		List<Object> issuesByLabelAndAuthor = JsonPath.read(githubIssues, "$.[?]", filter);
		
		logger.info(issuesByLabelAndAuthor);

		assertEquals(1, issuesByLabelAndAuthor.size());
	}

// A readable format
	
//	[ 
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/30",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/30/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/30/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/30/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/issues/30",
//	    "id": 18687132,
//	    "number": 30,
//	    "title": "Use a generic origin (not the S3 origin) when creating CloudFront dist",
//	    "user": {
//	      "login": "laurilehmijoki",
//	      "id": 864166,
//	      "avatar_url": "https://2.gravatar.com/avatar/4ffa0818a97d3dac407136330bb6cfca?d=https%3A%2F%2Fidenticons.github.com%2Fd7071c86e756da81ad04b9cf78377d43.png",
//	      "gravatar_id": "4ffa0818a97d3dac407136330bb6cfca",
//	      "url": "https://api.github.com/users/laurilehmijoki",
//	      "html_url": "https://github.com/laurilehmijoki",
//	      "followers_url": "https://api.github.com/users/laurilehmijoki/followers",
//	      "following_url": "https://api.github.com/users/laurilehmijoki/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/laurilehmijoki/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/laurilehmijoki/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/laurilehmijoki/subscriptions",
//	      "organizations_url": "https://api.github.com/users/laurilehmijoki/orgs",
//	      "repos_url": "https://api.github.com/users/laurilehmijoki/repos",
//	      "events_url": "https://api.github.com/users/laurilehmijoki/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/laurilehmijoki/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//	      {
//	        "url": "https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement",
//	        "name": "enhancement",
//	        "color": "84b6eb"
//	      }
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 0,
//	    "created_at": "2013-08-28T18:37:47Z",
//	    "updated_at": "2013-09-20T15:48:20Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": null,
//	      "diff_url": null,
//	      "patch_url": null
//	    },
//	    "body": "### Problem\r\n\r\nWhen the `s3_website cfg apply` creates a CloudFront distribution, it marks the origin as an S3 origin. While it is true that in our case the origin is always an S3 bucket, this causes a problem that @bakura10 describes in https://github.com/laurilehmijoki/s3_website/issues/29#issuecomment-23340073.\r\n\r\n### Solution\r\n\r\nModify the `s3_website cfg apply` such that it creates the distribution with a generic origin.\r\n\r\n### Benefit\r\n\r\nNew users benefit from this feature, because they will be able to invalidate CloudFront resources like `/article/`. \r\n\r\nI.e., without this feature, they have to stick to URLs like `http://mysite.com/article/index.html`."
//	  },
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/24",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/24/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/24/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/24/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/issues/24",
//	    "id": 17788879,
//	    "number": 24,
//	    "title": "Ignore Folders",
//	    "user": {
//	      "login": "Romiko",
//	      "id": 579058,
//	      "avatar_url": "https://1.gravatar.com/avatar/906891c444d617b9d8a0dfdbd2bb72b3?d=https%3A%2F%2Fidenticons.github.com%2F7fa8247becbcbcdd95ce270ba9fa79f0.png",
//	      "gravatar_id": "906891c444d617b9d8a0dfdbd2bb72b3",
//	      "url": "https://api.github.com/users/Romiko",
//	      "html_url": "https://github.com/Romiko",
//	      "followers_url": "https://api.github.com/users/Romiko/followers",
//	      "following_url": "https://api.github.com/users/Romiko/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/Romiko/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/Romiko/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/Romiko/subscriptions",
//	      "organizations_url": "https://api.github.com/users/Romiko/orgs",
//	      "repos_url": "https://api.github.com/users/Romiko/repos",
//	      "events_url": "https://api.github.com/users/Romiko/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/Romiko/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//	      {
//	        "url": "https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement",
//	        "name": "enhancement",
//	        "color": "84b6eb"
//	      }
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 1,
//	    "created_at": "2013-08-08T05:03:19Z",
//	    "updated_at": "2013-09-20T15:47:10Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": null,
//	      "diff_url": null,
//	      "patch_url": null
//	    },
//	    "body": "Hi,\r\n\r\nI use the draft feature in Jekyll, however, the push is also pushing draft content, which is not required. Is it possible to add folder filtering?\r\n\r\ne.g. \r\nignore_folders:\r\n \"rafts\""
//	  },
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/21",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/21/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/21/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/21/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/issues/21",
//	    "id": 17377538,
//	    "number": 21,
//	    "title": "Performance: replace the AWS SDK gem with EventMachine",
//	    "user": {
//	      "login": "laurilehmijoki",
//	      "id": 864166,
//	      "avatar_url": "https://2.gravatar.com/avatar/4ffa0818a97d3dac407136330bb6cfca?d=https%3A%2F%2Fidenticons.github.com%2Fd7071c86e756da81ad04b9cf78377d43.png",
//	      "gravatar_id": "4ffa0818a97d3dac407136330bb6cfca",
//	      "url": "https://api.github.com/users/laurilehmijoki",
//	      "html_url": "https://github.com/laurilehmijoki",
//	      "followers_url": "https://api.github.com/users/laurilehmijoki/followers",
//	      "following_url": "https://api.github.com/users/laurilehmijoki/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/laurilehmijoki/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/laurilehmijoki/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/laurilehmijoki/subscriptions",
//	      "organizations_url": "https://api.github.com/users/laurilehmijoki/orgs",
//	      "repos_url": "https://api.github.com/users/laurilehmijoki/repos",
//	      "events_url": "https://api.github.com/users/laurilehmijoki/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/laurilehmijoki/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//	      {
//	        "url": "https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement",
//	        "name": "enhancement",
//	        "color": "84b6eb"
//	      }
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 0,
//	    "created_at": "2013-07-30T05:08:03Z",
//	    "updated_at": "2013-09-20T15:47:22Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": null,
//	      "diff_url": null,
//	      "patch_url": null
//	    },
//	    "body": "At the moment `s3_website` invokes the AWS SDK gem's upload API in parallel, within `Thread.new`. Obviously, this is considerably faster than performing the uploads sequentially. \r\n\r\nI assume that most `s3_website` users are using an RMI Ruby. As far as I know, the thread schedulers in RMI Rubies are not optimally fair to our use case of making parallel HTTP connections. As a result, I suggest that we try replacing the usage AWS SDK with <http://rubyeventmachine.com>. It should be able to speed up the HTTP operations of `s3_website`.\r\n\r\nThere is, however, one significant hindrance to adopting EventMachine: the Cucumber+VCR integration tests. I don't yet know how to transform them into the evented world. **Does anyone have ideas on how to solve this problem?** More specifically: how to test evented HTTP requests against fixture data?"
//	  },
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/20",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/20/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/20/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/20/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/issues/20",
//	    "id": 17276276,
//	    "number": 20,
//	    "title": "Reduce GET Bucket (List Objects) operations from 2 to 1",
//	    "user": {
//	      "login": "laurilehmijoki",
//	      "id": 864166,
//	      "avatar_url": "https://2.gravatar.com/avatar/4ffa0818a97d3dac407136330bb6cfca?d=https%3A%2F%2Fidenticons.github.com%2Fd7071c86e756da81ad04b9cf78377d43.png",
//	      "gravatar_id": "4ffa0818a97d3dac407136330bb6cfca",
//	      "url": "https://api.github.com/users/laurilehmijoki",
//	      "html_url": "https://github.com/laurilehmijoki",
//	      "followers_url": "https://api.github.com/users/laurilehmijoki/followers",
//	      "following_url": "https://api.github.com/users/laurilehmijoki/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/laurilehmijoki/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/laurilehmijoki/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/laurilehmijoki/subscriptions",
//	      "organizations_url": "https://api.github.com/users/laurilehmijoki/orgs",
//	      "repos_url": "https://api.github.com/users/laurilehmijoki/repos",
//	      "events_url": "https://api.github.com/users/laurilehmijoki/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/laurilehmijoki/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//	      {
//	        "url": "https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement",
//	        "name": "enhancement",
//	        "color": "84b6eb"
//	      }
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 0,
//	    "created_at": "2013-07-26T18:08:01Z",
//	    "updated_at": "2013-07-26T18:08:01Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": null,
//	      "diff_url": null,
//	      "patch_url": null
//	    },
//	    "body": "At the moment `s3_website push` does two [GET Bucket](http://docs.aws.amazon.com/AmazonS3/latest/API/RESTBucketGET.html) operations:\r\n\r\n1. in the [filey-diff](https://github.com/laurilehmijoki/filey-diff/blob/master/lib/filey-diff/data-sources/aws_sdk_s3.rb#L23) gem, when calculating diff\r\n2. in [uploader.rb](https://github.com/laurilehmijoki/s3_website/blob/master/lib/s3_website/uploader.rb#L108) when determining files-to-remove-from-s3\r\n\r\nOne of two requests is unnecessary. Remove either of them."
//	  },
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/17",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/17/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/17/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/17/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/issues/17",
//	    "id": 17015371,
//	    "number": 17,
//	    "title": "Set \"no-cache\" to Cache-Control header when max_age=0",
//	    "user": {
//	      "login": "bkaid",
//	      "id": 315615,
//	      "avatar_url": "https://2.gravatar.com/avatar/3e6fec2fd77de59951f89112acd6953b?d=https%3A%2F%2Fidenticons.github.com%2Ff7e6dbcbc550339e9dce5e4b13ccc49e.png",
//	      "gravatar_id": "3e6fec2fd77de59951f89112acd6953b",
//	      "url": "https://api.github.com/users/bkaid",
//	      "html_url": "https://github.com/bkaid",
//	      "followers_url": "https://api.github.com/users/bkaid/followers",
//	      "following_url": "https://api.github.com/users/bkaid/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/bkaid/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/bkaid/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/bkaid/subscriptions",
//	      "organizations_url": "https://api.github.com/users/bkaid/orgs",
//	      "repos_url": "https://api.github.com/users/bkaid/repos",
//	      "events_url": "https://api.github.com/users/bkaid/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/bkaid/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//	      {
//	        "url": "https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement",
//	        "name": "enhancement",
//	        "color": "84b6eb"
//	      }
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 1,
//	    "created_at": "2013-07-21T06:03:26Z",
//	    "updated_at": "2013-09-20T15:48:33Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": null,
//	      "diff_url": null,
//	      "patch_url": null
//	    },
//	    "body": "On certain files I want to disable caching by setting this header: \"Cache-Control: no-cache, max-age=0\".  If I set max_age to 0, I only get \"Cache-Control: max-age=0\".  Would be great if when max_age is 0, then no-cache is added as well."
//	  },
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/16",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/16/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/16/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/16/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/issues/16",
//	    "id": 17015052,
//	    "number": 16,
//	    "title": "Changing config settings returns \"No new or changed files to upload\"",
//	    "user": {
//	      "login": "bkaid",
//	      "id": 315615,
//	      "avatar_url": "https://2.gravatar.com/avatar/3e6fec2fd77de59951f89112acd6953b?d=https%3A%2F%2Fidenticons.github.com%2Ff7e6dbcbc550339e9dce5e4b13ccc49e.png",
//	      "gravatar_id": "3e6fec2fd77de59951f89112acd6953b",
//	      "url": "https://api.github.com/users/bkaid",
//	      "html_url": "https://github.com/bkaid",
//	      "followers_url": "https://api.github.com/users/bkaid/followers",
//	      "following_url": "https://api.github.com/users/bkaid/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/bkaid/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/bkaid/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/bkaid/subscriptions",
//	      "organizations_url": "https://api.github.com/users/bkaid/orgs",
//	      "repos_url": "https://api.github.com/users/bkaid/repos",
//	      "events_url": "https://api.github.com/users/bkaid/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/bkaid/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//	      {
//	        "url": "https://api.github.com/repos/laurilehmijoki/s3_website/labels/enhancement",
//	        "name": "enhancement",
//	        "color": "84b6eb"
//	      }
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 1,
//	    "created_at": "2013-07-21T05:08:10Z",
//	    "updated_at": "2013-09-20T15:48:54Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": null,
//	      "diff_url": null,
//	      "patch_url": null
//	    },
//	    "body": "If I deploy my site and then change options, such as max_age or gzip extensions, I can't re-deploy the site with the new settings without getting \"No new or changed files to upload.\"  Maybe a ```s3_website push --force``` option would help."
//	  },
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/5",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/5/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/5/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/5/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/issues/5",
//	    "id": 16286782,
//	    "number": 5,
//	    "title": "Cloudfront invalidation fails",
//	    "user": {
//	      "login": "sud0n1m",
//	      "id": 137983,
//	      "avatar_url": "https://1.gravatar.com/avatar/ca1fb1457515fe98bf1609ee150ad2a5?d=https%3A%2F%2Fidenticons.github.com%2F19fa4b139577ab5554b841cf350d14ab.png",
//	      "gravatar_id": "ca1fb1457515fe98bf1609ee150ad2a5",
//	      "url": "https://api.github.com/users/sud0n1m",
//	      "html_url": "https://github.com/sud0n1m",
//	      "followers_url": "https://api.github.com/users/sud0n1m/followers",
//	      "following_url": "https://api.github.com/users/sud0n1m/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/sud0n1m/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/sud0n1m/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/sud0n1m/subscriptions",
//	      "organizations_url": "https://api.github.com/users/sud0n1m/orgs",
//	      "repos_url": "https://api.github.com/users/sud0n1m/repos",
//	      "events_url": "https://api.github.com/users/sud0n1m/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/sud0n1m/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//	      {
//	        "url": "https://api.github.com/repos/laurilehmijoki/s3_website/labels/bug",
//	        "name": "bug",
//	        "color": "fc2929"
//	      }
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 3,
//	    "created_at": "2013-07-02T20:48:16Z",
//	    "updated_at": "2013-09-20T15:51:58Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": null,
//	      "diff_url": null,
//	      "patch_url": null
//	    },
//	    "body": "Cloudfront invalidation seems to fail with the following error:\r\n\r\n    /Users/sudonim/.rbenv/versions/1.9.3-p194-perf/lib/ruby/gems/1.9.1/gems/simple-cloudfront-invalidator-1.0.0/lib/simple-cloudfront-invalidator.rb:57:in `sign_and_call': AWS API call failed. Reason: (RuntimeError)`\r\n\r\nThe full response is in this Gist:\r\nhttps://gist.github.com/sud0n1m/aceecb10f0e48cfd435a\r\n\r\nIt seems to suggest that I'm sending a malformed response. Is that so?"
//	  },
//	  {
//	    "url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/4",
//	    "labels_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/4/labels{/name}",
//	    "comments_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/4/comments",
//	    "events_url": "https://api.github.com/repos/laurilehmijoki/s3_website/issues/4/events",
//	    "html_url": "https://github.com/laurilehmijoki/s3_website/pull/4",
//	    "id": 16211616,
//	    "number": 4,
//	    "title": "Added support for symlinked directories.",
//	    "user": {
//	      "login": "watbe",
//	      "id": 1361632,
//	      "avatar_url": "https://2.gravatar.com/avatar/10a424322bb680c9f1e804331e8bfe44?d=https%3A%2F%2Fidenticons.github.com%2Feee4ba85029a14aef091acb07504e0a3.png",
//	      "gravatar_id": "10a424322bb680c9f1e804331e8bfe44",
//	      "url": "https://api.github.com/users/watbe",
//	      "html_url": "https://github.com/watbe",
//	      "followers_url": "https://api.github.com/users/watbe/followers",
//	      "following_url": "https://api.github.com/users/watbe/following{/other_user}",
//	      "gists_url": "https://api.github.com/users/watbe/gists{/gist_id}",
//	      "starred_url": "https://api.github.com/users/watbe/starred{/owner}{/repo}",
//	      "subscriptions_url": "https://api.github.com/users/watbe/subscriptions",
//	      "organizations_url": "https://api.github.com/users/watbe/orgs",
//	      "repos_url": "https://api.github.com/users/watbe/repos",
//	      "events_url": "https://api.github.com/users/watbe/events{/privacy}",
//	      "received_events_url": "https://api.github.com/users/watbe/received_events",
//	      "type": "User"
//	    },
//	    "labels": [
//
//	    ],
//	    "state": "open",
//	    "assignee": null,
//	    "milestone": null,
//	    "comments": 1,
//	    "created_at": "2013-07-01T12:26:14Z",
//	    "updated_at": "2013-07-05T02:41:09Z",
//	    "closed_at": null,
//	    "pull_request": {
//	      "html_url": "https://github.com/laurilehmijoki/s3_website/pull/4",
//	      "diff_url": "https://github.com/laurilehmijoki/s3_website/pull/4.diff",
//	      "patch_url": "https://github.com/laurilehmijoki/s3_website/pull/4.patch"
//	    },
//	    "body": "In relation to this issue: https://github.com/laurilehmijoki/s3_website/issues/3 \r\n\r\nI've pushed a fix in filey-diff (https://github.com/laurilehmijoki/filey-diff/pull/5) and also added this small change to fix the issue. Symlinks should now be followed to one depth (to prevent recursive links). \r\n\r\nI might have missed out other directory traversals. I am also not familiar with ruby so you might want to review it."
//	  }
//	]

}
