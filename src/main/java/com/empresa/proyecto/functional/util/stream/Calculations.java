package com.empresa.proyecto.functional.util.stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculations {
    public static void main(String[] args) {
        // sum
        int sum = IntStream.of(1, 2, 3)
                .sum();
        System.out.println(sum);

        // max: primitive optional
        OptionalInt maxOptional = IntStream.of(1, 2, 3)
                .max();
        System.out.println(maxOptional.getAsInt());

        // mix: primitive optional
        OptionalInt minOptional = IntStream.of(1, 2, 3, 4)
                .min();
        System.out.println(minOptional.getAsInt());

        // average
        OptionalDouble avgOptional = IntStream.of(1, 2, 3, 4)
                .average();
        System.out.println(avgOptional.getAsDouble());

        // summaryStatistics
        IntSummaryStatistics summary = IntStream.of(1, 2, 3, 4)
                .summaryStatistics();
        System.out.println(summary);
    }
}
