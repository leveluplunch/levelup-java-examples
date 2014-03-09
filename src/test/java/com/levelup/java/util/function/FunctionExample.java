package com.levelup.java.util.function;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.levelup.java.guava.FunctionsExample;

/**
 * This java example will demonstrate common uses of the
 * java.util.function.Function
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-function-function-example/'>Function example</a>
 */
public class FunctionExample {

	private static final Logger logger = Logger
			.getLogger(FunctionExample.class);

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
					.add("job description", jobDescription).toString();
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
			return Objects.toStringHelper(Job.class).add("personid", personId)
					.add("job description", description).toString();
		}

	}

	Function<Person, Job> mapPersonToJob = new Function<Person, Job>() {
		public Job apply(Person person) {
			Job job = new Job(person.getPersonId(), person.getJobDescription());
			return job;
		}
	};

	@Test
	public void map_objects_with_java8_function() {

		List<Person> persons = Lists.newArrayList(new Person(1, "Husband"),
				new Person(2, "Dad"), new Person(3, "Software engineer"),
				new Person(4, "Adjunct instructor"), new Person(5,
						"Pepperoni hanger"));

		List<Job> jobs = persons.stream().map(mapPersonToJob)
				.collect(Collectors.toList());

		logger.info(jobs);

		assertEquals(5, jobs.size());
	}

	@Test
	public void apply() {

		Person person = new Person(1, "Description");
		
		Job job = mapPersonToJob.apply(person);
		
		assertEquals("Description", job.getDescription());
	}

}
