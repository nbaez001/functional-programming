package com.empresa.proyecto.functional.util.stream;

import java.util.stream.Stream;

public class ReduceOperation {
    public static void main(String[] args) {
        Integer sum = Stream.of(1, 2, 34, 56, 76, 87, 89, 90)
                .reduce(0, (a, b) -> a + b); // sum operation
        System.out.println(sum);
    }
}
