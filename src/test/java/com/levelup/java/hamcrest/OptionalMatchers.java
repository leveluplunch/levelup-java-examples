package com.levelup.java.hamcrest;

import static com.levelup.java.hamcrest.OptionalMatcher.emptyOptional;
import static com.levelup.java.hamcrest.OptionalMatcher.optionalWithValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;

public class OptionalMatchers {

    class Framework {
        String name;
        int communityUsers;
    }

    @Test
    public void optional_empty () {
        Optional<Framework> optionalFramework = Optional.empty();
        assertThat(optionalFramework, is(emptyOptional()));
    }

    @Test
    public void optional_with_value() {
        Framework framework = new Framework();
        framework.communityUsers = 200000;
        framework.name = "Java";

        Optional<Framework> optionalFramework = Optional.of(framework);

        assertThat(optionalFramework, is(optionalWithValue(framework)));
    }

}
