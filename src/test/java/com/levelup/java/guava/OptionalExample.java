package com.levelup.java.guava;

import static org.junit.Assert.assertFalse;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Optional;

public class OptionalExample {
	
	private static final Logger logger = Logger.getLogger(OptionalExample.class);

//	https://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained
//	When you return list, you should always return a new list
	
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
	
	
	
}
