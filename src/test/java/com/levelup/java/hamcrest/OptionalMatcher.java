package com.levelup.java.hamcrest;


import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Optional;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;


public final class OptionalMatcher {

    private static final Matcher<Optional<?>> EMPTY_OPTIONAL = new BaseMatcher<Optional<?>>() {

        @Override
        @SuppressWarnings("unchecked")
        public boolean matches(Object o) {
            return o instanceof Optional && !((Optional<?>) o).isPresent();
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("empty Optional");
        }
    };

    private OptionalMatcher() {
        throw new UnsupportedOperationException("static test util");
    }

    public static Matcher<Optional<?>> emptyOptional() {
        return EMPTY_OPTIONAL;
    }

    public static <T> Matcher<Optional<? extends T>> optionalWithValue(Matcher<? extends T> valueMatcher) {
        return new BaseMatcher<Optional<? extends T>>() {

            @Override
            @SuppressWarnings("unchecked")
            public boolean matches(Object o) {
                return o instanceof Optional && ((Optional<? extends T>) o).filter(valueMatcher::matches).isPresent();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Optional(");
                description.appendDescriptionOf(valueMatcher);
                description.appendText(")");
            }
        };
    }

    public static <T> Matcher<Optional<? extends T>> optionalWithValue(T value) {
        return optionalWithValue(equalTo(value));
    }
}
