package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * This java example will demonstrate how to check if every 
 * element in the collection satisfies a specified condition.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/list-contains-all-elements/'>List contains all elements</a>
 */
public class ListContainsAll {

	class Camera {
		
		String name;
		int focalLength;
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("name", name)
					.add("focallength", focalLength)
					.toString();
		}
		
		public Camera(String name, int focalLength) {
			super();
			this.name = name;
			this.focalLength = focalLength;
		}
	}
	
	List<Camera> cameras;
	
	@Before
	public void setUp () {
		cameras = Lists.newArrayList();
		
		cameras.add(new Camera("Nikon", 80));
		cameras.add(new Camera("Cannon", 135));
		cameras.add(new Camera("Kodak", 300));
		cameras.add(new Camera("Olympus", 200));
		cameras.add(new Camera("Fujifilm", 600));
	}
	
	@Test
	public void list_contains_all_java () {
		
		boolean allCamerasOfMediumTelephoto = true;
		
		for (Camera camera : cameras) {
			if (camera.focalLength < 80) {
				allCamerasOfMediumTelephoto = false;
				break;
			}
		}
		
		assertTrue(allCamerasOfMediumTelephoto);
	}

	@Test
	public void list_contains_all_java8_lambda () {
		
		boolean allCamerasOfMediumTelephoto = 
				cameras.stream().allMatch(p -> p.focalLength >= 80);
		
		assertTrue(allCamerasOfMediumTelephoto);
	}
	
	@Test
	public void list_contains_all_guava () {
		
		boolean allCamerasOfMediumTelephoto = Iterables.all(cameras, new Predicate<Camera>() {
			public boolean apply(Camera input) {
				return input.focalLength >= 80;
			}
		});
		
		assertTrue(allCamerasOfMediumTelephoto);
	}
	
	
	@Test
	public void list_contains_all_apache () {
		
		@SuppressWarnings("unchecked")
		Collection<Camera> mediumTelephotoCameras = CollectionUtils.select(cameras, 
				new org.apache.commons.collections.Predicate() {
			public boolean evaluate(Object object) {
				Camera camera = (Camera) object;
				return camera.focalLength >= 80;
			}
		});
		
		assertTrue(mediumTelephotoCameras.size() == cameras.size());
	}
	
}
