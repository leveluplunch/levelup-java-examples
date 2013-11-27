package com.levelup.java.collections;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * This java example will demonstrate finding 
 * the cartesian product of two sets.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/cartesian-product/'>Cartesian product</a>
 */
public class CartesianProduct {

	private static final Logger logger = Logger.getLogger(CartesianProduct.class);
	
	@SuppressWarnings("unchecked")
	@Test
	public void cartesian_product_guava () {
		
		Set<String> first = Sets.newHashSet("a", "b");
		Set<String> second = Sets.newHashSet("c", "d");
		
		Set<List<String>> cartesianProduct = Sets.cartesianProduct(first, second);
		
		logger.info(cartesianProduct);
		
		List<String> b_c = Lists.newArrayList("b", "c");
		List<String> b_d = Lists.newArrayList("b", "d");
		List<String> a_c = Lists.newArrayList("a", "c");
		List<String> a_d = Lists.newArrayList("a", "d");
		
		assertThat(cartesianProduct, 
				anyOf(containsInAnyOrder(b_c, b_d, a_c, a_d)));
	}

}
