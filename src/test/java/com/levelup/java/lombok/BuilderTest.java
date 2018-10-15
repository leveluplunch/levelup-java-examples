package com.levelup.java.lombok;

import org.junit.Test;

public class BuilderTest {

    @Test
    public void builderTest() {
        BuilderExample example = BuilderExample.builder()
                .name("myName")
                .age(17)
                .occupation("student")
                .build();
        System.out.println(example.toString());
    }

}
