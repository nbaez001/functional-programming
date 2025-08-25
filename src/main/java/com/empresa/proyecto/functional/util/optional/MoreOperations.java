package com.empresa.proyecto.functional.util.optional;

import java.util.Optional;

public class MoreOperations {
    public static void main(String[] args) {
        //ifPresent
        Optional<String> optional = Optional.of("Value");
        optional.ifPresent(val -> System.out.println("This is a " + val));
        Optional<String> optionalEmpty = Optional.empty();
        optionalEmpty.ifPresent(val -> System.out.println("This is a " + val));

        //ifPresentOrElse
        optional.ifPresentOrElse(System.out::println, () -> System.out.println("Value is absent"));
        optionalEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("Value is absent"));

        //stream
        optional.stream().forEach(System.out::println);
        optionalEmpty.stream().forEach(System.out::println);

        //or
        optional.or(()->Optional.of("New Value")).ifPresent(System.out::println);
        optionalEmpty.or(()->Optional.of("New Value")).ifPresent(System.out::println);

        //equals
        System.out.println(optional.equals(Optional.of("Value")));

        //hashcode
        System.out.println(optional.hashCode());
        System.out.println(optionalEmpty.hashCode());
    }
}
