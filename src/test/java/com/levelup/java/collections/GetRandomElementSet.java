package com.levelup.java.collections;

import java.util.Random;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class GetRandomElementSet {

    static <E> E getRandomElementFromSet(Set<E> set) {
        return set.stream().skip(new Random().nextInt(set.size()))
                .findFirst()
                .orElse(null);
    }

    @Test
    public void random_element_set() {
        Set<String> phoneMakers = ImmutableSet.of("Apple", "Samsung", "Huawei", "Xiaomi");
        String element = getRandomElementFromSet(phoneMakers);
        System.out.println(element);

    }
}
