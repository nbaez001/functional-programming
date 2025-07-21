package com.empresa.proyecto.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
        // iterate method
        Stream.iterate(0, i -> i - 1)
                .limit(15)
                .forEach(System.out::println);

        IntStream.iterate(5, i -> i - 1)
                .limit(15)
                .forEach(System.out::println);

        // generate method
        Stream.generate(new Random()::nextInt)
                .forEach(System.out::println);
    }
}
