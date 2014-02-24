package com.levelup.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * This java example will demonstrate uses of 
 * java.util.Optional.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-optional-example/'>Optional example</a>
 */
public class OptionalExample {

	class Framework {
		
		String name;
		int communityUsers;		
	}
	
	@Test
	public void optional_get () {
		
		Framework framework = new Framework();
		framework.communityUsers = 200000;
		framework.name = "Java";
		
		Optional<Framework> optionalFramework = Optional.of(framework);

		assertEquals("Java", optionalFramework.get().name);
	}

	@Test
	public void optional_ifPresent () {
		
		Framework framework = new Framework();
		framework.communityUsers = 200000;
		framework.name = "Java";
		
		Optional<Framework> optionalFramework = Optional.of(framework);
		
		optionalFramework.ifPresent(p -> System.out.println(p.name));
		
		// or 
		
		optionalFramework.ifPresent(System.out::println);
	}

	
	@Test 
	public void optional_ispresent () {
		
		Optional<Framework> framework = Optional.of(new Framework());
		
		assertTrue(framework.isPresent());
	}
		
	@Test
	public void optional_orElse () {

		Framework framework = new Framework();
		framework.communityUsers = 200000;
		framework.name = "Java";
		
		Optional<Framework> nullOptional = Optional.ofNullable(null);
		
		Framework orElseFramework = nullOptional.orElse(framework);
		
		assertEquals("Java", orElseFramework.name);
	}	

	@Test
	public void optional_orElseGet () {
		
		Optional<Framework> optionalFramework = Optional.empty();

		Supplier<Framework> defaulFramework = new Supplier<OptionalExample.Framework>() {

			@Override
			public Framework get() {
				Framework framework = new Framework();
				framework.communityUsers = 200000;
				framework.name = "Java";
				return framework;
			}
			
		}; 
		
		Framework framework = optionalFramework.orElseGet(defaulFramework);
		
		assertEquals("Java", framework.name);
	}	
	
	@Test(expected=IllegalStateException.class)
	public void optional_orElseThrow () {
		
		Optional<Framework> optionalFramework = Optional.empty();

		optionalFramework.orElseThrow(IllegalStateException::new);
		
	}	

	@Test
	public void optional_empty () {
		
		Optional<Framework> optionalFramework = Optional.empty();
		
		assertFalse(optionalFramework.isPresent());
	}	

	@Test
	public void optional_of() {
		
		Framework framework = new Framework();
		framework.communityUsers = 10000;
		framework.name = "Scala";
		
		Optional<Framework> optionalFramework = Optional.of(framework);

		assertEquals("Scala", optionalFramework.get().name);
	}

	@Test
	public void optional_ofNullable () {
		
		Optional<Framework> optionalFramework = Optional.ofNullable(null);

		assertFalse(optionalFramework.isPresent());
	}	

	
}
