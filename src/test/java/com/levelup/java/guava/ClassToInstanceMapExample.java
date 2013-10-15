package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * This java example will demonstrate a use case for ClassToInstanceMap.
 * 
 * In many cases you need to gather multiple objects that relate to each other.  You may make 
 * 1:M db calls to get a set of objects, make web service requests, etc.  For instance, 
 * lets say you have a person, a person has addresses,  a person has jobs.  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-classtoinstancemap-example/'>ClassToInstanceMap Example</a>
 * 
 */
public class ClassToInstanceMapExample {

	private static final Logger logger = Logger.getLogger(ClassToInstanceMapExample.class);
	
	class Person {
		private String name;
		
		public Person(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("name", name)
					.toString();
		}
	}
	
	class Jobs {
		private String jobName;

		public Jobs(String jobName) {
			super();
			this.jobName = jobName;
		}
		
		public String getJobName() {
			return jobName;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("jobName", jobName)
					.toString();
		}
	}
	
	class Address {
		private String streetName;

		public Address(String streetName) {
			super();
			this.streetName = streetName;
		}

		public String getStreetName() {
			return streetName;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("streetName", streetName)
					.toString();
		}
	}
	
	@Test
	public void classToINstanceMap_example () {
		
		Person person = new Person("Jackson");
		Jobs jobs = new Jobs("IT person");
		Address address = new  Address("505 Williams Street");
		
		ClassToInstanceMap<Object> classToInstanceMap = MutableClassToInstanceMap.create();
		classToInstanceMap.put(Person.class, person);
		classToInstanceMap.put(Jobs.class, jobs);
		classToInstanceMap.put(Address.class, address);
		
		logger.info(classToInstanceMap);
		
		assertEquals("IT person", classToInstanceMap.getInstance(Jobs.class).getJobName());
	}
	
}
