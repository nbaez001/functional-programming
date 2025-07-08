package com.empresa.proyecto.functionalprogramming;

import java.util.Objects;
import java.util.function.Function;

public class Chaining {
    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = System.out::println;
        c1.accept("Hello");
        c2.accept("Hello");

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };
        c3.accept("Hello");

        Consumer<String> c4 = c1.thenAccept(c2);
        c4.accept("BasicStrong");

        //Consumer<String> c5 = c1.thenAccept(null);
        //c5.accept("BasicStrong2");

        Function<Integer, Integer> f1 = s -> s + 2;
        Function<Integer, Integer> f2 = s -> s * 2;
        Function<Integer, Integer> f3 = f1.andThen(f2);
        Integer res = f3.apply(7);
        System.out.println(res);
    }
}

interface Consumer<T> {
    void accept(T t);

    default Consumer<T> thenAccept(Consumer<T> c2) {
        Objects.requireNonNull(c2);
        return t -> {
            this.accept(t);
            c2.accept(t);
        };
    }
}