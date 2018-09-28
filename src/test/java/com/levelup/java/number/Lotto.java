package com.levelup.java.number;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class Lotto {

    public long binomialCoefficient(int n, int k) {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if ( k > n - k )
            k = n - k;

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    @Test
    public void lotto6aus49Probability() {
        long sequences = binomialCoefficient(49, 6) * 10;
        System.out.println("lotto6aus49 combinations: " + sequences);
    }

    @Test
    public void eurojackpotProbability() {
        long sequences = binomialCoefficient(50, 5) * binomialCoefficient(10, 2);
        System.out.println("eurojackpot combinations: " + sequences);
    }

    @Test
    public void eurojackpotGenerator() {
        Integer[] numbers = { 12,16,18,20,23,32,35,42,44,47};

        Set<Integer> part1 = new HashSet<>();

        while (part1.size() < 5) {
            int selected = numbers[getRandomIndex()];
            if (!part1.contains(selected)) {
                part1.add(selected);
            }
        }

        Set<Integer> part2 = ImmutableSet.of(5,8);
        System.out.println(part1 + " + "  + part2);
    }

    int getRandomIndex() {
        return ThreadLocalRandom.current().nextInt(10);
    }
}
