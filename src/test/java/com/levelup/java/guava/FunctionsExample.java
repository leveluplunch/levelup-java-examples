package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate guava 
 * functions.  Before you begin using functions
 * be sure to read Caveats <a href="https://code.google.com/p/guava-libraries/wiki/FunctionalExplained">Functional Explained</a>
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-functions-example/'>Guava functions example</a>
 * 
 */
public class FunctionsExample {

	private static final Logger logger = Logger.getLogger(FunctionsExample.class);

	class Person {
		
		private int personId;
		private String jobDescription;
		
		public Person(int personId, String jobDescription) {
			super();
			this.personId = personId;
			this.jobDescription = jobDescription;
		}

		
		public int getPersonId() {
			return personId;
		}

		public String getJobDescription() {
			return jobDescription;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(Person.class)
					.add("personid", personId)
					.add("job description", jobDescription)
					.toString();
		}

	}
	
	class Job {

		private int personId;
		private String description;
		
		public Job(int personId, String description) {
			super();
			this.personId = personId;
			this.description = description;
		}


		public int getPersonId() {
			return personId;
		}

		public String getDescription() {
			return description;
		}		

		
		@Override
		public String toString() {
			return Objects.toStringHelper(Job.class)
					.add("personid", personId)
					.add("job description", description)
					.toString();
		}

	}
	
	Function<Person, Job> mapPersonToJob = new Function<Person, Job>() {
		public Job apply(Person person) {
			Job job = new Job(person.getPersonId(), person.getJobDescription());
			return job;
		}
	};

	/**
	 * Map a list of persons to jobs
	 */
	@Test
	public void map_obects_with_guava_function () {
		
		List<Person> persons = Lists.newArrayList(
				new Person(1, "Husband"),
				new Person(2, "Dad"),
				new Person(3, "Software engineer"),
				new Person(4, "Adjunct instructor"),
				new Person(5, "Pepperoni hanger")
			);
		
		List<Job> jobs = Lists.transform(persons, mapPersonToJob);
		
		logger.info(jobs);
		
		assertEquals(5, jobs.size());
	}
	
}
