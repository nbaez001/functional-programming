package com.empresa.proyecto.functional.util.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOperation {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("Hello", "there!");
        Stream<String> b = Stream.of("Learning", "Java?");

        // Stream of streams
        Stream<Stream<String>> c = Stream.of(a, b);

        // Example 1 (flatten Stream<Stream<T>>)
        Stream.of(a, b)
                .flatMap(e -> e)
                .forEach(System.out::println);

        // Example 2 (flatten Stream<String[]>)
        Path p = Paths.get("C:/nerio/trabajo/disney/proyectos/functional-programming/src/main/java/com/empresa/proyecto/stream/notebook.txt");
        try (Stream<String> notebook = Files.lines(p)) {
            List<String> collect = notebook
                    .flatMap(line-> Arrays.stream(line.split(" ")))
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
