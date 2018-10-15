package com.levelup.java.collections;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.ImmutableSet;

public class CheckCollectionIsEmpty {

    @Test
    public void null_map_is_empty() {
        Map<Integer, String> nullMap = null;
        assertTrue(CollectionUtils.isEmpty(nullMap));
    }

    @Test
    public void empty_map_is_empty() {
        Map<Integer, String> emptyMap = new HashMap<>();
        assertTrue(CollectionUtils.isEmpty(emptyMap));
    }

    @Test
    public void map_is_not_empty() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(new Integer(1), "one");
        numbers.put(new Integer(2), "two");

        assertFalse(CollectionUtils.isEmpty(numbers));
    }

    @Test
    public void list_is_empty() {
        List<String> emptyList = new ArrayList<>();
        assertTrue(CollectionUtils.isEmpty(emptyList));
    }

    @Test
    public void set_is_not_empty() {
        Set<String> set = ImmutableSet.of("oneString");
        assertFalse(CollectionUtils.isEmpty(set));
    }
}
