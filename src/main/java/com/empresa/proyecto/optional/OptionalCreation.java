package com.empresa.proyecto.optional;

import java.util.Optional;

public class OptionalCreation {
    public static void main(String[] args) {
        String val = "A String";
        Optional<String> optional = Optional.of(val);

        //empty
        Optional<Integer> empty = Optional.empty();

        //nullable
        Optional<String> nullable = Optional.ofNullable(val);
        Optional<String> emptyOptional = Optional.ofNullable(null);
    }
}
