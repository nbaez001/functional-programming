package com.empresa.proyecto.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        list.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        list.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        list.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        // Boxing using map and then unboxing using mapToDouble
        OptionalDouble average = list.stream()
                .map(Book::getRating)
                .mapToDouble(rating -> rating)
                .average();

        System.out.println(average.getAsDouble());

        // Without boxing
        OptionalDouble average2 = list.stream()
                .mapToDouble(Book::getRating)
                .average();

        System.out.println(average2.getAsDouble());

        IntStream intS = IntStream.of(1, 3, 5, 8);
        DoubleStream doubleS = DoubleStream.of(1, 3, 5, 8);
        LongStream longS = LongStream.of(1L, 3L, 5L, 8L);

        Stream<Integer> boxedInt = intS.boxed();

        Stream<Double> boxedDouble = doubleS.mapToObj(val -> val);
    }
}
