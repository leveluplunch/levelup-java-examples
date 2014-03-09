package com.levelup.java.util.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to use the Stream.groupingBy.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/java-util-stream-groupingBy-example/'>Stream
 *      groupingBy</a>
 */
public class StreamGroupBy {

	private static final Logger logger = Logger.getLogger(StreamGroupBy.class);

	class StudentClass {

		private String teacher;
		private double level;
		private String className;

		public StudentClass(String teacher, double level, String className) {
			super();
			this.teacher = teacher;
			this.level = level;
			this.className = className;
		}

		public String getClassName() {
			return className;
		}

		public String getTeacher() {
			return teacher;
		}

		public double getLevel() {
			return level;
		}

		@Override
		public String toString() {
			return com.google.common.base.Objects.toStringHelper(this)
					.add("teacher", teacher).add("level", level)
					.add("className", className).toString();
		}

	}

	private List<StudentClass> studentClasses;

	@Before
	public void setUp() {

		studentClasses = new ArrayList<>();

		studentClasses.add(new StudentClass("Kumar", 101, "Intro to Web"));
		studentClasses.add(new StudentClass("White", 102, "Advanced Java"));
		studentClasses.add(new StudentClass("Kumar", 101, "Intro to Cobol"));
		studentClasses.add(new StudentClass("Sargent", 101, "Intro to Web"));
		studentClasses.add(new StudentClass("Sargent", 102, "Advanced Web"));
	}

	@Test
	public void group_by_teacher_name() {

		Map<String, List<StudentClass>> groupByTeachers = studentClasses
				.stream().collect(
						Collectors.groupingBy(StudentClass::getTeacher));

		logger.info(groupByTeachers);

		assertEquals(1, groupByTeachers.get("White").size());
	}

	@Test
	public void group_by_level() {

		Map<Double, List<StudentClass>> groupByLevel = studentClasses.stream()
				.collect(Collectors.groupingBy(StudentClass::getLevel));

		logger.info(groupByLevel);

		assertEquals(3, groupByLevel.get(101.0).size());
	}

	@Test
	public void group_by_count() {

		Map<Double, Long> groupByLevel = studentClasses.stream().collect(
				Collectors.groupingBy(StudentClass::getLevel,
						Collectors.counting()));

		logger.info(groupByLevel);

		assertEquals(2.0, groupByLevel.get(102.0), 0);
	}

}
