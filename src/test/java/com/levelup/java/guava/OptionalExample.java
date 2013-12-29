package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate Google
 * Optional.  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-optional-example/'>Optional example</a>
 * 
 */
public class OptionalExample {
	
	private static final Logger logger = Logger.getLogger(OptionalExample.class);

	class PullRequest {
		
		String person;
		String summary;
		String comments;
		
		public PullRequest(String person, String summary, String comments) {
			super();
			this.person = person;
			this.summary = summary;
			this.comments = comments;
		}

		public String getPerson() {
			return person;
		}

		public String getSummary() {
			return summary;
		}

		public String getComments() {
			return comments;
		}
	}
	
	private PullRequest getPullRequestReturningNull () {
		PullRequest pr = null; // make some data access call, if it isn't there return null
		return pr;
	}
	
	@Test
	public void returning_null_in_java () {
		
		PullRequest pr = getPullRequestReturningNull();
		if (pr != null) {
			pr.getComments();
		}
	}

	/**
	 * Added suppression purely for demonstration purposes as the optional.of will never get called.
	 * @return
	 */
	@SuppressWarnings("unused")
	private Optional<PullRequest> getPullRequestUsingGuavaOptional () {
	
		PullRequest pr = null; // make some data access call, if it isn't there return null
	
		if (pr == null) {
			return Optional.absent();
		} else {
			return Optional.of(pr);	
		}
	}
	
	
	@Test
	public void avoid_checking_for_null_with_guava_optional () {
		Optional<PullRequest> pr = getPullRequestUsingGuavaOptional ();
		
		if (pr.isPresent()) {

			PullRequest pullRequest = pr.get();
			
			// proceed with further processing
			logger.info(pullRequest);
			
		} else {
			// do nothing
			logger.info("object was null"); 
		}
		
		assertFalse(pr.isPresent());
	}
	
	@Test
	public void get_first_non_null_object () {
		
		Optional<String> first = Optional.absent();
		Optional<String> second = Optional.of("Game Day!");
		
		assertEquals(second.get(), first.or(second).get());
	}
	
	@Test
	public void from_nullable() {

		Optional<PullRequest> pullRequest = Optional
				.fromNullable(new PullRequest("Jack", "summary", "comments"));
		
		assertTrue(pullRequest.isPresent());
	}
	
	@Test
	public void present_instances () {
		
		List<Optional<PullRequest>> pullRequests = Lists.newArrayList();
		pullRequests.add(getPullRequestUsingGuavaOptional());
		pullRequests.add(Optional.of(new PullRequest("Graham", "a->b summary",  "please merge")));
		pullRequests.add(getPullRequestUsingGuavaOptional());
		pullRequests.add(Optional.of(new PullRequest("Jesse", "c->d summary",  "check code")));
		
		Iterable<PullRequest> presentInstances = Optional.presentInstances(pullRequests);
		
		assertThat(presentInstances, IsIterableWithSize.<PullRequest>iterableWithSize(2));
	}
}
