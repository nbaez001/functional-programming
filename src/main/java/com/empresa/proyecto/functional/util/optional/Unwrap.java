package com.empresa.proyecto.functional.util.optional;

import java.util.Optional;

public class Unwrap {
    public static void main(String[] args) {
        Integer a = 10;
        Optional<Integer> optional = Optional.of(a);

        //get
        Integer integerVal = optional.get();
        System.out.println(integerVal);
        // Exception (No value present)
        Optional<Integer> emptyOptional = Optional.empty();
        //emptyOptional.get();

        //isPresent
        Integer val = emptyOptional.isPresent() ? emptyOptional.get() : 0;
        System.out.println(val);

        //orElse
        Integer orElse = emptyOptional.orElse(0);
        System.out.println(orElse);

        //orElseGet
        Integer orElseGet = emptyOptional.orElseGet(() -> 0);
        System.out.println(orElseGet);

        //orElseThrow
        Integer orElseThrow = emptyOptional.orElseThrow(() -> new IllegalArgumentException());

        //orElseThrow (Java 10)
        emptyOptional.orElseThrow();
    }
}
