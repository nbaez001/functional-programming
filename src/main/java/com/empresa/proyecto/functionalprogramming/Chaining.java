package com.empresa.proyecto.functionalprogramming;

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
    }
}

interface Consumer<T> {
    void accept(T t);

    default Consumer<T> thenAccept(Consumer<T> c2) {
        return t -> {
            this.accept(t);
            c2.accept(t);
        };
    }
}
