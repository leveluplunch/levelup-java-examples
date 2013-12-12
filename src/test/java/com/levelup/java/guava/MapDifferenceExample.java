package com.levelup.java.guava;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate Google Guava's {@link MapDifference}.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/google-guava-map-difference-example/'>Map Difference Example</a>
 */
public class MapDifferenceExample {

	private static final Logger logger = Logger.getLogger(MapDifferenceExample.class);

	class Student {
		
		Integer id;
		String name;
		
		public Student(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("id", id)
					.add("name", name)
					.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private MapDifferenceExample getOuterType() {
			return MapDifferenceExample.this;
		}
	}
	
	Map<Integer, Student> geometryClass;
	Map<Integer, Student> gymClass;
	
	@Before
	public void setUp () {

		List<Student> geoStudents = Lists.newArrayList(
				new Student(123, "Jack Johnson"),
				new Student(456, "Cindy Lewis"),
				new Student(789, "Terry Peters"),
				new Student(912, "Ethan Nicks"),
				new Student(234, "Sarah Perry")
		); 
		
		geometryClass = Maps.uniqueIndex(geoStudents, new Function <Student, Integer> () {
			  public Integer apply(Student student) {
			    return student.id; // or something else
		}});
		
		List<Student> gymStudents = Lists.newArrayList(
				new Student(123, "Jack Johnson"),
				new Student(478, "Patrick Ewig"),
				new Student(789, "Cindy Peters"),
				new Student(937, "Jon Lund"),
				new Student(234, "Sarah Perry")
		); 

		gymClass = Maps.uniqueIndex(gymStudents, new Function <Student, Integer> () {
			  public Integer apply(Student student) {
			    return student.id; // or something else
		}});

	}
	
	@Test
	public void entries_in_common_or_intersection() {

		MapDifference<Integer, Student> mapDifference = Maps.difference(
				geometryClass, gymClass);

		Map<Integer, Student> commonStudents = mapDifference.entriesInCommon();

		logger.info(commonStudents);

		assertThat(commonStudents, hasKey(new Integer(234)));
		assertThat(commonStudents, hasKey(new Integer(123)));
	}

	@Test
	public void entries_differing() {

		MapDifference<Integer, Student> mapDifference = Maps.difference(
				geometryClass, gymClass);

		System.out.println(mapDifference.entriesDiffering()); // with same keys

		Map<Integer, ValueDifference<Student>> sameKeyDifferentValue = mapDifference
				.entriesDiffering();

		assertThat(sameKeyDifferentValue.keySet(), hasItems(new Integer(789)));
	}

	@Test
	public void entries_only_on_left() {

		MapDifference<Integer, Student> mapDifference = Maps.difference(
				geometryClass, gymClass);

		Map<Integer, Student> studentsOnLeft = mapDifference
				.entriesOnlyOnLeft();

		logger.info(studentsOnLeft);

		assertThat(studentsOnLeft, hasKey(new Integer(456)));
		assertThat(studentsOnLeft, hasKey(new Integer(912)));
	}
	
	@Test
	public void entries_only_on_right() {

		MapDifference<Integer, Student> mapDifference = Maps.difference(
				geometryClass, gymClass);

		Map<Integer, Student> studentsOnTheRight = mapDifference
				.entriesOnlyOnRight();

		logger.info(studentsOnTheRight);

		assertThat(studentsOnTheRight, hasKey(new Integer(478)));
		assertThat(studentsOnTheRight, hasKey(new Integer(937)));
	}
	
}
