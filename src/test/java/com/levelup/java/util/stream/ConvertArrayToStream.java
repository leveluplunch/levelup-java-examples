package com.levelup.java.util.stream;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class ConvertArrayToStream {

    String[] array = { "a", "b", "c", "d", "e" };

    @Test
    public void convertArrayWithArraysStream() {
        // Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(System.out::println);
    }

    @Test
    public void convertArrayWithStreamOf() {
        // Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(System.out::println);
    }
}
