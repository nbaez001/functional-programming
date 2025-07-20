package com.empresa.proyecto.stream;

import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
        Stream.iterate(0, i -> i + 1);
    }
}
