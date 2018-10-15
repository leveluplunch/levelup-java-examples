package com.levelup.java.lombok;

import java.util.Set;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

@Builder
@ToString
public class BuilderExample {

    @Builder.Default private long created = System.currentTimeMillis();
    private String name;
    private int age;
    @Singular private Set<String> occupations;

}