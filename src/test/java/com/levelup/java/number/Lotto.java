package com.levelup.java.number;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class Lotto {

    public long binomialCoefficient(int n, int k) {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

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
        System.out.println("lotto 6 aus 49 combinations: " + format(sequences));
    }

    private String format(long input) {
        String pattern = "###,###.###";
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getNumberInstance(spanish);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern(pattern);
        return df.format(input);
    }

    @Test
    public void eurojackpotProbability() {
        long sequences = binomialCoefficient(50, 5) * binomialCoefficient(10, 2);
        System.out.println("eurojackpot combinations: " + format(sequences));
    }

    @Test
    public void eurojackpotGenerator() {
        Integer[] numbers = { 12, 16, 18, 20, 23, 32, 35, 42, 44, 47 };

        Set<Integer> part1 = new TreeSet<>();

        while (part1.size() < 5) {
            int selected = numbers[getRandomIndex()];
            if (!part1.contains(selected)) {
                part1.add(selected);
            }
        }

        Set<Integer> part2 = ImmutableSet.of(5, 8);
        System.out.println("eurojackpot: " + part1 + " + " + part2);
    }

    int getRandomIndex() {
        return ThreadLocalRandom.current().nextInt(10);
    }

    //    int getSecureRandomIndex() {
    //        return new SecureRandom().nextInt(10);
    //    }
}
